package com.example.activecalc;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class HelloController {


    @FXML
    Slider sliderValue;

    @FXML
    Button bPlus, bMinus;

    @FXML
    TextField textValue;
    @FXML
    TextArea log;

    int x=0;

    public void initialize()
    {
        textValue.setText(String.valueOf(x));
        bMinus.setOnAction(actionEvent -> decrementX());
        bPlus.setOnAction( actionEvent -> incrementX());
        textValue.setOnAction(actionEvent -> {
           changeX(Integer.parseInt(textValue.getText()));
        });
        sliderValue.setOnMouseReleased(m->{
            changeX ((int) Math.round( sliderValue.getValue()));
        });
    }

    public void incrementX()
    {
        changeX(x+1);
    }

    public void decrementX()
    {
        changeX(x-1);
    }

    public void changeX(int xnew)
    {
        x = xnew;
        textValue.setText(String.valueOf(x));
        log.setText(log.getText()+"\n"+"x изменился и стал равен "+x);
        sliderValue.adjustValue(x);
    }

}