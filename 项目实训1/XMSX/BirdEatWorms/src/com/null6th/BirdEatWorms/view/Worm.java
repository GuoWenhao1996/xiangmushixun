package com.null6th.BirdEatWorms.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.null6th.BirdEatWorms.util.R;

public class Worm {
	private BufferedImage Worm;
	public int x = 0;
	public int y = 0;
	public int w = 0;
	public int h = 0;
	private GamePanel gp;
	public int temp;
	public int speed=0;
	private long lasttime;// 上次修改速度的时间


	public Worm(GamePanel gp) {
		this.gp = gp;
		Worm = R.lode("worm.png");
		w = Worm.getWidth();
		h = Worm.getHeight();
		speed=0;
		reset();
	}

	public void reset() {
		x = gp.getWidth();
		randomY();
	}

	/*
	 * 随机虫子位置
	 */
	public void randomY() {
		temp = MyRandom(10, gp.getSkyHeigh()-10-Worm.getHeight());
		y = temp;
	}

	/*
	 * 返回a和b之间的随机数
	 * 
	 */
	private static int MyRandom(int a, int b) {
		return ((int) (Math.random() * Math.abs(a - b))) + Math.min(a, b);
	}

	public void paint(Graphics g) {
		//x = x - 10;
		//if(GamePanel.score/5==1)
		if (System.currentTimeMillis() - lasttime > 10000) {
			lasttime = System.currentTimeMillis();
			speed++;
		}
		if(speed<GamePanel.score/5)
			speed=GamePanel.score/5;
		//System.out.println(speed);
		x=x-speed;
		x--;
		g.drawImage(Worm, x, y, null);
	}
	
}
