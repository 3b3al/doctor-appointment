package com.booking.doctor_availability.service;

import org.springframework.stereotype.Service;
import com.booking.doctor_availability.models.DoctorAvailability;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorAvailabilityService {

    private final List<DoctorAvailability> slots = new ArrayList<>();

    public DoctorAvailability addNewDoctorAvailabilitySlot(Date time, UUID doctorId, String doctorName, double cost) {
        DoctorAvailability slot = DoctorAvailability.newDoctorAvailabilitySlot(time, doctorId, doctorName, cost);
        slots.add(slot);
        return slot;
    }

    public Optional<DoctorAvailability> getSlotById(UUID slotId) {
        return slots.stream().filter(slot -> slot.getSlotId().equals(slotId)).findFirst();
    }

    public List<DoctorAvailability> getAllAvailableSlots() {
        return new ArrayList<>(slots);
    }
}
