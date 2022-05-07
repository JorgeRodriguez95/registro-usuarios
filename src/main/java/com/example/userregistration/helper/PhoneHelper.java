package com.example.userregistration.helper;

import com.example.userregistration.data.PhoneDTO;
import com.example.userregistration.entity.Phone;
import org.springframework.stereotype.Component;

@Component
public class PhoneHelper {

    public Phone setPhone(PhoneDTO phoneDTO){
        return Phone.builder()
                .number(phoneDTO.getNumber())
                .cityCode(phoneDTO.getCitycode())
                .countryCode(phoneDTO.getContrycode())
                .build();
    }
}
