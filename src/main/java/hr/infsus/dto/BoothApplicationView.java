package hr.infsus.dto;

import hr.infsus.model.BoothApplication;

public class BoothApplicationView {
    private Long id;
    private String name;
    private Long boothNumber;
    private String boothName;
    private String approved;
    private boolean paid;

    public BoothApplicationView(BoothApplication boothApplication) {
        this.id = boothApplication.getId();
        this.name = boothApplication.getName();
        this.boothNumber = boothApplication.getBoothNumber();
        this.boothName = boothApplication.getBoothName();
        this.approved = boothApplication.isApproved();
        this.paid = boothApplication.isPaid();
    }

    public BoothApplicationView(){}

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

    public String isApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
