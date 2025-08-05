package main;

import javax.swing.*;

public class App{
    public static void main(String[] args) throws Exception{
        int boardWidth = 840;
        int boardHeight = boardWidth - 240;
		
		

        JFrame frame = new JFrame("vim snake");
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SnakeGame snakeGame = new SnakeGame(boardHeight, boardWidth);
        frame.add(snakeGame);
        frame.pack();
        snakeGame.requestFocus();
    }
}
