import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * Driver class for PaintFX Application
 * My OvalTool displays terrible ovals :(
 * But I have a very cool Pencil, Rectangle and Paintbrush!
 * @author Aditya Vishwanath
 * @version 1.0
 */
public class PaintFX extends Application {

    private Canvas canvas;
    private ColorPicker colorPicker;
    private Tool tool;
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 400;

    /**
     * Overriden start method
     * Sets up the stage for the PaintFX Application
     * @param stage Stage type
     */
    @Override
    public void start(Stage stage) {

        canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        colorPicker = new ColorPicker();
        setupCanvas(gc);

        Label label = new Label("TOOLS");
        label.setUnderline(true);
        label.setFont(new Font(25));

        Button clearButton = new Button("Clear Canvas");
        clearButton.setOnAction(event -> {
                gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
                setupCanvas(canvas.getGraphicsContext2D());
            });

        PencilTool pObject = new PencilTool(colorPicker);
        Button pencil = new Button(pObject.getName());

        RectangleTool rObject = new RectangleTool(colorPicker);
        Button rectangle = new Button(rObject.getName());

        OvalTool oObject = new OvalTool(colorPicker);
        Button oval = new Button(oObject.getName());

        PaintbrushTool pbObject = new PaintbrushTool(colorPicker);
        Button paintbrush = new Button(pbObject.getName());

        tool = pObject; //Setting tool to PencilTool by default, like in Paint

        pencil.setOnAction(event -> {
                tool = pObject;
            });

        rectangle.setOnAction(event -> {
                tool = rObject;
            });

        oval.setOnAction(event -> {
                tool = oObject;
            });

        paintbrush.setOnAction(event -> {
                tool = pbObject;
            });

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> {
                tool.onPress(e, gc);
            });
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> {
                tool.onDrag(e, gc);
            });
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> {
                tool.onRelease(e, gc);
            });

        VBox vbox = new VBox();
        vbox.getChildren().addAll(
            label, colorPicker, pencil, rectangle,
            paintbrush, oval, clearButton);
        vbox.setSpacing(10);

        HBox hbox = new HBox();
        hbox.getChildren().addAll(vbox, canvas);

        Scene scene = new Scene(hbox);

        stage.setTitle("PaintFX");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Method to set up the canvas for drawing
     * @param gc GraphicsContext type
     */
    public void setupCanvas(GraphicsContext gc) {
        gc.setFill(Color.TRANSPARENT);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(5);
        gc.fill();
        gc.strokeRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
        gc.setFill(colorPicker.getValue());
        gc.setStroke(colorPicker.getValue());
        gc.setLineWidth(1);
    }
}
