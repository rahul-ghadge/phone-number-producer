package com.phone.number.repository;

import com.phone.number.model.PhoneNumber;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.OrderBy;
import java.util.List;

@Repository
public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
    @OrderBy("number")
    List<PhoneNumber> findByNumber(String number);

    List<PhoneNumber> findByNumber(@Param("number") String number, Pageable p);
}
