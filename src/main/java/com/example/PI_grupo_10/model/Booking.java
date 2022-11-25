package com.example.PI_grupo_10.model;

import com.example.PI_grupo_10.model.dto.BookingDto;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
//
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_sequence")
    private int id;

    @Basic
    private java.time.LocalDate initialDate;

    @Basic
    private java.time.LocalDate endDate;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Booking(LocalDateTime initialHour, LocalDate initialDate, LocalDate endDate, Product product, User user) {
        this.initialDate = initialDate;
        this.endDate = endDate;
        this.product = product;
        this.user = user;
    }

    public Booking(BookingDto bookingDto) {
        this.id = bookingDto.id;
        this.initialDate = bookingDto.initialDate;
        this.endDate = bookingDto.endDate;
        this.product = bookingDto.product;
        this.user = bookingDto.user;
    }
}
