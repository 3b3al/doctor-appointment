package com.booking.appointment_management.shell.adapter.persistence;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.booking.appointment_management.core.domain.Appointment;
import com.booking.appointment_management.core.ports.outgoing.AppointmentRepository;

@Repository
@Primary
public class JpaAppointmentAdapter implements AppointmentRepository {
    
    private final JpaAppointmentRepository jpaRepository;
    private final AppointmentMapper mapper;

    public JpaAppointmentAdapter(JpaAppointmentRepository jpaRepository, AppointmentMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Appointment> findUpcomingAppointmentsByDoctorId(String doctorId) {
        return jpaRepository.findUpcomingAppointments(LocalDateTime.now())
            .stream()
            .map(mapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Appointment> findById(String appointmentId) {
        return jpaRepository.findById(appointmentId)
            .map(mapper::toDomain);
    }

    @Override
    public void save(Appointment appointment) {
        AppointmentEntity entity = mapper.toEntity(appointment);
        jpaRepository.save(entity);
    }
}
