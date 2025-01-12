package com.booking.appointment_booking.domain.validation;

import java.util.Date;
import java.util.UUID;

import com.booking.appointment_booking.domain.contracts.IGetAvailableSlots;

public record ValidateSlot(UUID slotId){

    public static ValidateSlot of(UUID slotId , Date reservedAt ,IGetAvailableSlots availableSlotsProvider) {
        boolean isSlotAvailable = availableSlotsProvider.isSlotAvailable(slotId ,reservedAt);

        if(!isSlotAvailable){
            throw new IllegalArgumentException("Slot is not available");
        }
        return new ValidateSlot(slotId);
    }

}
