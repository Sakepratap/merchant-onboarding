package com.merchant.merchantonboarding.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "merchants")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long merchantId;

    private String businessName;

    private String ownerName;

    private String email;

    private String phone;

    private String businessType;

    private String status;
}