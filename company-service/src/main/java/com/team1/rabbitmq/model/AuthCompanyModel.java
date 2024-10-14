package com.team1.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthCompanyModel implements Serializable {
    private Long authId;
    private String companyAddress;
    private String companyPhoneNumber;
    private String taxNumber;
    private String companyName;
}
