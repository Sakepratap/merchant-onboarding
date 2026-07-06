package com.merchant.merchantonboarding.repository;

import com.merchant.merchantonboarding.enums.MerchantStatus;
import com.merchant.merchantonboarding.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface MerchantRepository

        extends JpaRepository<Merchant, Long> {
    List<Merchant> findByStatus(MerchantStatus status);

}
