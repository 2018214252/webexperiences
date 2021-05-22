package com.example.webexperiences.experience08.component;

import com.example.webexperiences.experience08.exception.MyException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EncryptorComponent {
    @Autowired
    private ObjectMapper objectMapper;
    @Value("${my.secretkey}")
    private String secretKey;
    @Value("${my.salt}")
    private String salt;
    @Autowired
    private TextEncryptor encryptor;

    @Bean
    public TextEncryptor getTextEncryptor(){
        return Encryptors.text(secretKey,salt);
    }

    public String encrypt(Map<String,Object> payload){
        String json = null;
        try {
            json = objectMapper.writeValueAsString(payload);
        } catch (JsonProcessingException e) {
            throw new MyException(500,"服务器端错误");
        }
        return encryptor.encrypt(json);
    }

    public Map<String,Object> decrypt(String auth){
        String json = encryptor.decrypt(auth);
        try {
            return objectMapper.readValue(json,Map.class);
        } catch (JsonProcessingException e) {
            throw new MyException(403,"无权限");
        }
    }


}
