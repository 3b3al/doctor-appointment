package com.booking.appointment_booking.domain.contracts;

import com.booking.appointment_booking.domain.models.BookAppointment;

public interface IBookAppointmentRepository {
    
    public void save(BookAppointment bookAppointment);
}
