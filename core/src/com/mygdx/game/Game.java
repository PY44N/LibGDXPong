package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
	private ShapeRenderer shapeRenderer;
	private SpriteBatch spriteBatch;
	private BitmapFont font;

	public int ballX = 300;
	public int ballY = 220;
	public int ballXVel = -3;
	public int ballYVel = -3;

	public int playerX = 10;
	public int playerY = 165;
	public int enemyX = 600;
	public int enemyY = 165;

	public int playerScore = 0;
	public int enemyScore = 0;

	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		spriteBatch = new SpriteBatch();
		font = new BitmapFont();

		font.getData().setScale(5f);
	}

	private boolean isColliding(int entity1X, int entity1Y, int entity1Width, int entity1Height, int entity2X, int entity2Y, int entity2Width, int entity2Height) {
		return entity1X < entity2X + entity2Width && entity1X + entity1Width > entity2X && entity1Y < entity2Y + entity2Height && entity1Y + entity1Height > entity2Y;
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		if (isColliding(playerX, playerY, 30, 150, ballX, ballY, 40, 40)) {
			ballXVel = 3;
		}
		if (isColliding(enemyX, enemyY, 30, 150, ballX, ballY, 40, 40)) {
			ballXVel = -3;
		}
		if (ballY > 440) {
			ballYVel = -3;
		}
		if (ballY < 0) {
			ballYVel = 3;
		}
		if (ballX > 660) {
			playerScore++;
			ballX = 300;
			ballY = 220;
		}
		if (ballX < -20) {
			enemyScore++;
			ballX = 300;
			ballY = 220;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			playerY += 3;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			playerY -= 3;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			enemyY += 3;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			enemyY -= 3;
		}
		ballX += ballXVel;
		ballY += ballYVel;

		spriteBatch.begin();
		font.draw(spriteBatch, String.valueOf(playerScore), 100, 400);
		font.draw(spriteBatch, String.valueOf(enemyScore), 480, 400);
		spriteBatch.end();
		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
		shapeRenderer.rect(ballX, ballY, 40, 40);
		shapeRenderer.rect(playerX, playerY, 30, 150);
		shapeRenderer.rect(enemyX, enemyY, 30, 150);
		shapeRenderer.end();
	}
	
	@Override
	public void dispose () {
		shapeRenderer.dispose();
		spriteBatch.dispose();
		font.dispose();
	}
}
