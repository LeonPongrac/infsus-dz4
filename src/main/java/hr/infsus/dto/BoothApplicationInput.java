package hr.infsus.dto;

public class BoothApplicationInput {
    private String name;
    private String email;
    private String phone;
    private Long boothNumber;
    private String boothName;
    private String boothDetails;

    public BoothApplicationInput() {
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
}
