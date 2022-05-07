package com.example.userregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "phones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Phone {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String number;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "country_code")
    private String countryCode;
}
