package com.phone.number.controller;

import com.phone.number.PhoneNumberProviderApiApplicationTests;
import com.phone.number.model.PhoneNumber;
import com.phone.number.repository.PhoneNumberRepository;
import com.phone.number.response.Response;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RestControllerTest extends PhoneNumberProviderApiApplicationTests {

    @InjectMocks
    private RestController controller;

    @Mock
    private PhoneNumberRepository repository;

    @Test
    void getPhoneNumbers() {
        String number = "1234567";
        Mockito.when(repository.save(Mockito.any(PhoneNumber.class))).thenReturn(new PhoneNumber(number, number));
        ResponseEntity<Response> resp = controller.getPhoneNumbers(number, 1, 10);
        assertNotNull(resp);
        //assertEquals(0, resp.getBody().size());

    }

//    @Test
//    void getAllPhoneNumbers() {
//        ResponseEntity<List<PhoneNumber>> res = controller.getAllPhoneNumbers();
//        assertNotNull(res);
//        assertEquals(0, res.getBody().size());
//    }
}