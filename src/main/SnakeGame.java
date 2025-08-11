package main;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class SnakeGame extends JPanel implements ActionListener, KeyListener{
    Timer gameLoop;
    private Image currBackground;
    private boolean initLoad = true;
    
    int tileSize = 40;
    int boardWidth;
    int boardHeight;

    private Snake snake;

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
        if(!boundaryCollision()){
            snake.snakeHead.x += snake.getVelX();
            snake.snakeHead.y += snake.getVelY();

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
            snake.setVelocity(1, 0);
        }

        if(e.getKeyChar() == 'h'){
            snake.setVelocity(-1, 0);
        }

        if(e.getKeyChar() == 'j'){
            snake.setVelocity(0, 1);
        }

        if(e.getKeyChar() == 'k'){
            snake.setVelocity(-1, 0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e){
        
    }

    @Override
    public void keyReleased(KeyEvent e){
        
    }


    private boolean boundaryCollision(){
        if(snake.snakeHead.x < 0 || snake.snakeHead.x > 20){
            return true;
        }

        if(snake.snakeHead.y < 0 || snake.snakeHead.y > 14){
            return true;
        }

        return false;
    }
}
