package com.compunet.springboot.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "player_club")
public class PlayerClub {

    @EmbeddedId
    private PlayerClubId id = new PlayerClubId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("playerId")
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("clubId")
    @JoinColumn(name = "club_id", nullable = false)
    private Club club;

    // null = el jugador pertenece ACTUALMENTE al club
    @Column(name = "end_date")
    private LocalDate endDate;

    public PlayerClub(Player player, Club club, LocalDate startDate, LocalDate endDate) {
        this.player = player;
        this.club = club;
        this.endDate = endDate;
        this.id = new PlayerClubId(player.getId(), club.getId(), startDate);
    }

}
