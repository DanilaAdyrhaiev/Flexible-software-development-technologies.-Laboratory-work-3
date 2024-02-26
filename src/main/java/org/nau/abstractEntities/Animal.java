package org.nau.abstractEntities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Animal {
    protected long id;
    protected String name;
    protected int age;
    protected Gender gender;
    protected Personality personality;

    public enum Gender {
        FEMALE,
        MALE
    }

    public enum Personality {
        FRIENDLY,
        AGGRESSIVE,
        CALM,
        PLAYFUL,
        SHY
    }

    public abstract void makeSound();

    public abstract void move();
    public abstract void eat();
}
