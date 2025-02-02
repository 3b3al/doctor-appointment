package com.booking.appointment_booking.application.handlers;

import org.springframework.stereotype.Service;

import com.booking.appointment_booking.application.dtos.*;
import com.booking.appointment_booking.contacts.BookAppointmentResponse;
import com.booking.appointment_booking.domain.contracts.IBookAppointmentRepository;
import com.booking.appointment_booking.domain.contracts.IGetAvailableSlots;
import com.booking.appointment_booking.domain.models.BookAppointment;

@Service
public class BookappointmentHandler {

    private final IBookAppointmentRepository repository;
    private final IGetAvailableSlots getAvailableSlots;

    public BookappointmentHandler(IBookAppointmentRepository repository, IGetAvailableSlots getAvailableSlots) {
        this.repository = repository;
        this.getAvailableSlots = getAvailableSlots;
        }

        public BookAppointmentResponse handle(BookappointmentRequest command) {
        var appointment =  BookAppointment.newBookAppointment(command.slotId, command.patientId, command.patientName, command.reservedAt ,getAvailableSlots);
        repository.save(appointment);
        return new BookAppointmentResponse(appointment.getSlotId(), appointment.getPatientName(), appointment.getReservedAt());
    }

}
