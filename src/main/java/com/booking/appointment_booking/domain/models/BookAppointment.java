package com.booking.appointment_booking.domain.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.booking.appointment_booking.domain.contracts.IGetAvailableSlots;
import com.booking.appointment_booking.domain.validation.ValidateSlot;

public class BookAppointment {
    private UUID id;
    private UUID slotId;
    private UUID patientId;
    private String patientName;
    private Date reservedAt;

    private ArrayList<BookAppointmentEvent> events = new ArrayList<>();

    private BookAppointment(UUID id, UUID slotId, UUID patientId, String patientName, Date reservedAt) {
        this.id = id;
        this.slotId = slotId;
        this.patientId = patientId;
        this.patientName = patientName;
        this.reservedAt = reservedAt;
    }

    public static BookAppointment newBookAppointment(UUID slotId, UUID patientId, String patientName, IGetAvailableSlots availableSlotsProvider) {
        UUID id = UUID.randomUUID();
        Date reservedAt = new Date();
        UUID validatedSlotId = validateSlot(slotId, availableSlotsProvider);
        var bookAppointment = new BookAppointment(id, validatedSlotId, patientId, patientName, reservedAt);
        bookAppointment.events.add(ReserveSlot.of(bookAppointment));
        return bookAppointment;
    }

    private static UUID validateSlot(UUID slotId, IGetAvailableSlots availableSlotsProvider) {
        ValidateSlot validatedSlot = ValidateSlot.of(slotId, availableSlotsProvider);
        return validatedSlot.slotId();
    }

    public UUID getId() {
        return id;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public UUID getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public Date getReservedAt() {
        return reservedAt;
    }

    public ArrayList<BookAppointmentEvent> getEvents() {
        return events;
    }

}
