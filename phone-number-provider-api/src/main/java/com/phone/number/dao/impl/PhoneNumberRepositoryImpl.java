package com.phone.number.dao.impl;

import com.phone.number.dao.PhoneNumberDAO;
import com.phone.number.model.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PhoneNumberRepositoryImpl implements PhoneNumberDAO {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<PhoneNumber> getCombinationOfNumbers(String number, int pageNo, int size) {



        List<PhoneNumber> list =  entityManager.createNativeQuery("select * from phone_number pn where pn.number = ?", PhoneNumber.class)
                .setParameter(1, number)
                .setFirstResult((pageNo-1) <= 0 ? 0 : (pageNo-1) * size)
                .setMaxResults(size)
                .getResultList();
        logger.info("Phone Numbers :: {}", list);

        return list;
    }
}
