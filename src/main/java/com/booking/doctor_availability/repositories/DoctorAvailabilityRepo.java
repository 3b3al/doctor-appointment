package com.booking.doctor_availability.repositories;

import java.util.UUID;

public class DoctorAvailabilityRepo {

    public void updateDoctorAvailability(UUID slotId) {
        System.out.println("DoctorAvailabilityRepo: Slot updated: " + slotId);
    }

}
