package com.example.demo;

import com.example.demo.model.RegistrationRequest;
import com.example.demo.model.RegistrationResponse;

import java.util.UUID;

public class RegistrationServiceTestData {
    public static RegistrationRequest getRegistrationRequest(String ip){
        RegistrationRequest registrationRequest = new RegistrationRequest();
        registrationRequest.setIpAddress(ip);
        registrationRequest.setPassword("Paassword21!");
        registrationRequest.setPassword("Ali");
        return registrationRequest;
    }

    public static RegistrationResponse getRegistrationResponse(){
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setUuid(UUID.fromString("0cb25b42-b1f8-4b58-a19f-e137e881fe38"));
        registrationResponse.setWelcomeMessage("Welcome Ali Cambridge");
        return registrationResponse;
    }
}
