package com.merchant.merchantonboarding.repository;

import com.merchant.merchantonboarding.enums.MerchantStatus;
import com.merchant.merchantonboarding.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;


public interface MerchantRepository

        extends JpaRepository<Merchant, Long> {
    List<Merchant> findByStatus(MerchantStatus status);
    Optional<Merchant> findByEmail(String email);
    List<Merchant> findByBusinessNameContainingIgnoreCase(String businessName);
    long countByStatus(MerchantStatus status);

}
