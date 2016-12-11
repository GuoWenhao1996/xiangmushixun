package com.null_6th_gwh.ball.view;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
	private Thread gameThread = null;
	private GameBird bird;
	private GameBackground background;
	private GamePipes pipes;
	private GameStatus status;
	private GamePanel gp;
	
	
	public int getSkyHeigh() {
		return background.getSkyHeigh();
	}
	public int getSkyWeigh() {
		return background.getSkyWeigh();
	}
	
	public GamePanel() {
		bird = new GameBird();
		background = new GameBackground();
		pipes = new GamePipes(this);
		status = new GameStatus();
		init();
	}

	private void init() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				repaint();
				Thread.sleep(1000 / 60);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		// 1.绘制背景
		background.paintsky(g);
		// 2.绘制管子
		pipes.paint(g);
		// 3.绘制鸟
		bird.paint(g);
		// 4.绘制游戏状态
		status.paint(g);
		// 5.绘制草地
		background.paintground(g);

	}

}
