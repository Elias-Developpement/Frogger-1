package com.exikle.frogger;

public class Board {

	public final int START_ROUND = 1;

	public final int START_LIVES = 3;

	public final int START_SCORE = 0;

	public final int APPLET_WIDTH = 640, APPLET_HEIGHT = 420;

	public final int START_X = 320;

	public final int START_Y = 384;

	private int roundNum;

	public final FroggerMain MAIN;

	public int getRoundNumber() {
		return roundNum;
	}

	public void setRoundNumber(int num) {
		roundNum = num;
	}

	private int playerLives;

	public int getPlayerLives() {
		return playerLives;
	}

	public void setPlayerLives(int playerLives) {
		this.playerLives = playerLives;
	}

	private int playerScore;

	public int getPlayerScore() {
		return playerScore;
	}

	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public Board(FroggerMain froggerMain) {
		MAIN = froggerMain;
		roundNum = START_ROUND;
		playerLives = START_LIVES;
		playerScore = START_SCORE;
	}

}
