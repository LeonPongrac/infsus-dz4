package hr.infsus.model;

import jakarta.persistence.*;

@Entity
public class BoothApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Long boothNumber;
    private String boothName;
    private String boothDetails;
    private String status;
    private boolean paid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getBoothNumber() {
        return boothNumber;
    }

    public void setBoothNumber(Long boothNumber) {
        this.boothNumber = boothNumber;
    }

    public String getBoothName() {
        return boothName;
    }

    public void setBoothName(String boothName) {
        this.boothName = boothName;
    }

    public String getBoothDetails() {
        return boothDetails;
    }

    public void setBoothDetails(String boothDetails) {
        this.boothDetails = boothDetails;
    }

    public String isApproved() {
        return status;
    }

    public void setStatus(String approved) {
        this.status = approved;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
