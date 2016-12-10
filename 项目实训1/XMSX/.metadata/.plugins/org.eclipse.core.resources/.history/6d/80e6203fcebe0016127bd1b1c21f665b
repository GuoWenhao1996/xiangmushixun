package com.null_6th_gwh.ball.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.null_6th_gwh.ball.util.R;

public class GamePipes {
	BufferedImage pipe;
	int pipe_x = 0;

	public GamePipes() {
		pipe = R.lode("column.png");
		pipe_x = 320;
	}

	public void paint(Graphics g) {
		// 58为管子的横像素
		if (pipe_x == -58)
			pipe_x = 320;
		pipe_x--;
		g.drawImage(pipe, pipe_x, 0, null);
	}
}
