package com.booking.doctor_availability.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.booking.doctor_availability.contacts.DoctorAvailabilityResponse;
import com.booking.doctor_availability.models.DoctorAvailability;
import com.booking.doctor_availability.repositories.DoctorAvailabilityRepo;

@Service
public class AddDoctorAvailabilitySlot {

        private final DoctorAvailabilityRepo doctorAvailabilityRepo;

    public AddDoctorAvailabilitySlot(DoctorAvailabilityRepo doctorAvailabilityRepo) {
        this.doctorAvailabilityRepo = doctorAvailabilityRepo;
    }


        public DoctorAvailabilityResponse addNewDoctorAvailabilitySlot(Date time, UUID doctorId, String doctorName, double cost) {
        DoctorAvailability slot = DoctorAvailability.newDoctorAvailabilitySlot(time, doctorId, doctorName, cost);
        doctorAvailabilityRepo.save(slot);
        return new DoctorAvailabilityResponse(doctorId, time, doctorId, doctorName, true, cost);
    }

}
