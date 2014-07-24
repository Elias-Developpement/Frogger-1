package com.exikle.frogger.entites;

import java.awt.Graphics;
import java.awt.Image;

import com.exikle.frogger.FroggerMain;

/**
 * The player class.
 * 
 * @author Dixon D'Cunha (Exikle)
 */
public class Frog extends Entity {

	private final int START_X = 320;

	private final int START_Y = 384;

	Image[] imgDirection = new Image[4];

	public Image curFrogImg;

	public Frog() {
		setX(START_X);
		setY(START_Y);
	}

	public void newFrog(Image[] frog) {
		imgDirection = frog;
		curFrogImg = imgDirection[0];
	}

	public void changeDirection(Direction dir) {
		switch (dir) {
			case UP:
				curFrogImg = imgDirection[0];
				break;
			case DOWN:
				curFrogImg = imgDirection[1];
				break;
			case LEFT:
				curFrogImg = imgDirection[2];
				break;
			case RIGHT:
				curFrogImg = imgDirection[3];
				break;
		}
	}

	public void changeCoordinates(int x, int y) {
		moveX(x);
		moveY(y);
	}

	@Override
	public void draw(Graphics g, FroggerMain _main) {
		g.drawImage(curFrogImg, getX(), getY(), _main);
	}

}
