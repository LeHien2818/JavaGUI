package gui.messagebox;

public class SendingMessage extends Message {

    public SendingMessage(String input) {
        super();
        text = input;
        label.setText(text);
        label.getStyleClass().add("sending-mess");
    }
}
