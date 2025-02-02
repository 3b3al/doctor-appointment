package com.booking.doctor_availability.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.booking.doctor_availability.contacts.DoctorAvailabilityResponse;
import com.booking.doctor_availability.models.DoctorAvailability;


@Repository
public class DoctorAvailabilityRepo {

    public void updateDoctorAvailability(UUID slotId) {
        System.out.println("DoctorAvailabilityRepo: Slot updated: " + slotId);
    }

    public void deleteDoctorAvailability(UUID slotId) {
        System.out.println("DoctorAvailabilityRepo: Slot deleted: " + slotId);
    }
    
    public void addDoctorAvailability(UUID slotId) {
        System.out.println("DoctorAvailabilityRepo: Slot added: " + slotId);
    }

    public DoctorAvailabilityResponse getDoctorAvailability(UUID slotId) {
        System.out.println("DoctorAvailabilityRepo: Slot retrieved: " + slotId);
        return new DoctorAvailabilityResponse(slotId, null, slotId, null, false, 0);
    }

    public List<DoctorAvailabilityResponse> getAllDoctorAvailability() {
        System.out.println("DoctorAvailabilityRepo: All slots retrieved");
        return List.of(new DoctorAvailabilityResponse(UUID.randomUUID(), null, UUID.randomUUID(), "Doctor", true, 0));
    }

    public void save(DoctorAvailability slot) {
        System.out.println("DoctorAvailabilityRepo: Slot saved: " + slot);
    }
}
