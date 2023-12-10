package gui.messagebox;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MessageController implements Initializable {
    private String inputText = "";
    @FXML
    public Circle phoneIcon;
    @FXML
    public Circle videoIcon;
    public ScrollPane scrollPane;
    @FXML
    private TextField input;
    @FXML
    private Pane header;
    @FXML
    private Pane body;
    @FXML
    private Pane footer;

    public MessageController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image phoneImg = new Image(App.class.getResource("images/telephone.png").toString());
        phoneIcon.setFill(new ImagePattern(phoneImg));
        Image videoImg = new Image(App.class.getResource("images/video-record.png").toString());
        videoIcon.setFill(new ImagePattern(videoImg));
        scrollPane.setPrefViewportWidth(420);
        scrollPane.setPrefWidth(420);
        scrollPane.setFitToWidth(true);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        //scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }

    int wrapId = 1;
    public void GetInput(KeyEvent event) {
        StringBuilder text = new StringBuilder();
        text.append(input.getText());
        double breakNum = (double) text.length() / 26;
        for(int i = 1; i < breakNum; i++) {
            text.insert(26 * i - 1, System.lineSeparator());
        }
        inputText = text.toString();
        System.out.println(inputText);
    }
    private List<Label> MessageList = new ArrayList<>();
    private ReceivingMessage rc1, rc2;
    private boolean response = false;
    public void enter(MouseEvent mouseEvent) {
        if(mouseEvent.getClickCount() >= 1) {
            Pane content = new Pane();
            if(MessageList.size() == 2) {
                rc1 = new ReceivingMessage(ReceivingMessage.botAnswer[0]);
                rc2 = new ReceivingMessage(ReceivingMessage.botAnswer[1]);
                response = true;
                MessageList.add(rc1.getLabel());
                MessageList.add(rc2.getLabel());
            }
            SendingMessage sendingMessage = new SendingMessage(inputText);
            Label label = sendingMessage.getLabel();
            MessageList.add(label);
            for(int i = 0; i < MessageList.size(); i++) {
                Label item = MessageList.get(i);
                Text text = new Text(item.getText());
                new Scene(new Group(text));
                text.applyCss();
                double width = text.getLayoutBounds().getWidth();
                if(width < 60) width = 60;
                if(i == 2 || i == 3) {
                    item.setLayoutX(15);
                    item.setLayoutY(50 * i + i * 10);
                } else {
                    item.setLayoutX(420 - 16 - width);
                    item.setLayoutY(50 * i + i * 10);
                }
                content.getChildren().add(item);
            }
            scrollPane.setContent(content);
        }
    }

}
