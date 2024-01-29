package by.sportliner.lk.core.model;

import by.sportliner.lk.core.support.jpa.type.BranchOfficeAddressJsonbType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import java.util.List;

/**
 * Branch office.
 */
@Entity
@Table(name = "branch_office")
public class BranchOffice extends AbstractDataObject {

    /**
     * Name.
     */
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    /**
     * Address.
     */
    @Column(name = "address", nullable = false)
    @Type(BranchOfficeAddressJsonbType.class)
    private BranchOfficeAddress address;

    /**
     * Class schedules.
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "class_schedule", joinColumns = @JoinColumn(name = "branch_office_id", nullable = false))
    private List<ClassSchedule> classSchedules;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BranchOfficeAddress getAddress() {
        return address;
    }

    public void setAddress(BranchOfficeAddress address) {
        this.address = address;
    }

    public List<ClassSchedule> getClassSchedules() {
        return classSchedules;
    }

    public void setClassSchedules(List<ClassSchedule> classSchedules) {
        this.classSchedules = classSchedules;
    }

    public static class BranchOfficeAddress implements Serializable {

        private String city;

        private String street;

        private String buildingNumber;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getBuildingNumber() {
            return buildingNumber;
        }

        public void setBuildingNumber(String buildingNumber) {
            this.buildingNumber = buildingNumber;
        }

        @JsonIgnore
        public String getFullAddress() {
            return "${city}, ${street}, ${buildingNumber}"
                .replace("${city}", city)
                .replace("${street}", street)
                .replace("${buildingNumber}", buildingNumber);
        }
    }
}
