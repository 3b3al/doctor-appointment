package com.booking.doctor_availability.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.doctor_availability.dtos.DoctorAvailabilityResponse;
import com.booking.doctor_availability.models.DoctorAvailability;
import com.booking.doctor_availability.repositories.DoctorAvailabilityRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorAvailabilityService {

    private final DoctorAvailabilityRepo doctorAvailabilityRepo;

    public DoctorAvailabilityService(DoctorAvailabilityRepo doctorAvailabilityRepo) {
        this.doctorAvailabilityRepo = doctorAvailabilityRepo;
    }

    public DoctorAvailabilityResponse addNewDoctorAvailabilitySlot(Date time, UUID doctorId, String doctorName, double cost) {
        DoctorAvailability slot = DoctorAvailability.newDoctorAvailabilitySlot(time, doctorId, doctorName, cost);
        doctorAvailabilityRepo.save(slot);
        return new DoctorAvailabilityResponse(doctorId, time, doctorId, doctorName, true, cost);
    }

    public DoctorAvailabilityResponse getSlotById(UUID slotId) {
        DoctorAvailabilityResponse response =doctorAvailabilityRepo.getDoctorAvailability(slotId);
        return response;
    }

    public List<DoctorAvailabilityResponse> getAllAvailableSlots() {
        List<DoctorAvailabilityResponse> availableSlots = doctorAvailabilityRepo.getAllDoctorAvailability();
        return availableSlots;
    }
}
