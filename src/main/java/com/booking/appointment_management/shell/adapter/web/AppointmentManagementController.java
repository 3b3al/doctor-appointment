package com.booking.appointment_management.shell.adapter.web;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.booking.appointment_management.core.domain.Appointment;
import com.booking.appointment_management.core.ports.incoming.AppointmentManagementUseCase;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentManagementController {
    
    private final AppointmentManagementUseCase appointmentManagementUseCase;

    public AppointmentManagementController(AppointmentManagementUseCase appointmentManagementUseCase) {
        this.appointmentManagementUseCase = appointmentManagementUseCase;
    }

    @GetMapping("/doctor/{doctorId}/upcoming")
    public ResponseEntity<List<Appointment>> getUpcomingAppointments(@PathVariable String doctorId) {
        Logger.getLogger("dsdsa").log(Level.INFO, "dsad");
        return ResponseEntity.ok(appointmentManagementUseCase.getUpcomingAppointments(doctorId));
    }

    @PutMapping("/{appointmentId}/complete")
    public ResponseEntity<Void> markAppointmentAsCompleted(@PathVariable String appointmentId) {
        appointmentManagementUseCase.markAppointmentAsCompleted(appointmentId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{appointmentId}/cancel")
    public ResponseEntity<Void> cancelAppointment(@PathVariable String appointmentId) {
        appointmentManagementUseCase.cancelAppointment(appointmentId);
        return ResponseEntity.ok().build();
    }
}
