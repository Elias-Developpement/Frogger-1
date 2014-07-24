package com.exikle.frogger.graphics;

import java.awt.Color;
import java.awt.Graphics;

import com.exikle.frogger.Board;

public class Hud {

	/**
	 * Draw the Hud, score/lives/round is visible
	 * 
	 * @param graphics
	 *            of the game
	 */
	public static void drawHud(Graphics g, Board board) {
		g.setColor(Color.YELLOW);
		g.drawString("Round: " + board.getRoundNumber(), 10, 405);
		g.drawString("Lives: " + board.getPlayerLives(), 100, 405);
		g.drawString("Score: " + board.getPlayerScore(), 175, 405);
	}
}
