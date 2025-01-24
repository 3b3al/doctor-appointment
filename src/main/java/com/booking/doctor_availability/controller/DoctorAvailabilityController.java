package com.booking.doctor_availability.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.booking.doctor_availability.models.DoctorAvailability;
import com.booking.doctor_availability.service.DoctorAvailabilityService;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/doctor-availability")
public class DoctorAvailabilityController {

    private final DoctorAvailabilityService doctorAvailabilityService;

    public DoctorAvailabilityController(DoctorAvailabilityService doctorAvailabilityService) {
        this.doctorAvailabilityService = doctorAvailabilityService;
    }

    @PostMapping("/add-slot")
    public DoctorAvailability addNewDoctorAvailabilitySlot(@RequestParam Date time, @RequestParam UUID doctorId, @RequestParam String doctorName, @RequestParam double cost) {
        return doctorAvailabilityService.addNewDoctorAvailabilitySlot(time, doctorId, doctorName, cost);
    }

    @GetMapping("/slot/{id}")
    public Optional<DoctorAvailability> getSlotById(@PathVariable UUID id) {
        return doctorAvailabilityService.getSlotById(id);
    }

    @GetMapping("/slots")
    public List<DoctorAvailability> getAllAvailableSlots() {
        return doctorAvailabilityService.getAllAvailableSlots();
    }
}
