package by.sportliner.lk.core.model;

import by.sportliner.lk.core.support.jpa.type.PgUuidAsStringType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.util.ProxyUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * Base abstract class for persistent data objects.
 *
 * @see org.springframework.data.jpa.domain.AbstractPersistable
 */
@MappedSuperclass
public abstract class AbstractDataObject implements Serializable {

    /**
     * Unique identifier.
     */
    @Id
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "UUID")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(value = PgUuidAsStringType.class)
    private String id;

    public String getId() {
        return id;
    }

    protected void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }

        if (!getClass().equals(ProxyUtils.getUserClass(o))) {
            return false;
        }

        AbstractDataObject that = (AbstractDataObject) o;

        if (this.getId() != null && that.getId() != null) {
            return Objects.equals(this.getId(), that.getId());
        }

        // non-persisted yet instances (id == null) should be considered as different entities
        return false;
    }

    @Override
    public int hashCode() {
        if (getId() != null) {
            return Objects.hash(getId());
        }
        else {
            return System.identityHashCode(this);
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
            "id='" + id + '\'' +
            '}';
    }
}
