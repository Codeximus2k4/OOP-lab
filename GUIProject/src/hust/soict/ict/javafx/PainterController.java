package hust.soict.ict.javafx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
    private Color PenColor =  Color.TRANSPARENT;
    @FXML
    private Pane drawingAreaPane;
    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }
    @FXML
    void setDrawing(MouseEvent event){
        this.PenColor = Color.BLACK;
    }
    @FXML
    void setEraser(MouseEvent event){
        this.PenColor = Color.WHITE;
    }
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle= new Circle(event.getX(), event.getY(), 4, PenColor);
        drawingAreaPane.getChildren().add(newCircle);
    }

}
