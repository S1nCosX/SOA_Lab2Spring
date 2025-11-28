package org.jpa;

import lombok.*;
import org.jpa.servingclasses.classes.Coordinates;
import org.jpa.servingclasses.classes.DragonCave;
import org.jpa.servingclasses.enums.Color;
import org.jpa.servingclasses.enums.DragonCharacter;
import org.jpa.servingclasses.enums.DragonType;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Dragon {
    private long id;

    private String name;

    private Coordinates coordinates;

    private Date creationDate;

    private long age;

    private Color color;

    private DragonType type;

    private DragonCharacter character;

    private DragonCave cave;

    public void prePersist() {
        this.creationDate = new Date();
    }
}
