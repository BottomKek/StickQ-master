package com.mygdx.game;

public class PlayerCharacter {
    private int health;
    private int attack;
    private int defense;
    private int magic;
    private int speed;


    public PlayerCharacter (int hth, int atk, int def,int mag, int spd) {
        this.health = hth;
        this.attack = atk;
        this.defense = def;
        this.magic = mag;
        this.speed = spd;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}




