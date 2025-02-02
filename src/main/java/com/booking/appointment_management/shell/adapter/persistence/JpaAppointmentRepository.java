package com.booking.appointment_management.shell.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

interface JpaAppointmentRepository extends JpaRepository<AppointmentEntity, String> {
    @Query("SELECT a FROM AppointmentEntity a WHERE a.reservedAt > :now ORDER BY a.reservedAt ASC")
    List<AppointmentEntity> findUpcomingAppointments(@Param("now") LocalDateTime now);
}
