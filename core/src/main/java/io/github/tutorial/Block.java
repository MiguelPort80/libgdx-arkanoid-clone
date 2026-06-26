package io.github.tutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block {
	Integer x,y,width,height;
	private boolean destroyed = false;
	

	public Block() {
	}


	public Block(Integer x, Integer y, Integer width, Integer height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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


	public Integer getWidth() {
		return width;
	}


	public void setWidth(Integer width) {
		this.width = width;
	}


	public Integer getHeight() {
		return height;
	}


	public void setHeight(Integer height) {
		this.height = height;
	}
	
	public void draw(ShapeRenderer shape) {
		shape.rect(x, y, width, height);
	}


	public boolean isDestroyed() {
		return destroyed;
	}


	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	
	
	
}
