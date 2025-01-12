package com.booking.appointment_booking.application.dtos;

import java.util.Date;
import java.util.UUID;

public class BookappointmentRequest {

     public UUID slotId;
     public UUID patientId;
     public String patientName;
     public Date reservedAt;

}
