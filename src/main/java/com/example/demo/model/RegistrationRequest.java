package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationRequest implements Serializable {
    private static final long serialVersionUID = 421307864332348675L;

    //Not Empty annotation makes use of Notnull so the value cant be null and empty
    @NotEmpty(message = "Username may not be null or empty")
    private String username;

    @NotEmpty(message = "Password may not be null or empty")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}", message = "Password is invalid!")
    private String password;

    @NotEmpty(message = "IpAddress may not be null or empty")
    private String ipAddress;
}
