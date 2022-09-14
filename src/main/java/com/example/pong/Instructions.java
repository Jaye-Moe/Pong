package com.example.pong;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Instructions {
    private final Label instructions;

    public Instructions(){
        this.instructions = new Label();
        this.instructions.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
    }

    public void setInstructions(String text){
        this.instructions.setText(text);
    }

    public void moveInstructions(double xPosition, double yPosition){
        this.instructions.setTranslateX(xPosition);
        this.instructions.setTranslateY(yPosition);
    }

    public void clearInstruction(){
        this.instructions.setText("");
    }

    public Label getInstructions(){
        return this.instructions;
    }
}
