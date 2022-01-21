package com.increditek.lgapi.controller;

import com.increditek.lgapi.domain.PageableResponse;
import com.increditek.lgapi.domain.Vendor;
import com.increditek.lgapi.service.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/vendor")
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PageableResponse getVendors(HttpServletRequest request,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "100") int pageSize) {
        return new PageableResponse("lgapi/vendor", vendorService.findAll(page, pageSize), request.getRequestURL().toString());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Vendor getVendor(@PathVariable Long id) {
        return vendorService.findById(id);
    }

    @GetMapping("/get-by-vendorid")
    @ResponseStatus(HttpStatus.OK)
    public Vendor getVendorByName(@RequestParam String vendorId) {
        return vendorService.findByVendorId(vendorId);
    }
}
