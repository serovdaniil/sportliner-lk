package by.sportliner.lk.core.support.jpa.type;

import by.sportliner.lk.core.model.BranchOffice;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Objects;

/**
 * Provides support for mapping PostgreSQL {@code JSONB} type to {@link BranchOffice.BranchOfficeAddress}.
 */
public class BranchOfficeAddressJsonbType implements UserType<BranchOffice.BranchOfficeAddress> {

    @Override
    public int getSqlType() {
        return Types.JAVA_OBJECT;
    }

    @Override
    public Class<BranchOffice.BranchOfficeAddress> returnedClass() {
        return BranchOffice.BranchOfficeAddress.class;
    }

    @Override
    public BranchOffice.BranchOfficeAddress nullSafeGet(ResultSet rs,
                                                        int position,
                                                        SharedSessionContractImplementor session,
                                                        Object owner) throws SQLException {
        String cellContent = rs.getString(position);
        if (cellContent == null) {
            return null;
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(cellContent.getBytes(StandardCharsets.UTF_8), returnedClass());
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to convert String to Invoice: " + e.getMessage(), e);
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement ps,
                            BranchOffice.BranchOfficeAddress value,
                            int index,
                            SharedSessionContractImplementor session)
        throws HibernateException, SQLException {

        if (value == null) {
            ps.setNull(index, Types.OTHER);
            return;
        }
        try {
            ObjectMapper mapper = new ObjectMapper();
            StringWriter w = new StringWriter();
            mapper.writeValue(w, value);
            w.flush();
            ps.setObject(index, w.toString(), Types.OTHER);
        }
        catch (Exception ex) {
            throw new RuntimeException("Failed to convert Invoice to String: " + ex.getMessage(), ex);
        }
    }

    @Override
    public BranchOffice.BranchOfficeAddress deepCopy(BranchOffice.BranchOfficeAddress value) throws HibernateException {
        if (value == null) {
            return null;
        }

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(value);
            oos.flush();
            oos.close();
            bos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(bos.toByteArray());
            Object obj = new ObjectInputStream(bais).readObject();
            bais.close();
            return (BranchOffice.BranchOfficeAddress) obj;
        }
        catch (ClassNotFoundException | IOException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public boolean equals(BranchOffice.BranchOfficeAddress x, BranchOffice.BranchOfficeAddress y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(BranchOffice.BranchOfficeAddress x) throws HibernateException {
        return x == null ? 0 : x.hashCode();
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(BranchOffice.BranchOfficeAddress value) throws HibernateException {
        return (Serializable) deepCopy(value);
    }

    @Override
    public BranchOffice.BranchOfficeAddress assemble(Serializable cached, Object owner) throws HibernateException {
        return deepCopy((BranchOffice.BranchOfficeAddress) cached);
    }

    @Override
    public BranchOffice.BranchOfficeAddress replace(BranchOffice.BranchOfficeAddress original,
                                                    BranchOffice.BranchOfficeAddress target,
                                                    Object owner) throws HibernateException {
        return deepCopy(original);
    }
}
