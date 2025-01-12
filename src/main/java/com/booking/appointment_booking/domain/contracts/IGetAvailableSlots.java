package com.booking.appointment_booking.domain.contracts;

import java.util.Date;
import java.util.UUID;

public interface IGetAvailableSlots {
    boolean isSlotAvailable(UUID slotId, Date reservedAt);
}