
package com.axyus.agendawebapp.bo;

import com.axyus.agendawebapp.utils.JdbcUtils;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Address {

    //On utilise l'objet Integer plutôt que int pcq int n'est pas un objet et ne peut donc pas être égal à null
    private Integer addressId;
    private Integer streetNumber;
    private String streetName;
    private String city;
    private String postalCode;
    private String country;

    public Address() {
    }

    public Address(int addressId, int streetNumber, String streetName, String city, String postalCode, String country) {
        this.addressId = addressId;
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address(int streetNumber, String streetName, String city, String postalCode, String country) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address(ResultSet rs) throws SQLException {
        this.addressId = JdbcUtils.getIntIfColumnExists(rs,"address_id");
        this.streetNumber = JdbcUtils.getIntIfColumnExists(rs,"street_number");
        this.streetName = JdbcUtils.getStringColumnIfExists(rs,"street_name");
        this.city = JdbcUtils.getStringColumnIfExists(rs,"city");
        this.postalCode = JdbcUtils.getStringColumnIfExists(rs, "postal_code");
        this.country = JdbcUtils.getStringColumnIfExists(rs,"country");
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" + "addressId=" + addressId + ", streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city + ", postalCode=" + postalCode + ", country=" + country + '}';
    }

}
