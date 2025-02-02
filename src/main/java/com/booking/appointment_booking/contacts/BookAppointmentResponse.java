package com.booking.appointment_booking.contacts;
import java.util.Date;
import java.util.UUID;

import org.springframework.modulith.ApplicationModule;

@ApplicationModule(
    allowedDependencies = {"com.booking.doctor_availability"},
    type = ApplicationModule.Type.OPEN)
public record BookAppointmentResponse(UUID slotId, String patientName, Date reservedAt) {}
