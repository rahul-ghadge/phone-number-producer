package com.phone.number.dao;

import com.phone.number.model.PhoneNumber;

import java.util.List;

public interface PhoneNumberDAO {

    List<PhoneNumber> getCombinationOfNumbers(String number, int pageNo, int size);
}
