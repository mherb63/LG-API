package com.increditek.lgapi.converter;

import com.increditek.lgapi.domain.BomItem;
import com.increditek.lgapi.domain.CustomerPurchaseOrder;
import com.increditek.lgapi.domain.JobBomItem;
import com.increditek.lgapi.domain.User;
import com.increditek.lgapi.dto.JobBomItemDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class JobBomItemToJobBomItemDto implements Converter<JobBomItem, JobBomItemDto> {
    @Override
    public JobBomItemDto convert(JobBomItem jobBom) {
        JobBomItemDto jbDto = new JobBomItemDto();

        CustomerPurchaseOrder po = jobBom.getPurchaseOrder();
        BomItem bi = jobBom.getBomItem();
        User updatedBy = jobBom.getUpdatedBy();
        User receivedBy = jobBom.getReceivedBy();
        User pulledBy = jobBom.getPulledBy();
        User orderedBy = jobBom.getOrderedBy();

        jbDto.setId(jobBom.getId());
        if (po != null) {
            jbDto.setPoID(po.getId());
            jbDto.setPoNumber(po.getNumber());
        }
        jbDto.setBomItemID(bi.getId());
        jbDto.setVendor(bi.getVendor());
        if (updatedBy != null) {
            jbDto.setUpdatedBy(updatedBy.getFirstName() + " " + updatedBy.getLastName());
        }
        jbDto.setLastUpdated(jobBom.getLastUpdated());

        if (pulledBy != null) {
            jbDto.setPulledBy(pulledBy.getFirstName() + " " + pulledBy.getLastName());
        }
        jbDto.setPulledOn(jobBom.getPulledOn());
        if (receivedBy != null) {
            jbDto.setReceivedBy(receivedBy.getFirstName() + " " + receivedBy.getLastName());
        }
        jbDto.setReceivedOn(jobBom.getReceivedOn());
        if (orderedBy != null) {
            jbDto.setOrderedBy(orderedBy.getFirstName() + " " + orderedBy.getLastName());
        }
        jbDto.setOrderedOn(jobBom.getOrderedOn());

        jbDto.setPartNumber(jobBom.getPartNumber());
        jbDto.setPartDescription(jobBom.getPartDescription());
        jbDto.setUnitCost(jobBom.getUnitCost());
        jbDto.setItekUnitCost(jobBom.getItekUnitCost());
        jbDto.setQty(jobBom.getQty());
        jbDto.setUm(jobBom.getUm());
        jbDto.setEstShip(jobBom.getEstShip());
        jbDto.setActShip(jobBom.getActShip());
        jbDto.setIsInvoiced(jobBom.getIsInvoiced());
        jbDto.setNotes(jobBom.getNotes());
        jbDto.setShipNotes(jobBom.getShipNotes());
        jbDto.setQtyOrdered(jobBom.getQtyOrdered());
        jbDto.setQtyInStock(jobBom.getQtyInStock());
        jbDto.setQtyRec(jobBom.getQtyRec());
        jbDto.setDateRec(jobBom.getDateRec());
        jbDto.setCoNumber(jobBom.getCoNumber());

        return jbDto;
    }
}
