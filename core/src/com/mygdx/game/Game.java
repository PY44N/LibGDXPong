package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.util.AABB;

public class Game extends ApplicationAdapter {
	public static Renderer renderer;

	public Entity player;
	public Entity enemy;
	public Entity ball;

	public int ballXVel = -3;
	public int ballYVel = -3;

	public int playerScore = 0;
	public int enemyScore = 0;

	@Override
	public void create () {
		renderer = new Renderer();

		player = new Entity(10, 165, 30, 150);
		enemy = new Entity(600, 165, 30, 150);
		ball = new Entity(300, 220, 40, 40);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		if (AABB.isColliding(player, ball)) {
			ballXVel = 3;
		}
		if (AABB.isColliding(enemy, ball)) {
			ballXVel = -3;
		}
		if (ball.y > 440) {
			ballYVel = -3;
		}
		if (ball.y < 0) {
			ballYVel = 3;
		}
		if (ball.x > 660) {
			playerScore++;
			ball.resetPos();
		}
		if (ball.x < -20) {
			enemyScore++;
			ball.resetPos();
		}

		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			player.y += 3;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			player.y -= 3;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			enemy.y += 3;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			enemy.y -= 3;
		}
		ball.x += ballXVel;
		ball.y += ballYVel;

		renderer.renderText(100, 400, String.valueOf(playerScore));
		renderer.renderText(480, 400, String.valueOf(enemyScore));
		player.render();
		enemy.render();
		ball.render();
	}
	
	@Override
	public void dispose () {
		renderer.dispose();
	}
}
