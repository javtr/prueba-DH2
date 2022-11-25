package com.example.PI_grupo_10.service;

import com.example.PI_grupo_10.model.Booking;
import com.example.PI_grupo_10.model.dto.BookingDto;
import com.example.PI_grupo_10.repository.BookingRepository;
import org.springframework.stereotype.Service;


@Service
public class BookingService {

    private BookingRepository _bookingRepository;

    public BookingService(BookingRepository bookingRepository){
        this._bookingRepository = bookingRepository;
    }

    public BookingDto guardar(BookingDto bookingDto){
        Booking bookingEntidad = new Booking(bookingDto);
        Booking bookingGuardada = this._bookingRepository.save(bookingEntidad);

        if (bookingGuardada.getId() > 0) {
            bookingDto.id = bookingGuardada.getId();
            return bookingDto;
        }

        return null;
    }

    public BookingDto obtenerReserva(int id) {
        var booking = this._bookingRepository.findById(id);

        if (!booking.isPresent())
            return null;

        return new BookingDto(booking.get());
    }

}
