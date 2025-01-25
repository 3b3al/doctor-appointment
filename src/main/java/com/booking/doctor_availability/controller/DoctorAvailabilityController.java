package com.booking.doctor_availability.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.booking.doctor_availability.dtos.DoctorAvailabilityResponse;
import com.booking.doctor_availability.service.DoctorAvailabilityService;

import java.net.http.HttpResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/doctor-availability")
public class DoctorAvailabilityController {

    private final DoctorAvailabilityService doctorAvailabilityService;

    public DoctorAvailabilityController(DoctorAvailabilityService doctorAvailabilityService) {
        this.doctorAvailabilityService = doctorAvailabilityService;
    }

    @PostMapping("/add-slot")
    public ResponseEntity<?> addNewDoctorAvailabilitySlot(@RequestParam Date time, @RequestParam UUID doctorId, @RequestParam String doctorName, @RequestParam double cost) {
        DoctorAvailabilityResponse response = doctorAvailabilityService.addNewDoctorAvailabilitySlot(time, doctorId, doctorName, cost);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/slot/{id}")
    public ResponseEntity<?> getSlotById(@PathVariable UUID id) {
        DoctorAvailabilityResponse response = doctorAvailabilityService.getSlotById(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/slots")
    public ResponseEntity<?> getAllAvailableSlots() {
        List<DoctorAvailabilityResponse> responses = doctorAvailabilityService.getAllAvailableSlots();
        return ResponseEntity.status(HttpStatus.CREATED).body(responses);
    }
}
