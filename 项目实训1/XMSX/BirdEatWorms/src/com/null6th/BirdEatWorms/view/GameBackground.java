package com.null6th.BirdEatWorms.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.null6th.BirdEatWorms.util.R;

public class GameBackground {

	private BufferedImage bg1;
	private BufferedImage bg2;
	private BufferedImage ground;
	private BufferedImage cloud;
	private int ground_x = 0;
	private int cloud_x = 0;
	private int ground_y = 0;
	private int bg_x = 0;

	public GameBackground() {
		bg1 = R.lode("bg.png");
		bg2 = R.lode("bg.png");
		ground = R.lode("ground.png");
		cloud = R.lode("cloud.png");
		ground_x = 0;
		cloud_x = 0;
		bg_x = 0;
		ground_y = bg1.getHeight() - ground.getHeight();
	}

	public int getSkyHeigh() {
		return bg1.getHeight() - ground.getHeight();
	}

	public int getSkyWeigh() {
		return bg1.getWidth();
	}

	public void reset() {
		ground_x = 0;
		bg_x = 0;
		cloud_x = 0;
	}

	public void paintsky(Graphics g) {
		if(Worm.speed / 3==0)
			bg_x=bg_x;
		else
			bg_x = bg_x - Worm.speed / 3-1;
		if (bg_x <= -bg1.getWidth())
			bg_x = 0;
		// 背景
		g.drawImage(bg1, bg_x, 0, null);
		g.drawImage(bg2, bg_x + bg1.getWidth(), 0, null);
	}

	public void paintground(Graphics g) {
		// 439为单位距离,
		if (ground_x <= -439 * 2) {
			ground_x = 0;
		}
		ground_x = ground_x - Worm.speed - 1;
		// 草地
		g.drawImage(ground, ground_x, ground_y, null);
	}

	public void paintcloud(Graphics g) {

		if (cloud_x <= -2640) {
			cloud_x = 0;
		}
		cloud_x = cloud_x - Worm.speed - 1;

		g.drawImage(cloud, cloud_x, 10, null);
	}
}
