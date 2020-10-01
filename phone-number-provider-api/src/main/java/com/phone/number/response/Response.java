package com.phone.number.response;

import com.phone.number.model.PhoneNumber;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {

    long count;
    List<PhoneNumber> numbers;

    public Response() {
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<PhoneNumber> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<PhoneNumber> numbers) {
        this.numbers = numbers;
    }


}
