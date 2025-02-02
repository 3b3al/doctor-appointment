package com.booking.appointment_management.core.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.booking.appointment_management.core.domain.Appointment;
import com.booking.appointment_management.core.ports.incoming.AppointmentManagementUseCase;
import com.booking.appointment_management.core.ports.outgoing.AppointmentRepository;

@Service
public class AppointmentManagementService implements AppointmentManagementUseCase {
    
    private final AppointmentRepository appointmentRepository;

    public AppointmentManagementService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getUpcomingAppointments(String doctorId) {
        return appointmentRepository.findUpcomingAppointmentsByDoctorId(doctorId);
    }

    @Override
    public void markAppointmentAsCompleted(String appointmentId) {
        appointmentRepository.findById(appointmentId)
            .ifPresent(appointment -> {
                appointment.complete();
                appointmentRepository.save(appointment);
            });
    }

    @Override
    public void cancelAppointment(String appointmentId) {
        appointmentRepository.findById(appointmentId)
            .ifPresent(appointment -> {
                appointment.cancel();
                appointmentRepository.save(appointment);
            });
    }
}
