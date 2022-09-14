// Done 1: Add pause at start of game until space bar is pressed
// Done 1b: Add starting instructions
// Done 2: Add game over mechanics if ball hits side walls
// Done 3: Add score tracker
// Done 4: Add game restart via space bar once game is over
// DONE 5: Add colors
// DONE 6: Make text look better

package com.example.pong;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;


public class Pong extends Application {



    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        pane.setPrefSize(600, 400);

        Paddle leftPaddle = new Paddle(0,255,0);
        leftPaddle.startingPosition(0, 120);
        Paddle rightPaddle = new Paddle(255,0,0);
        rightPaddle.startingPosition(570,120);

        ScoreBoard leftScore = new ScoreBoard();
        leftScore.setPlayer("Player 1");
        leftScore.moveScoreBoard(10 ,25);

        ScoreBoard rightScore = new ScoreBoard();
        rightScore.setPlayer("Player 2");
        rightScore.moveScoreBoard(460,25);

        Instructions instructions = new Instructions();
        instructions.setInstructions("Press the space bar to start");
        instructions.moveInstructions(160,100);


        Ball ball = new Ball();
        pane.getChildren().add(leftPaddle.getCharacter());
        pane.getChildren().add(rightPaddle.getCharacter());
        pane.getChildren().add(leftScore.getScoreBoard());
        pane.getChildren().add(rightScore.getScoreBoard());
        pane.getChildren().add(ball.getCharacter());
        pane.getChildren().add(instructions.getInstructions());

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        scene.setOnKeyPressed(event -> pressedKeys.put(event.getCode(), Boolean.TRUE));

        scene.setOnKeyReleased(event -> pressedKeys.put(event.getCode(), Boolean.FALSE));

        final boolean[] gameStarted = {false};

        new AnimationTimer() {

            @Override
            public void handle(long now) {
                if(pressedKeys.getOrDefault(KeyCode.SPACE, false)) {
                    if (!gameStarted[0]){
                        instructions.clearInstruction();
                        ball.gotoStart();
                        gameStarted[0] =true;
                    }
                }

                if(pressedKeys.getOrDefault(KeyCode.A, false)) {
                    leftPaddle.moveUp();
                }
                if(pressedKeys.getOrDefault(KeyCode.Z, false)) {
                    leftPaddle.moveDown();
                }
                if(pressedKeys.getOrDefault(KeyCode.UP, false)) {
                    rightPaddle.moveUp();
                }
                if(pressedKeys.getOrDefault(KeyCode.DOWN, false)) {
                    rightPaddle.moveDown();
                }

                if (gameStarted[0]){
                    ball.moveBall();
                }

                if (ball.getXPosition()<=0){
                    if (gameStarted[0]){
                        ball.changeDirection();
                        rightScore.scorePoint();
                        rightScore.getScoreBoard();
                        gameStarted[0] = false;
                        instructions.setInstructions("Press the space bar to start");
                        instructions.moveInstructions(160,100);

                    }


                }
                if (ball.getXPosition()>=580){
                    if(gameStarted[0]){
                        ball.changeDirection();
                        leftScore.scorePoint();
                        leftScore.getScoreBoard();
                        gameStarted[0] = false;
                        instructions.setInstructions("Press the space bar to start");
                        instructions.moveInstructions(160,100);

                    }
                }

                if (leftPaddle.checkCollision(ball)){
                    if (gameStarted[0]){
                        ball.changeDirection();
                        ball.moveBall();
                    }

                }
                if (rightPaddle.checkCollision(ball)){
                    if (gameStarted[0]){
                        ball.changeDirection();
                        ball.moveBall();
                    }

                }
            }
        }.start();


    }

    public static void main(String[] args) {
        launch(args);
    }
}