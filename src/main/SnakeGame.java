package main;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class SnakeGame extends JPanel implements ActionListener, KeyListener{
    Timer gameLoop;
    private Image currBackground;
    private boolean initLoad = true;
    
    int tileSize = 40;
    int boardWidth;
    int boardHeight;

    private Snake snake;

    private class Tile{
        int x;
        int y;

        Tile(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
	
    private class Snake{
	private double velocityX = 0;
	private double velocityY = 0;
	Tile snakeHead = new Tile(10, 7);
	// Array<Tile> snakeBody;
	

	}


    public SnakeGame(int boardHeight, int boardWidth) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        if(initLoad){
            currBackground = new ImageIcon("../media/Background.png").getImage();
        }
        addKeyListener(this);
        setFocusable(true);

        snake = new Snake();

        

        gameLoop = new Timer(100, this);
        gameLoop.start();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
	g.setColor(Color.yellow);
        g.drawImage(currBackground, 0, 0, getWidth(), getHeight()+75, null);    
        g.fillRect(snake.snakeHead.x*tileSize, snake.snakeHead.y*tileSize, tileSize, tileSize);
    } 

    private void moveSnake(){
	if(snake.snakeHead.x <= 20 && snake.snakeHead.x >= 0){
     		snake.snakeHead.x += snake.velocityX;
	}
	
	if(snake.snakeHead.y >= 0 && snake.snakeHead.y <= 14){ 
       		snake.snakeHead.y += snake.velocityY;
	}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	moveSnake();
        repaint();
    }
    
    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyChar() == 'l'){
           snake.velocityX = 1;
	   snake.velocityY = 0;
        }

        if(e.getKeyChar() == 'h'){
            snake.velocityX = -1;
	    snake.velocityY = 0;
        }

        if(e.getKeyChar() == 'j'){
	   snake.velocityX = 0;
           snake.velocityY = 1;
        }

        if(e.getKeyChar() == 'k'){
            snake.velocityX = 0;
	    snake.velocityY = -1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e){
        
    }

    @Override
    public void keyReleased(KeyEvent e){
        
    }}
