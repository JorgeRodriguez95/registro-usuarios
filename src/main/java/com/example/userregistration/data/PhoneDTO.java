package com.example.userregistration.data;

import lombok.Data;

@Data
public class PhoneDTO {
    private String number;
    private String citycode;
    private String contrycode;

    @Override
    public String toString() {
        return "PhoneDTO {" +
                "number='" + number + '\'' +
                ", citycode='" + citycode + '\'' +
                ", contrycode='" + contrycode + '\'' +
                '}';
    }
}
