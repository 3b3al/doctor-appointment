package com.booking.appointment_booking.infrastrecture;

import com.booking.appointment_booking.contacts.BookAppointmentResponse;
import com.booking.appointment_booking.domain.models.BookAppointmentEvent;
import com.booking.appointment_booking.domain.models.ReserveSlot;
import com.booking.shared.IEventBus;

public class BookAppointmentPublisher {
    private final IEventBus eventBus;

    public BookAppointmentPublisher(IEventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void publish(BookAppointmentEvent bookAppointmentEventevent) {
        if (bookAppointmentEventevent instanceof ReserveSlot reserveSlot) {
            var slotReservedEvent = new BookAppointmentResponse(reserveSlot.slotId(), reserveSlot.patientName(), reserveSlot.reservedAt());
            eventBus.push(slotReservedEvent);
            
        }
    }

}
