package com.mygdx.game;

public class Entity {
    public int initalX;
    public int initalY;
    public int x;
    public int y;
    public int width;
    public int height;

    public Entity(int x, int y, int width, int height) {
        initalX = x;
        initalY = y;
        resetPos();
        this.width = width;
        this.height = height;
    }

    public void resetPos() {
        x = initalX;
        y = initalY;
    }

    public void render() {
        Game.renderer.renderRect(x, y, width, height);
    }
}
