package com.null6th.BirdEatWorms;

import javax.swing.SwingUtilities;

import com.null6th.BirdEatWorms.view.GameFrame;

public class GameStart {
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				GameFrame game=new GameFrame();
				game.setVisible(true);
			}
		});

	}
}
