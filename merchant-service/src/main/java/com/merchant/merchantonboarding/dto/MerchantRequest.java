package com.merchant.merchantonboarding.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MerchantRequest {

    @NotBlank(message = "Business Name is required")
    private String businessName;

    @NotBlank(message = "Owner Name is required")
    private String ownerName;

    @Email(message = "Invalid Email")
    private String email;

    @NotBlank(message = "Phone Number is required")
    private String phone;

    private String businessType;
}