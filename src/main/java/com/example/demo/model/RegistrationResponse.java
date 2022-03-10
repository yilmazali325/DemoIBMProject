package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationResponse implements Serializable {
    private static final long serialVersionUID = 980735827255977577L;
    private UUID uuid;
    private String welcomeMessage;
}
