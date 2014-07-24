package com.exikle.frogger;

public class Speed {

	public static int gen(int min, int max) {
		int s;
		do {
			s = min + (int) (Math.random() * ((max - min) + 1));
		} while (s == 0);
		return s;
	}
}
