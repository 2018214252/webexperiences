package com.example.webexperiences.experience05;

import com.example.webexperiences.entity.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddressDTO {
    private Long id;
    private String detail;
    private User user;
    private LocalDateTime createTime;
}
