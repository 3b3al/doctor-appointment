package com.booking.appointment_booking.domain.contracts;

import java.util.List;
import java.util.UUID;

public interface IGetAvailableSlots {
    public List<UUID> getAvailableSlots();
}