package com.example.PI_grupo_10.repository;

import com.example.PI_grupo_10.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
