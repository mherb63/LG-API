package com.increditek.lgapi.service;

import com.increditek.lgapi.domain.Vendor;
import com.increditek.lgapi.exception.ItemNotFoundException;
import com.increditek.lgapi.repository.VendorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public Page<Vendor> findAll(int page, int pageSize) {
        return vendorRepository.findAll(PageRequest.of(page, pageSize));
    }

    public Vendor findById(Long id) {
        return vendorRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Count not find Vendor with id: " + id));
    }

    public Vendor findByVendorId(String vendorId) {
        return vendorRepository.findByvendorId(vendorId).orElseThrow(()-> new ItemNotFoundException("Count not find Vendor with name: " + vendorId));
    }
}
