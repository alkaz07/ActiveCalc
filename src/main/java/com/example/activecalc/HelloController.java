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
            x = Integer.parseInt(textValue.getText());
            log.setText(log.getText()+"\n"+"введено значение "+x);
            sliderValue.adjustValue(x);
        });
        sliderValue.setOnDragDetected(mouseEvent ->{
            x = (int) Math.round( sliderValue.getValue());
            textValue.setText(String.valueOf(x));
            log.setText(log.getText()+"\n"+"слайдер "+ x);
            sliderValue.adjustValue(x);

        });
    }

    public void incrementX()
    {
        x++;
        textValue.setText(String.valueOf(x));
        log.setText(log.getText()+"\n"+"x увеличился и стал равен "+x);
        sliderValue.adjustValue(x);
    }

    public void decrementX()
    {
        x--;
        textValue.setText(String.valueOf(x));
        log.setText(log.getText()+"\n"+"x уменьшился и стал равен "+x);
        sliderValue.adjustValue(x);
    }

}