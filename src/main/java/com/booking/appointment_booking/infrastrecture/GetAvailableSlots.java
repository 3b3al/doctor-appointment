package com.booking.appointment_booking.infrastrecture;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.booking.appointment_booking.domain.contracts.IGetAvailableSlots;

@Service
public class GetAvailableSlots implements IGetAvailableSlots {

    @Override
    public boolean isSlotAvailable(UUID slotID ,Date reservedAt) {
        // Check if slot is  available on reserved date from the DoctorAvailability module
        // Replace this with actual logic to retrieve data
        return true; // Example slots
    }

}
