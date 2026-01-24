package org.server.ejb.interfaces;

import org.Dragon.Dragon;

import jakarta.ejb.Remote;

@Remote
public interface DragonsBusinessInterface {
    Dragon findDeepestDragon(String order);

    void killDragon(Long id);
}
