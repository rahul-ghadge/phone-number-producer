package com.phone.number.controller;

import com.phone.number.PhoneNumberProviderApiApplicationTests;
import com.phone.number.dao.PhoneNumberDAO;
import com.phone.number.model.PhoneNumber;
import com.phone.number.repository.PhoneNumberRepository;
import com.phone.number.response.Response;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestControllerTest extends PhoneNumberProviderApiApplicationTests {

    @InjectMocks
    private RestController controller;

    @Mock
    private PhoneNumberRepository repository;

    @Mock
    private PhoneNumberDAO dao;


    @Test
    void getPhoneNumbers() {
        String number = "123";
        Mockito.when(repository.save(Mockito.any(PhoneNumber.class))).thenReturn(new PhoneNumber(number, number));
        Mockito.when(dao.getCombinationOfNumbers(number, 1, 10)).thenReturn(new ArrayList<>());
        ResponseEntity<Response> resp = controller.getPhoneNumbers(number, 1, 10);
        assertNotNull(resp);
        assertEquals(105, resp.getBody().getCount());

    }

//    @Test
//    void getAllPhoneNumbers() {
//        ResponseEntity<List<PhoneNumber>> res = controller.getAllPhoneNumbers();
//        assertNotNull(res);
//        assertEquals(0, res.getBody().size());
//    }
}