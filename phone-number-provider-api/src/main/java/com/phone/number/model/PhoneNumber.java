package com.phone.number.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phone_number")
public class PhoneNumber {

    @Id
    @GeneratedValue
    private long id;

    private String number;

    @Column(name = "available_numbers")
    private String availableNumbers;

    public PhoneNumber() {
    }

    public PhoneNumber(String number, String availableNumbers) {
        this.number = number;
        this.availableNumbers = availableNumbers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAvailableNumbers() {
        return availableNumbers;
    }

    public void setAvailableNumbers(String availableNumbers) {
        this.availableNumbers = availableNumbers;
    }
}
