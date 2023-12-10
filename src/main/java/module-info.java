module gui.messagebox {
    requires javafx.controls;
    requires javafx.fxml;


    opens gui.messagebox to javafx.fxml;
    exports gui.messagebox;
}