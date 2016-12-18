package com.null6th.BirdEatWorms.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.null6th.BirdEatWorms.util.R;

public class Worm {
	private BufferedImage[] Worm = new BufferedImage[3];
	private int Worm_index = 0;
	public int x = 0;
	public int y = 0;
	public int w = 0;
	public int h = 0;
	private GamePanel gp;
	public int temp;
	public static int speed = 0;
	private long lasttime;// 上次修改速度的时间
	private long lasttimeimg;// 上次修改图片的时间

	public Worm(GamePanel gp) {
		this.gp = gp;
		Worm[0] = R.lode("worm0.png");
		Worm[1] = R.lode("worm1.png");
		Worm[2] = R.lode("worm2.png");
		w = Worm[0].getWidth();
		h = Worm[0].getHeight();
		speed = 1;
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
		temp = MyRandom(10, gp.getSkyHeigh() - 10 - Worm[0].getHeight());
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
		// x = x - 10;
		// if(GamePanel.score/5==1)
		if (System.currentTimeMillis() - lasttime > 15000) {
			lasttime = System.currentTimeMillis();
			speed++;
		}
		// if(speed<GamePanel.score/5)
		// speed=GamePanel.score/5;
		// System.out.println(speed);
		x = x - speed;
		x--;
		if (System.currentTimeMillis() - lasttimeimg > 480/(speed+1)) {
			Worm_index++;
			if (Worm_index == 3) {
				Worm_index = 0;
			}
			lasttimeimg = System.currentTimeMillis();
		}
		g.drawImage(Worm[Worm_index], x, y, null);
	}

}
