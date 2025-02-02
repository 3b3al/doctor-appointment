package com.booking.doctor_availability.contacts;


import java.util.Date;
import java.util.UUID;

import org.springframework.modulith.ApplicationModule;

@ApplicationModule(
    allowedDependencies = {"com.booking.appointment_booking"},
    type = ApplicationModule.Type.OPEN)
public record DoctorAvailabilityResponse(UUID slotId, Date time, UUID doctorId, String doctorName, boolean isReserved, double cost) {}
