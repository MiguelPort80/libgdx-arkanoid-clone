package io.github.tutorial;

import java.awt.Shape;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
	private Integer x;
	private Integer y;
	private Integer size;
	private Integer xSpeed;
	private Integer ySpeed;
	private Color color = Color.WHITE;

	public Ball() {
	}

	public Ball(Integer x, Integer y, Integer size, Integer xSpeed, Integer ySpeed) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getxSpeed() {
		return xSpeed;
	}

	public void setxSpeed(Integer xSpeed) {
		this.xSpeed = xSpeed;
	}

	public Integer getySpeed() {
		return ySpeed;
	}

	public void setySpeed(Integer ySpeed) {
		this.ySpeed = ySpeed;
	}

	public void update() {
		x += xSpeed;
		y += ySpeed;
		if (x < 0 || x > Gdx.graphics.getWidth() - size) {
			xSpeed = -xSpeed;
		}
		if (x <= 0 && x == size) {
			xSpeed = -xSpeed;
		}

		if (y > Gdx.graphics.getHeight() - size) {
			ySpeed = -ySpeed;
		}
		if (y < 0 || y == size) {
			ySpeed = -ySpeed;
		}

	}

	public void draw(ShapeRenderer shape) {
		shape.setColor(color);
		shape.circle(x, y, size);
	}

	public void checkCollision(Paddle paddle) {
		if (collidesWith(paddle)) {
			ySpeed = -ySpeed;
		} else {
			
		}
	}

	private boolean collidesWith(Paddle paddle) {
		// Raio = 20 colide se for menor que o X + raio

		Integer trueHeight = paddle.getY() + paddle.getHeight();
		Integer trueWidth = paddle.getX() + paddle.getWidth();
		// vefica a clisão do bottom-left
		if (trueHeight >= this.y - size && trueHeight <= this.y + size) {
			if (paddle.getX() >= this.x - size && paddle.getX() <= this.x + size) {

				return true;
			}
			// verifica a colisão do bottom-right
			if (trueWidth >= this.x - size && trueWidth <= this.x + size) {

				return true;
			}

		}

		// if (trueWidth >= this.x - size || trueWidth <= this.x + size) {
		// verifica a colisão do top
		// esquerda é menos, e direita é mais
		if (!(trueWidth > this.x - size) || !(trueWidth < this.x + size + paddle.getWidth())) {
			System.out.println("Eu odeio minha vida");
		} else {
			if (trueHeight == (this.y - size)) {
				return true;

			}
		}

		// }
		return false;
	}
	public void checkCollision(Block block) {
		if (collidesWith(block)) {
			ySpeed = -ySpeed;
			block.setDestroyed(true);
		} else {
			
		}
	}

	private boolean collidesWith(Block block) {
		// Raio = 20 colide se for menor que o X + raio

		Integer trueHeight = block.getY() + block.getHeight();
		Integer trueWidth = block.getX() + block.getWidth();
		// vefica a clisão do bottom-left
		if (trueHeight >= this.y - size && trueHeight <= this.y + size) {
			if (block.getX() >= this.x - size && block.getX() <= this.x + size) {

				return true;
			}
			// verifica a colisão do bottom-right
			if (trueWidth >= this.x - size && trueWidth <= this.x + size) {

				return true;
			}

		}

		// if (trueWidth >= this.x - size || trueWidth <= this.x + size) {
		// verifica a colisão do top
		// esquerda é menos, e direita é mais
		if (!(trueWidth > this.x - size) || !(trueWidth < this.x + size + block.getWidth())) {
			System.out.println("Eu odeio minha vida");
		} else {
			if (trueHeight == (this.y - size)) {
				return true;

			}
		}

		// }
		return false;
	}
}
