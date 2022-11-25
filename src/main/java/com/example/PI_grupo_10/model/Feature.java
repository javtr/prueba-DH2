package com.example.PI_grupo_10.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "features")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feature_sequence")
    private int id;
    private String name;
    private String pathIcon;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "features")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();

    public Feature(String name, String pathIcon) {
        this.name = name;
        this.pathIcon = pathIcon;
    }
}
