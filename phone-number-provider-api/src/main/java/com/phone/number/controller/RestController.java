package com.phone.number.controller;


import com.phone.number.model.PhoneNumber;
import com.phone.number.repository.PhoneNumberRepository;
import com.phone.number.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/number")
public class RestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PhoneNumberRepository repository;

    @GetMapping
    public ResponseEntity<Response> getPhoneNumbers(@RequestParam(name = "number") String number,
                                                    @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                                    @RequestParam(name = "size", required = false, defaultValue = "20") int size) {

        logger.info("Phone number :: {}", number);
        createAlphanumericCombinations(number);
        List<PhoneNumber> list = repository.findByNumber(number);

        Response response = new Response();
        response.setCount(list.size());
        response.setNumbers(
                list.stream().skip(page - 1 <= 0 ? 0 : (page - 1 * size))
                        .limit(size)
                        .collect(Collectors.toList()));

        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PhoneNumber>> getAllPhoneNumbers() {
        return ResponseEntity.ok(repository.findAll());
    }


    private void createAlphanumericCombinations(String number) {

        String originalNumber = number;
        number = number.substring(0, number.length() - 1);

        for (char ch = 'a'; ch <= 'z'; ch++) {
            repository.save(new PhoneNumber(originalNumber, (number + ch)));
        }
    }

}
