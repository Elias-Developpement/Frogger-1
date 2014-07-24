package com.exikle.frogger.entites;

import java.awt.Graphics;
import java.awt.Image;

import com.exikle.frogger.FroggerMain;
import com.exikle.frogger.Speed;

public class Car extends Entity {

	int speed;

	public Image img;

	public Car() {
		setSpeed(Speed.gen(+3, -3));
	}

	public void setSpeed(int s) {
		speed = s;
	}

	public int getSpeed() {
		return speed;
	}

	public void newCar(Image car) {
		this.img = car;
	}

	public Image getCarPic() {
		return img;
	}

	@Override
	public void draw(Graphics g, FroggerMain _main) {
		g.drawImage(getCarPic(), getX(), getY(), _main);
	}

	public void resetObj(int x) {
		if (getX() > x) {
			setX(0);
		}
		if (getX() < 0) {
			setX(x);
		}
	}
}
