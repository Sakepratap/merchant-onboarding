package com.merchant.merchantonboarding.service;

import com.merchant.merchantonboarding.dto.MerchantRequest;
import com.merchant.merchantonboarding.dto.MerchantResponse;
import com.merchant.merchantonboarding.entity.Merchant;
import com.merchant.merchantonboarding.repository.MerchantRepository;
import org.springframework.stereotype.Service;
import com.merchant.merchantonboarding.enums.MerchantStatus;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Service
public class MerchantService {

    private final MerchantRepository merchantRepository;

    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public MerchantResponse createMerchant(MerchantRequest request) {

        Merchant merchant = Merchant.builder()
                .businessName(request.getBusinessName())
                .ownerName(request.getOwnerName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .businessType(request.getBusinessType())
                .status(MerchantStatus.PENDING)
                .build();


        Merchant savedMerchant = merchantRepository.save(merchant);

        return mapToResponse(savedMerchant);
    }

    public List<MerchantResponse> getAllMerchants() {
        return merchantRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public MerchantResponse getMerchantById(Long id) {

        Merchant merchant = merchantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Merchant not found"));

        return mapToResponse(merchant);
    }

    private MerchantResponse mapToResponse(Merchant merchant) {
        return MerchantResponse.builder()
                .merchantId(merchant.getMerchantId())
                .businessName(merchant.getBusinessName())
                .ownerName(merchant.getOwnerName())
                .email(merchant.getEmail())
                .phone(merchant.getPhone())
                .businessType(merchant.getBusinessType())
                .status(merchant.getStatus().name())
                .createdAt(merchant.getCreatedAt())
                .updatedAt(merchant.getUpdatedAt())
                .build();
    }
    public MerchantResponse approveMerchant(Long id) {

        Merchant merchant = merchantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Merchant not found"));

        merchant.setStatus(MerchantStatus.APPROVED);

        Merchant savedMerchant = merchantRepository.save(merchant);

        return mapToResponse(savedMerchant);
    }

    public MerchantResponse rejectMerchant(Long id) {

        Merchant merchant = merchantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Merchant not found"));

        merchant.setStatus(MerchantStatus.REJECTED);
        Merchant savedMerchant = merchantRepository.save(merchant);

        return mapToResponse(savedMerchant);
    }
    public List<MerchantResponse> getMerchantsByStatus(String status) {

        MerchantStatus merchantStatus =
                MerchantStatus.valueOf(status.toUpperCase());

        return merchantRepository.findByStatus(merchantStatus)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
    public MerchantResponse getMerchantByEmail(String email) {

        Merchant merchant = merchantRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Merchant not found"));

        return mapToResponse(merchant);
    }
    public Page<MerchantResponse> getMerchantsWithPagination(
            int page,
            int size,
            String sortBy) {

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy));

        return merchantRepository.findAll(pageable)
                .map(this::mapToResponse);
    }
    public List<MerchantResponse> searchMerchantByBusinessName(
            String businessName) {

        return merchantRepository
                .findByBusinessNameContainingIgnoreCase(businessName)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }
}