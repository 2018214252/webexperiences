package com.example.webexperiences.experience05;

import com.example.webexperiences.entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String company;
    private List<Address> addresses;
}
