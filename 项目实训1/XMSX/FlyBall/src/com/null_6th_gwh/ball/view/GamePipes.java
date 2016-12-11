package com.null_6th_gwh.ball.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.null_6th_gwh.ball.util.R;

public class GamePipes {
	BufferedImage uppipe;
	BufferedImage downpipe;
	int x = 0;
	int upy = 0;
	int downy = 0;
	int distance = 0;
	GamePanel gp;

	public GamePipes(GamePanel gp) {
		this.gp = gp;
		distance = 100;
		uppipe = R.lode("up.png");
		downpipe = R.lode("down.png");
		reset();
	}

	private void reset() {
		//distance--;
		x = gp.getSkyWeigh();
		int temp = MyRandom(10, gp.getSkyHeigh() - distance - 10);
		upy = temp - uppipe.getHeight();
		downy = temp + distance;
		System.out.println(distance + "   " + temp + "   " + upy + " " + downy);

	}

	/*
	 * 返回a和b之间的随机数
	 * 
	 */
	private static int MyRandom(int a, int b) {
		return ((int) (Math.random() * Math.abs(a - b))) + Math.min(a, b);
	}

	public void paint(Graphics g) {
		// 管子的横像素
		if (x <= -uppipe.getWidth())
			reset();
		//x = x - 10;
		x--;
		g.drawImage(uppipe, x, upy, null);
		g.drawImage(downpipe, x, downy, null);
	}
}
