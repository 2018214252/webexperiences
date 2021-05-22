package com.example.webexperiences.experience05;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class AddressMapperTest {
    @Autowired
    private AddressMapper02 addressMapper;
    @Test
    public void test(){
        for(AddressDTO aDTO : addressMapper.listAddressDTOs("1201")){
            log.debug("{}/{}",aDTO.getId(),aDTO.getUser().getName());
        }
    }
}
