package com.merchant.merchantonboarding.repository;

import com.merchant.merchantonboarding.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository
        extends JpaRepository<Merchant, Long> {

}