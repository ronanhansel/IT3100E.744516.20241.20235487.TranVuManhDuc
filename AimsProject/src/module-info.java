/**
 * 
 */
/**
 * 
 */
module AimsProject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;

    opens hust.soict.dsai.javafx to javafx.fxml; // Cho phép FXML truy cập vào package này
    exports hust.soict.dsai.javafx;
}
