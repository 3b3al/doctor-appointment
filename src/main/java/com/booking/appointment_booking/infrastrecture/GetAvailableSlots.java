package com.booking.appointment_booking.infrastrecture;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.booking.appointment_booking.domain.contracts.IGetAvailableSlots;

public class GetAvailableSlots implements IGetAvailableSlots {

    @Override
    public List<UUID> getAvailableSlots() {
        // Fetch available slots from the DoctorAvailability module
        // Replace this with actual logic to retrieve data
        return List.of(UUID.randomUUID(), UUID.randomUUID()); // Example slots
    }

}
