package com.phone.number.controller;


import com.phone.number.dao.PhoneNumberDAO;
import com.phone.number.model.PhoneNumber;
import com.phone.number.repository.PhoneNumberRepository;
import com.phone.number.response.Response;
import com.phone.number.utils.NumberCombination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/number")
public class RestController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PhoneNumberRepository repository;

    @Autowired
    private PhoneNumberDAO dao;

   public ResponseEntity<Response> getPhoneNumbers(@RequestParam(name = "number") String number,
                                                    @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                                    @RequestParam(name = "size", required = false, defaultValue = "20") int size) {

        logger.info("Phone number :: {}", number);
        logger.info("Page number :: {}", page);
        logger.info("Size :: {}", size);

       List<String> list = createAlphanumericCombinations(number);
       NumberCombination combination = new NumberCombination();
       list.addAll(combination.permute(number));

       Response response = new Response();
       response.setCount(list.size());

       list.forEach(num -> repository.save(new PhoneNumber(number, num)));

       response.setNumbers(dao.getCombinationOfNumbers(number, page, size));

       return ResponseEntity.ok(response);
    }

    private List<String> createAlphanumericCombinations(String number) {
        List<String> list = new ArrayList<>();
        number = number.substring(0, number.length() - 1);
        for (char ch = 'a'; ch <= 'z'; ch++) {
            list.add(number + ch);
        }
        return list;
    }

}
