package com.example.pong;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Paddle {
    private final Polygon character;
    public Paddle(int R, int G, int B){
        this.character = new Polygon(
        10,10,
                10,90,
                20,90,
                20,10
        );
        Color color = Color.rgb(R, G, B);
        this.character.setFill(color);
    }

    public void startingPosition(int xPosition, int yPosition){
        this.character.setTranslateX(xPosition);
        this.character.setTranslateY(yPosition);
    }

    public void moveUp(){
        if (this.character.getTranslateY() >= 0){
            this.character.setTranslateY(this.character.getTranslateY() - 5);
        }
    }
    public void moveDown(){
        if (this.character.getTranslateY() <=310) {
            this.character.setTranslateY(this.character.getTranslateY() + 5);
        }
    }
    public Polygon getCharacter(){
        return this.character;
    }



    public boolean checkCollision(Ball other){
        Shape collisionArea = Shape.intersect(this.character, other.getCharacter());
        return collisionArea.getBoundsInLocal().getWidth() != -1;
    }



}
