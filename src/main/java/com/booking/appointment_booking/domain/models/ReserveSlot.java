package com.booking.appointment_booking.domain.models;

import java.util.Date;
import java.util.UUID;

public record ReserveSlot(UUID slotId , String patientName , Date reservedAt) implements BookAppointmentEvent {

    public static ReserveSlot of( BookAppointment bookAppointment) {
        return new ReserveSlot(bookAppointment.getSlotId(), bookAppointment.getPatientName(), bookAppointment.getReservedAt());
    }

}
