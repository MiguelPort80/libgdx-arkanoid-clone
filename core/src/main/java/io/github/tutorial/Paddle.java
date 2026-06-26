package io.github.tutorial;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
	private Integer x;
	private Integer y;
	private Integer width;
	private Integer height;



	public Paddle() {
	}
	
	public Paddle(Integer x, Integer y, Integer width, Integer height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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


	public void update() {
		this.x = Gdx.input.getX();
		//O opengl renderiza o paddle num lugar e o mouse no outro, se vc não inverter eles vão para direções opostas
		//this.y = ( Gdx.graphics.getHeight() - Gdx.input.getY() );
		
		if (x > Gdx.graphics.getWidth() - width){
			x = (Gdx.graphics.getWidth() - width) - 4;
		} 
		//gambiarra prime
		if (x < 4) {
			x += 3;
		}
		
		if (y > Gdx.graphics.getHeight() - height){
			y = (Gdx.graphics.getHeight() - height) - 4;
		} 
		
		
	}
	
	public void draw(ShapeRenderer shape) {
		shape.rect(x, y, width, height);
	}
}
