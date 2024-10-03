package com.example.task1_1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.paint.Color;
import javafx.util.converter.DoubleStringConverter;

import java.util.function.UnaryOperator;

public class HelloController {
    @FXML
    private Canvas canvas;

    @FXML
    private ColorPicker colorPicker, colorPickerBorder;

    @FXML
    private TextField sideField, borderField, xField, yField;

    @FXML
    private void initialize() {
        setupNumericTextField(xField);
        setupNumericTextField(yField);
        setupNumericTextField(sideField);
        setupNumericTextField(borderField);
    }

    private void setupNumericTextField(TextField textField) {
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*(\\.\\d*)?")) {
                return change;
            }
            return null;
        };
        textField.setTextFormatter(new TextFormatter<>(new DoubleStringConverter(), 0.0, filter));
    }

    @FXML
    private void onClick(ActionEvent event) {
        double side = Double.parseDouble(sideField.getText());
        double border = Double.parseDouble(borderField.getText());
        double x = Double.parseDouble(xField.getText());
        double y = Double.parseDouble(yField.getText());


        System.out.println( "Side: "+ side);

        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); // Очистка всего холста

        Rectangle rectangle = new Rectangle(colorPicker.getValue(), colorPickerBorder.getValue(), side, border, x, y);
        rectangle.draw(graphicsContext);
        System.out.println(rectangle.toString());
    }
}