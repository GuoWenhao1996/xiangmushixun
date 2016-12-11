package com.null_6th_gwh.ball.view;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.null_6th_gwh.ball.util.Music;

public class GamePanel extends JPanel implements Runnable {
	private Thread gameThread = null;
	private GameBird bird;
	private GameBackground background;
	private GamePipes pipes;
	private GameStatus status;

	public static final int READY = 0;
	public static final int PLAYING = 1;
	public static final int GAMEOVER = -1;
	public static int STATU = 0;

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
		// 监听点击事件
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseEvent();
			}
		});
		init();
	}

	public void mouseEvent() {
		if (STATU == READY) {
			STATU = PLAYING;
		} else if (STATU == GAMEOVER) {
			STATU = READY;
			bird.reset();
			pipes.reset(this);
		} else
			bird.Fly();
	}

	private void init() {
		gameThread = new Thread(this);
		gameThread.start();
		//new Music("bg.wav").start();
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
		if (STATU == PLAYING) {
			if (bird.isHidePipe(pipes.a,pipes.b)) {
				new Music("de.wav").start();
				STATU = GAMEOVER;
			}
			if (bird.isHideGround()) {
				new Music("de.wav").start();
				STATU = GAMEOVER;
			}
			// 2.绘制管子
			pipes.paint(g);
			// 3.绘制草地
			background.paintground(g);
			// 4.绘制鸟
			bird.paint(g);
		}
		// 5.绘制游戏状态
		status.paint(g);
	}
}
