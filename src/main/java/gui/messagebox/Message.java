package gui.messagebox;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class Message {
    protected String text = "";
    protected Label label = new Label();

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public Message() {
        label.setMinWidth(70 + 10);
        label.setPrefHeight(50);
        label.setAlignment(Pos.CENTER);
    }
}
