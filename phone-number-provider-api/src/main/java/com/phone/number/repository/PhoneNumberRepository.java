package com.phone.number.repository;

import com.phone.number.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {

    @RestResource(path = "find-by-number")
    List<PhoneNumber> findByNumber(String number);
}
