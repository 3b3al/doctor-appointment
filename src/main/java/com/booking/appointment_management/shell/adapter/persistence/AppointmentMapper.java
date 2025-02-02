package com.booking.appointment_management.shell.adapter.persistence;

import com.booking.appointment_management.core.domain.Appointment;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    
    public AppointmentEntity toEntity(Appointment domain) {
        return new AppointmentEntity(
            domain.getId(),
            domain.getSlotId(),
            domain.getPatientId(),
            domain.getPatientName(),
            domain.getReservedAt(),
            domain.getStatus()
        );
    }
    
    public Appointment toDomain(AppointmentEntity entity) {
        return new Appointment(
            entity.getId(),
            entity.getSlotId(),
            entity.getPatientId(),
            entity.getPatientName(),
            entity.getReservedAt()
        );
    }
}
