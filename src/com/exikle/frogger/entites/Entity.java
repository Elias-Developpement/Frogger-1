package com.exikle.frogger.entites;

import java.awt.Graphics;

import com.exikle.frogger.FroggerMain;

public abstract class Entity {

	/**
	 * Player's x-position
	 */
	protected int xPos;

	/**
	 * Player's y-position
	 */
	protected int yPos;

	/**
	 * Set the players x-position
	 * 
	 * @param x
	 */
	public void setX(int x) {
		xPos = x;
	}

	/**
	 * Set the players y-position
	 * 
	 * @param y
	 */
	public void setY(int y) {
		yPos = y;
	}

	/**
	 * Move the player by x on the x-axis
	 * 
	 * @param x
	 */
	public void moveX(int x) {
		xPos += x;
	}

	/**
	 * Move the player by y on the y-axis
	 * 
	 * @param y
	 */
	public void moveY(int y) {
		yPos += y;
	}

	/**
	 * @return the player's x-position
	 */
	public int getX() {
		return xPos;
	}

	/**
	 * @return the player's y-position
	 */
	public int getY() {
		return yPos;
	}

	public abstract void draw(Graphics g, FroggerMain _main);

}
