package com.phone.number.controller;


import com.phone.number.dao.PhoneNumberDAO;
import com.phone.number.model.PhoneNumber;
import com.phone.number.repository.PhoneNumberRepository;
import com.phone.number.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/number")
public class RestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PhoneNumberRepository repository;

    @Autowired
    private PhoneNumberDAO dao;

    @GetMapping
    public ResponseEntity<Response> getPhoneNumbers(@RequestParam(name = "number") String number,
                                                    @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                                    @RequestParam(name = "size", required = false, defaultValue = "20") int size) {

        logger.info("Phone number :: {}", number);
        logger.info("Page number :: {}", page);
        logger.info("Size :: {}", size);

        Set<String> set = createAlphanumericCombinations(number);
        Response response = new Response();
        response.setCount(set.size());

        set.forEach(num -> repository.save(new PhoneNumber(number, num)));

        response.setNumbers(dao.getCombinationOfNumbers(number, page, size));

        return ResponseEntity.ok(response);
    }

    private Set<String> createAlphanumericCombinations(String number) {

        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < number.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                set.add(number.substring(0, i) + ch + number.substring(i + 1));
            }
        }
        for (int i = 0; i < number.length(); i++) {
            for (int j = 0; j <= 9; j++) {
                set.add(number.substring(0, i) + j + number.substring(i + 1));
            }
        }
        set.remove(number);

        return set;
    }

}
