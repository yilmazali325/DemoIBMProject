package com.example.demo;

import com.example.demo.model.RegistrationRequest;
import com.example.demo.model.RegistrationResponse;
import com.example.demo.service.RegistrationService;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import static org.mockito.Mockito.when;

public class RegistrationServiceTest {

    @Mock
    RegistrationService registrationService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegistration() throws IOException, GeoIp2Exception {
        RegistrationRequest registrationRequest = RegistrationServiceTestData.getRegistrationRequest("24.53.80.0");
        RegistrationResponse registrationResponse = RegistrationServiceTestData.getRegistrationResponse();
        when(registrationService.register(registrationRequest)).thenReturn(registrationResponse);
        RegistrationResponse registrationResponseFromService = registrationService.register(registrationRequest);
        Assert.assertNotNull(registrationResponseFromService);
    }

    @Test(expected = RuntimeException.class)
    public void testRegistrationException() throws IOException, GeoIp2Exception {
        RegistrationRequest registrationRequest = RegistrationServiceTestData.getRegistrationRequest("206.71.50.230");
        when(registrationService.register(registrationRequest)).thenThrow(RuntimeException.class);
        RegistrationResponse registrationResponseFromService = registrationService.register(registrationRequest);
    }
}
