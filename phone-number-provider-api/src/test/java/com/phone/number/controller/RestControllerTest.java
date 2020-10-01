package com.phone.number.controller;

import com.phone.number.PhoneNumberProviderApiApplicationTests;
import com.phone.number.model.PhoneNumber;
import com.phone.number.repository.PhoneNumberRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

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
        List<PhoneNumber> resp = controller.getPhoneNumbers(number);
        assertNotNull(resp);
        assertEquals(0, resp.size());

    }

    @Test
    void getAllPhoneNumbers() {
        List<PhoneNumber> res = controller.getAllPhoneNumbers();
        assertNotNull(res);
        assertEquals(0, res.size());
    }
}