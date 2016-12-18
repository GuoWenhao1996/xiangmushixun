package com.null6th.BirdEatWorms.view;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	public GameFrame() {
		init();
	}

	private void init() {
		this.setTitle("老鹰吃小鸟");
		this.setSize(1136, 669);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new GamePanel());
	}
}
