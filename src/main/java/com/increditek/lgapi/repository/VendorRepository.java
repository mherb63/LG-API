package com.increditek.lgapi.repository;

import com.increditek.lgapi.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Optional<Vendor> findByvendorId(String vendorId);

}
