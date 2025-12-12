package org.Dragon;

import lombok.*;
import org.Dragon.servingclasses.classes.Coordinates;
import org.Dragon.servingclasses.classes.DragonCave;
import org.Dragon.servingclasses.enums.Color;
import org.Dragon.servingclasses.enums.DragonCharacter;
import org.Dragon.servingclasses.enums.DragonType;

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
