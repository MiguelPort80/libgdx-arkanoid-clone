package io.github.tutorial;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class Main extends ApplicationAdapter {
	private ShapeRenderer shape;
	private Ball ball;
	private Paddle paddle;
	private List<Block> blocks = new ArrayList<>();

	// Roda apenas uma vez no começo do programa
	@Override
	public void create() {
//		Integer windowWidth = Gdx.graphics.getWidth();
//		Integer windowHeight = Gdx.graphics.getHeight();

		int blockWidth = 63;
		int blockHeight = 20;

		for (int y = Gdx.graphics.getHeight() / 2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
			for(int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
				blocks.add(new Block(x,y,blockWidth,blockHeight));
			}
		}

		shape = new ShapeRenderer();
		ball = new Ball(100, 100, 15, 7, 3);
		// ball = new Ball(windowWidth/2, windowHeight/2, 20,0,0);
		paddle = new Paddle(30, 30, 70, 10);
	}

	// roda a cada frame
	@Override
	public void render() {
		// Serve para limpar a tela
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		ball.update();
		paddle.update();
		shape.setAutoShapeType(true);
		shape.begin(ShapeRenderer.ShapeType.Filled);
		ball.checkCollision(paddle);
		for (Block block : blocks) {
			block.draw(shape);
	        ball.checkCollision(block);
		}
		
		for(int i = 0; i < blocks.size(); i++) {
			Block b = blocks.get(i);
			if(b.isDestroyed()) {
				blocks.remove(i);
				
				i--;
			}
		}
		
		ball.draw(shape);
		paddle.draw(shape);

		System.out.println("Ball X:" + ball.getX());
		System.out.println("Ball Y:" + ball.getY());

//		System.out.println("Ball: "+ball.getX() ) ;
		shape.end();
	}

}
