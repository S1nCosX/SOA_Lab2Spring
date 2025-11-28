package org.jpa;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
@Table(name = "DragonSlayersTeams")
@AllArgsConstructor
@NoArgsConstructor
public class DragonSlayersTeam {
    @Id
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long size;

    @Column(nullable = false)
    private long cave_id;
}
