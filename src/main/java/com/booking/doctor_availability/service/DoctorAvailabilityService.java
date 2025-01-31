package com.booking.doctor_availability.service;
import org.springframework.stereotype.Service;

import com.booking.doctor_availability.contacts.DoctorAvailabilityResponse;
import com.booking.doctor_availability.contacts.GetAllAvailableSlots;
import com.booking.doctor_availability.repositories.DoctorAvailabilityRepo;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorAvailabilityService implements GetAllAvailableSlots {

    private final DoctorAvailabilityRepo doctorAvailabilityRepo;

    public DoctorAvailabilityService(DoctorAvailabilityRepo doctorAvailabilityRepo) {
        this.doctorAvailabilityRepo = doctorAvailabilityRepo;
    }


    public DoctorAvailabilityResponse getSlotById(UUID slotId) {
        DoctorAvailabilityResponse response =doctorAvailabilityRepo.getDoctorAvailability(slotId);
        return response;
    }

    @Override
    public List<DoctorAvailabilityResponse> getAllAvailableSlots() {
        List<DoctorAvailabilityResponse> availableSlots = doctorAvailabilityRepo.getAllDoctorAvailability();
        return availableSlots;
    }
}
