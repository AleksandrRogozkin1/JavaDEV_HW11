package org.example.enitty;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "planet")
public class Planet {
    @Id
    private long id;
    @Column
    private String name;
    @OneToMany(mappedBy="fromPlanetId", fetch = FetchType.LAZY, cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Ticket> ticketsFromPlanet = new HashSet<>();
    @OneToMany(mappedBy="toPlanetId", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Ticket> ticketsToPlanet = new HashSet<>();
}
