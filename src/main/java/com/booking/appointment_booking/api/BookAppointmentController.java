package com.booking.appointment_booking.api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.booking.appointment_booking.application.dtos.BookappointmentRequest;
import com.booking.appointment_booking.application.handlers.BookappointmentHandler;
import com.booking.appointment_booking.contacts.BookAppointmentResponse;
import com.booking.appointment_booking.domain.contracts.IGetAvailableSlots;
import com.booking.doctor_availability.contacts.DoctorAvailabilityResponse;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@AllArgsConstructor
public class BookAppointmentController {

    private final BookappointmentHandler bookAppointmentHandler;
    private final IGetAvailableSlots getAvailableSlots;

    @PostMapping("/v1/book-appointment")
    public ResponseEntity<?> addNewBookAppointment(@RequestBody BookappointmentRequest command) {
        BookAppointmentResponse response = bookAppointmentHandler.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/v1/all-available-slots")
    public ResponseEntity<?> getAllAvailableSlots() {
        List<DoctorAvailabilityResponse> response = getAvailableSlots.getAllAvailableSlots();
        return ResponseEntity.status(HttpStatus.OK).body(response); 
    }
    
    
}
