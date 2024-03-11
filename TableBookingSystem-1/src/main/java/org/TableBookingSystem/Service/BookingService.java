package org.TableBookingSystem.Service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.TableBookingSystem.Repository.BookingRepository;
import org.TableBookingSystem.model.Booking;
import org.TableBookingSystem.model.Cuisine;
import org.TableBookingSystem.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public Table createBooking(Table table, Cuisine cuisine, LocalDate date, LocalTime time) {
        Booking booking = new Booking();
        booking.setTable(table);
        booking.setCuisine(cuisine);
        booking.setDate(date);
        booking.setTime(time);
        // You might want to do some validation or additional logic here
        
        // Save the booking entity
        booking = bookingRepository.save(booking);

        // Set the table as booked
        table.setBooked(true);
        // You might want to add the booked booking to the table entity for future reference
        table.setBooked(booking);
        // Save the updated table entity
        tableRepository.save(table);

        return table;
    }

    // Other methods...
}

}
