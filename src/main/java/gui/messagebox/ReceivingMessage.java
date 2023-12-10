package gui.messagebox;

public class ReceivingMessage extends Message{
    public static String[] botAnswer = {
      "Dạ vâng, rất vui khi được thông báo rằng" + "\n"
              + "anh là một trong số 1% sinh viên đã thành công" +"\n"
              + "nhận được bằng MBA của Harvard",
      "Tôi xin được phép đề nghị anh tham gia công ty \n" +
              "MIF và mong muốn anh trở thành 1 trong số chúng tôi \n" +
              "Không biết liệu anh có đồng ý không ?"
    };

    public ReceivingMessage(String input) {
        super();
        text = input;
        label.setText(text);
        label.getStyleClass().add("receiving-mess");
    }
}
