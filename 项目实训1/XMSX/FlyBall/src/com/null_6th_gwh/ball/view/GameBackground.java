package com.null_6th_gwh.ball.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.null_6th_gwh.ball.util.R;

public class GameBackground {
	
	BufferedImage bg;
	BufferedImage ground;
	int ground_x=0;
	int ground_y=0;
	
	public GameBackground(){
		bg = R.lode("bg.png");
		ground = R.lode("ground.png");
		ground_x=0;
		ground_y=bg.getHeight()-ground.getHeight();
	}
	public int getSkyHeigh() {
		return bg.getHeight()-ground.getHeight();
	}
	public int getSkyWeigh() {
		return bg.getWidth();
	}
	
	
	public void paintsky(Graphics g){
		//背景
		g.drawImage(bg, 0, 0, null);
	}
	
	public void paintground(Graphics g){
		// 28为单位距离,5个单位距离重绘一次草地
		if (ground_x == -140)
			ground_x = 0;
		ground_x--;
		//草地
		g.drawImage(ground, ground_x,ground_y, null);
	}
}
