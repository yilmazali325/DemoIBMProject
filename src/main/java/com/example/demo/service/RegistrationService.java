package com.example.demo.service;

import com.example.demo.model.RegistrationRequest;
import com.example.demo.model.RegistrationResponse;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RegistrationService {
    private DatabaseReader countryDBReader;
    private DatabaseReader cityDBReader;

    public RegistrationResponse register(RegistrationRequest registrationRequest) throws IOException, GeoIp2Exception{
        List<String> geoResponse= getLocation(registrationRequest.getIpAddress());
        if(!geoResponse.get(0).equals("Canada")){
            throw new RuntimeException("User is not eligible to make the request");
        }
        RegistrationResponse registrationResponse = new RegistrationResponse();
        registrationResponse.setUuid(UUID.randomUUID());
        registrationResponse.setWelcomeMessage("Welcome " + registrationRequest.getUsername() + " " + geoResponse.get(1));
        return registrationResponse;
    }

    public RegistrationService() throws IOException {
        File countryDB = new File("/Users/aliyilmaz/Downloads/GeoLite2-Country_20220308/GeoLite2-Country.mmdb");
        File cityDB = new File("/Users/aliyilmaz/Downloads/GeoLite2-City_20220308/GeoLite2-City.mmdb");
        countryDBReader = new DatabaseReader.Builder(countryDB).build();
        cityDBReader = new DatabaseReader.Builder(cityDB).build();
    }

    public List<String> getLocation(String ip)
            throws IOException, GeoIp2Exception {
        List<String> res = new ArrayList<>();
        InetAddress ipAddress = InetAddress.getByName(ip);
        CountryResponse country = countryDBReader.country(ipAddress);
        CityResponse city = cityDBReader.city(ipAddress);
        String countryName = country.getCountry().getName();
        String cityName = city.getCity().getName();
        res.add(countryName);
        res.add(cityName);
        return res;
    }


}
