package org.services;

import org.jpa.DragonSlayersTeam;
import org.jpa.DragonSlayersTeamJpaRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DragonSlayersTeamService {
    private final DragonSlayersTeamJpaRepo repo;
    public DragonSlayersTeamService(DragonSlayersTeamJpaRepo repo) {
        this.repo = repo;
    }

    public DragonSlayersTeam createDragonSlayersTeam(
            long teamId,
            String teamName,
            long teamSize,
            long caveId
    ) {
        DragonSlayersTeam team = new DragonSlayersTeam(
                teamId,
                teamName,
                teamSize,
                caveId
        );
        return repo.save(team);
    }
}
