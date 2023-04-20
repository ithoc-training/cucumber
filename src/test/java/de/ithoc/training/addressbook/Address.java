package de.ithoc.training.addressbook;

public class Address {

    private Long id;
    private String street;
    private String houseNo;
    private String postCode;
    private String city;

    public Address(String street, String houseNo, String postCode, String city) {
        this.street = street;
        this.houseNo = houseNo;
        this.postCode = postCode;
        this.city = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }

}
