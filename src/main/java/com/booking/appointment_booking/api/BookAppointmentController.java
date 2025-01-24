package com.booking.appointment_booking.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.booking.appointment_booking.application.dtos.BookappointmentRequest;
import com.booking.appointment_booking.application.handlers.BookappointmentHandler;
import com.booking.appointment_booking.contacts.BookAppointmentResponse;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@AllArgsConstructor
public class BookAppointmentController {

    private final BookappointmentHandler bookAppointmentHandler;

    @PostMapping("/v1/book-appointment")
    public ResponseEntity<?> addNewBookAppointment(@RequestBody BookappointmentRequest command) {
        BookAppointmentResponse response = bookAppointmentHandler.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    
}
