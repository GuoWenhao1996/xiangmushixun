package com.null_6th_gwh.ball.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.null_6th_gwh.ball.util.R;

public class GameStatus {
	public void paint(Graphics g) {
		// 开始
		BufferedImage start = R.lode("start.png");
		g.drawImage(start, 0, 0, null);
	}
}
