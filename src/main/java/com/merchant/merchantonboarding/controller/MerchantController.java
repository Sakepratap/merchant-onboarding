package com.merchant.merchantonboarding.controller;

import com.merchant.merchantonboarding.dto.MerchantRequest;
import com.merchant.merchantonboarding.dto.MerchantResponse;
import com.merchant.merchantonboarding.service.MerchantService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }


    @PostMapping
    public MerchantResponse createMerchant(
            @Valid @RequestBody MerchantRequest request) {
        System.out.println("POST API HIT");

        return merchantService.createMerchant(request);
    }

    @GetMapping
    public List<MerchantResponse> getAllMerchants() {
        return merchantService.getAllMerchants();
    }

    @GetMapping("/{id}")
    public MerchantResponse getMerchant(@PathVariable Long id) {
        return merchantService.getMerchantById(id);
    }
    @PutMapping("/{id}/approve")
    public MerchantResponse approveMerchant(@PathVariable Long id) {
        return merchantService.approveMerchant(id);
    }

    @PutMapping("/{id}/reject")
    public MerchantResponse rejectMerchant(@PathVariable Long id) {
        return merchantService.rejectMerchant(id);
    }
    @GetMapping("/status/{status}")
    public List<MerchantResponse> getMerchantsByStatus(
            @PathVariable String status) {

        return merchantService.getMerchantsByStatus(status);
    }
    @GetMapping("/email/{email}")
    public MerchantResponse getMerchantByEmail(
            @PathVariable String email) {

        return merchantService.getMerchantByEmail(email);
    }
    @GetMapping("/paged")
    public Page<MerchantResponse> getMerchantsWithPagination(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "5") int size,

            @RequestParam(defaultValue = "merchantId") String sortBy) {

        return merchantService.getMerchantsWithPagination(
                page,
                size,
                sortBy);
    }
    @GetMapping("/search")
    public List<MerchantResponse> searchMerchantByBusinessName(
            @RequestParam String businessName) {

        return merchantService
                .searchMerchantByBusinessName(businessName);
    }
}