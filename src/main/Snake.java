package main;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Snake{
	private double velocityX = 0;
	private double velocityY = 0;
	Tile snakeHead = new Tile(10, 7);
	ArrayList<Tile> snakeBody;
	
    public void setVelocity(int x, int y){
        this.velocityX = x;
        this.velocityY = y;
    }

    public double getVelX(){
        return this.velocityX;
    }

    public double getVelY(){
        return this.velocityY;
    }

    
	}