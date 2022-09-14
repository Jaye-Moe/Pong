package com.example.pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball {

    private final Circle ball;
    private int xMovement;
    private int yMovement;

    public Ball(){
        this.ball = new Circle(10,10,10);
        this.ball.setTranslateX(300);
        this.ball.setTranslateY(200);
        this.xMovement = -5;
        this.yMovement = -5;
        this.ball.setFill(Color.BLUE);
    }

    public void changeDirection(){
        this.xMovement = this.xMovement * -1;
    }

    public void gotoStart(){
        this.ball.setTranslateX(300);
        this.ball.setTranslateY(200);
    }

    public void bounceOffTopOrBottom(){
        this.yMovement = this.yMovement * -1;
    }

    public Circle getCharacter(){
        return this.ball;
    }
    public double getXPosition(){
        return this.ball.getTranslateX();
    }
    public void moveBall(){


        if (this.ball.getTranslateY()<=0 || this.ball.getTranslateY()>=380){
            bounceOffTopOrBottom();
        }
        this.ball.setTranslateX(this.ball.getTranslateX() + this.xMovement);
        this.ball.setTranslateY(this.ball.getTranslateY() + this.yMovement);

    }
}
