package com.null_6th_gwh.ball.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.null_6th_gwh.ball.util.R;

public class GameBird {
	private BufferedImage[] birds = new BufferedImage[3];
	int bird_index = 0;
	int bird_x = 0;
	int bird_y = 0;
	double height = 0;
	long lasttime;// 上次画翅膀的时间
	/*
	 * bird_y height 0g 0.5g 0.5 2g 1.5 4.5g 2.5 8g 3.5
	 * 
	 */

	public GameBird() {
		birds[0] = R.lode("0.png");
		birds[1] = R.lode("1.png");
		birds[2] = R.lode("2.png");
		bird_x = 160 - birds[0].getWidth() / 2;
		System.out.println(bird_x);
		bird_y = 0;
		height = 0.5;
		lasttime = System.currentTimeMillis();
	}

	public void paint(Graphics g) {
		// height=height+height;
		if (bird_y + height > 400 - birds[0].getHeight()) {
			bird_y = 0;
			height = 0.5;
		} else
			bird_y = (int) (bird_y + height);
		if (System.currentTimeMillis() - lasttime > 120) {
			height = height + 1;
			bird_index++;
			if (bird_index == 3) {
				bird_index = 0;
			}
			lasttime = System.currentTimeMillis();
		}
		g.drawImage(birds[bird_index], bird_x, bird_y, null);

	}
}
