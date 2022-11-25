package com.example.PI_grupo_10.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_sequence")
    private int id;
    private String name;

    public Country(String name) {
        this.name = name;
    }
}
