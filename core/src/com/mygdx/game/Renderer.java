package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Renderer {
    private ShapeRenderer shapeRenderer;
    private SpriteBatch spriteBatch;
    private BitmapFont font;

    public Renderer() {
        shapeRenderer = new ShapeRenderer();
        spriteBatch = new SpriteBatch();
        font = new BitmapFont();

        font.getData().setScale(5f);
    }

    public void renderRect(float x, float y, float width, float height) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(x, y, width, height);
        shapeRenderer.end();
    }

    public void renderText(float x, float y, String text) {
        spriteBatch.begin();
        font.draw(spriteBatch, text, x, y);
        spriteBatch.end();
    }

    public void dispose() {
        shapeRenderer.dispose();
        spriteBatch.dispose();
        font.dispose();
    }
}
