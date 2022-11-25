package com.example.PI_grupo_10.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "types")
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_sequence")
    private int id;
    private String title;

    public Type(String title) {
        this.title = title;
    }
}
