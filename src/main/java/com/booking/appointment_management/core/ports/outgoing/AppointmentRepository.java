package com.booking.appointment_management.core.ports.outgoing;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.booking.appointment_management.core.domain.Appointment;

public interface AppointmentRepository {
    List<Appointment> findUpcomingAppointmentsByDoctorId(String doctorId);
    Optional<Appointment> findById(String appointmentId);
    void save(Appointment appointment);
}
