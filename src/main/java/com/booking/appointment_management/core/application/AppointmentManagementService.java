package com.booking.appointment_management.core.application;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.booking.appointment_management.core.domain.Appointment;
import com.booking.appointment_management.core.domain.events.AppointmentCancelledEvent;
import com.booking.appointment_management.core.ports.incoming.AppointmentManagementUseCase;
import com.booking.appointment_management.core.ports.outgoing.AppointmentRepository;
import com.booking.shared.IEventBus;

@Service
public class AppointmentManagementService implements AppointmentManagementUseCase {
    
    private final AppointmentRepository appointmentRepository;
    private final IEventBus eventBus;

    public AppointmentManagementService(AppointmentRepository appointmentRepository, IEventBus eventBus) {
        this.appointmentRepository = appointmentRepository;
        this.eventBus = eventBus;
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
                
                // Publish cancellation event
                var cancellationEvent = new AppointmentCancelledEvent(
                    UUID.fromString(appointment.getSlotId()),
                    appointment.getPatientName(),
                    appointment.getId()
                );
                eventBus.push(cancellationEvent);
            });
    }
}
