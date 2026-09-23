package com.compunet.springboot.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Llave compuesta de PLAYER_CLUB: (player_id, club_id, start_date)
// start_date es parte de la PK pero NO es una FK: un jugador puede volver al mismo club en otra fecha.
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PlayerClubId implements Serializable {

    @Column(name = "player_id")
    private Long playerId;

    @Column(name = "club_id")
    private Long clubId;

    @Column(name = "start_date")
    private LocalDate startDate;

}
