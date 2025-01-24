package com.booking.appointment_booking.infrastrecture;

import org.springframework.stereotype.Repository;

import com.booking.appointment_booking.domain.contracts.IBookAppointmentRepository;
import com.booking.appointment_booking.domain.models.BookAppointment;

@Repository
public class BookAppointmentRepository implements IBookAppointmentRepository{
    private final BookAppointmentPublisher publisher;

    public BookAppointmentRepository(BookAppointmentPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void save(BookAppointment bookAppointment) {
        System.out.println("BookAppointmentRepository.save");
        bookAppointment.getEvents().forEach(publisher::publish);
    }
        
}
