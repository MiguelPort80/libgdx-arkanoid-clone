package io.github.tutorial;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
	private ShapeRenderer shape;
	private Ball ball;
	private Paddle paddle;

	//Roda apenas uma vez no começo do programa
	@Override
	public void create() {
		Integer windowWidth = Gdx.graphics.getWidth();
		Integer windowHeight = Gdx.graphics.getHeight();

		shape = new ShapeRenderer();
		//ball1 = new Ball(300, 300, 20,10,5);
		ball = new Ball(windowWidth/2, windowHeight/2, 20,0,0);
		paddle = new Paddle(30,windowWidth,70,10);
		System.out.println(windowWidth);
	}
	
	//roda a cada frame
	@Override
	public void render() {
		//Serve para limpar a tela
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 
		ball.update();
		paddle.update();
		shape.setAutoShapeType(true);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.checkCollision(paddle);
		

		ball.draw(shape);
		paddle.draw(shape);
		
		System.out.println("Paddle X:"+paddle.getX());
		System.out.println("Paddle Y:"+paddle.getY());

//		System.out.println("Ball: "+ball.getX() ) ;
		shape.end();
	}
	
	
}
