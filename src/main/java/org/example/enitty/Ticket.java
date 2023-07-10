package org.example.enitty;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "from_planet_id")
    private Planet fromPlanetId;
    @ManyToOne
    @JoinColumn(name = "to_planet_id")
    private Planet toPlanetId;
}
