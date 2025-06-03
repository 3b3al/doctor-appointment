package com.booking.appointment_management.core.domain.events;

import java.util.UUID;

public record AppointmentCancelledEvent(
    UUID slotId,
    String patientName,
    String appointmentId
) {} 