package org.example.enitty;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private String name;

}
