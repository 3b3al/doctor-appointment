package com.booking.appointment_booking.domain.validation;

import java.util.List;
import java.util.UUID;

import com.booking.appointment_booking.domain.contracts.IGetAvailableSlots;

public record ValidateSlot(UUID slotId){

    public static ValidateSlot of(UUID slotId , IGetAvailableSlots availableSlotsProvider) {
        List<UUID> availableSlots = availableSlotsProvider.getAvailableSlots();

        if(!availableSlots.contains(slotId)){
            throw new IllegalArgumentException("Slot is not available");
        }
        return new ValidateSlot(slotId);
    }

}
