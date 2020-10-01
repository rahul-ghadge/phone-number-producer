package com.phone.number.controller;


import com.phone.number.model.PhoneNumber;
import com.phone.number.repository.PhoneNumberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/number")
public class RestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PhoneNumberRepository repository;

    @GetMapping("/{number}")
    public List<PhoneNumber> getPhoneNumbers(@PathVariable String number) {

        logger.info("Phone number :: {}", number);
        createAlphanumericCombinations(number);
        return repository.findByNumber(number);
    }

    @GetMapping()
    public List<PhoneNumber> getAllPhoneNumbers() {
        return repository.findAll();
    }


    private void createAlphanumericCombinations(String number) {

        String originalNumber = number;
        number = number.substring(0, number.length() - 1);

        for (char ch = 'a'; ch <= 'z'; ch++) {
            repository.save(new PhoneNumber(originalNumber, (number + ch)));
        }
    }

}
