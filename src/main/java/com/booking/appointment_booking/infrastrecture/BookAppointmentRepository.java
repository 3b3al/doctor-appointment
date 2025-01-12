package com.booking.appointment_booking.infrastrecture;

import org.springframework.stereotype.Repository;

import com.booking.appointment_booking.domain.contracts.IBookAppointmentRepository;
import com.booking.appointment_booking.domain.models.BookAppointment;

@Repository
public class BookAppointmentRepository implements IBookAppointmentRepository{

    @Override
    public void save(BookAppointment bookAppointment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
        
}
