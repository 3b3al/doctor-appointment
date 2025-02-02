package com.booking.appointment_management.core.ports.incoming;

import java.util.List;
import java.util.UUID;

import com.booking.appointment_management.core.domain.Appointment;

public interface AppointmentManagementUseCase {
    List<Appointment> getUpcomingAppointments(String doctorId);
    void markAppointmentAsCompleted(String appointmentId);
    void cancelAppointment(String appointmentId);
}
