package com.mygdx.game;

public class Enemy {

    private int health;
    private int attack;
    private int defense;

    private int speed;


    public Enemy (int hth, int atk, int def, int spd) {
        this.health = hth;
        this.attack = atk;
        this.defense = def;

        this.speed = spd;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
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


