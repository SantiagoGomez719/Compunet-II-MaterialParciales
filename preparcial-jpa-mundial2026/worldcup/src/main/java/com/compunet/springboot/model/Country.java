package com.compunet.springboot.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false, length = 3)
    private String code;

    @Column(name = "confederation")
    private String confederation;

    @OneToMany(mappedBy = "country")
    private List<Player> players = new ArrayList<>();

    @OneToMany(mappedBy = "country")
    private List<Club> clubs = new ArrayList<>();

    // MATCH tiene DOS llaves foráneas hacia COUNTRY -> dos colecciones inversas, cada una con su propio mappedBy
    @OneToMany(mappedBy = "homeCountry")
    private List<Match> homeMatches = new ArrayList<>();

    @OneToMany(mappedBy = "awayCountry")
    private List<Match> awayMatches = new ArrayList<>();

}
