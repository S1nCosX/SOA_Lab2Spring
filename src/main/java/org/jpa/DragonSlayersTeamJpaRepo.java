package org.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  DragonSlayersTeamJpaRepo extends JpaRepository<DragonSlayersTeam, Long> {
}
