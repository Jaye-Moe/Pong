package com.example.pong;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ScoreBoard {
    private final Text scoreBoard;
    private String player;
    private int score;


    public ScoreBoard(){
        this.scoreBoard = new Text();
        this.score = 0;
        this.scoreBoard.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
    }

    public void setPlayer(String player){
        this.player = player;
    }

    public void moveScoreBoard(int xPosition, int yPosition){
        this.scoreBoard.setTranslateX(xPosition);
        this.scoreBoard.setTranslateY(yPosition);
    }
    public void scorePoint(){
        this.score = this.score + 1;
    }
    public Text getScoreBoard(){
        this.scoreBoard.setText(this.player + ": " + this.score);
        return this.scoreBoard;
    }

    @Override
    public String toString() {
        return this.player + ": " + this.score;
    }
}
