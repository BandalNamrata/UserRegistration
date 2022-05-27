package com.elephantitech.userservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String name;
    private String email;
    private String password;
    private String phoneNo;
    private String adharCard;
    private String mobileNumber;
    private String drivingLicence;
    private String bloodGroup;

}
