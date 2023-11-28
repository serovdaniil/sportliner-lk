package by.sportliner.lk.core.support.jpa.type;

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
import java.util.UUID;

/**
 * Provides support for mapping PostgreSQL {@code UUID} type to {@link String}.
 */
public class PgUuidAsStringType implements UserType<String> {

    @Override
    public int getSqlType() {
        return Types.JAVA_OBJECT;
    }

    @Override
    public Class<String> returnedClass() {
        return String.class;
    }

    @Override
    public boolean equals(String x, String y) {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(String x) {
        return x == null ? 0 : x.hashCode();
    }

    @Override
    public String nullSafeGet(ResultSet rs, int position, SharedSessionContractImplementor session, Object owner)
        throws SQLException {

        String cellContent = rs.getString(position);
        if (cellContent == null) {
            return null;
        }
        try {
            return new String(cellContent.getBytes(StandardCharsets.UTF_8));
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to convert String to Invoice: " + e.getMessage(), e);
        }
    }

    @Override
    public void nullSafeSet(PreparedStatement st, String value, int index, SharedSessionContractImplementor session)
        throws SQLException {

        if (value == null) {
            st.setNull(index, Types.OTHER);
            return;
        }
        try {
            st.setObject(index, UUID.fromString(value), Types.OTHER);
        }
        catch (Exception ex) {
            throw new RuntimeException("Failed to convert Invoice to String: " + ex.getMessage(), ex);
        }
    }

    @Override
    public String deepCopy(String value) {
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
            return obj.toString();
        }
        catch (ClassNotFoundException | IOException ex) {
            throw new HibernateException(ex);
        }
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(String value) {
        return deepCopy(value);
    }

    @Override
    public String assemble(Serializable cached, Object owner) {
        return deepCopy(cached.toString());
    }

    @Override
    public String replace(String detached, String managed, Object owner) {
        return deepCopy(detached);
    }
}

