package com.gestionClient.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    private Long id;
    private String name;
    private String ville;

    @OneToMany(mappedBy = "client")
    @JsonIgnore
    private List<Orders> orders = new ArrayList<>();
}
