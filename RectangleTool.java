import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ColorPicker;

/**
 * This class represents a RectangleTool
 * @author Aditya Vishwanath
 * @version 1.0
 */
public class RectangleTool implements Tool {

    private ColorPicker colorPicker;
    private double xInitial;
    private double yInitial;

    /**
     * RectangleTool Constructor
     * @param colorPicker ColorPicker type
     */
    public RectangleTool(ColorPicker colorPicker) {
        this.colorPicker = colorPicker;
    }

    /**
      * This method deals with actions to be called when the mouse is pressed
      *
      * @param e The mouseevent that fired this onPress.
      * @param g The current graphics context.
      */
    public void onPress(MouseEvent e, GraphicsContext g) {
        xInitial = e.getX();
        yInitial = e.getY();
        g.moveTo(xInitial, yInitial);
        g.setFill(colorPicker.getValue());
    }

    /**
      * This method deals with actions to be called when the mouse is dragged
      *
      * @param e The mouseevent that fired this onDrag.
      * @param g The current graphics context.
      */
    public void onDrag(MouseEvent e, GraphicsContext g) {
        double xCurrent = e.getX();
        double yCurrent = e.getY();

        double a = (xInitial > xCurrent)
            ? xInitial - xCurrent : xCurrent - xInitial;
        double b = (yInitial > yCurrent)
            ? yInitial - yCurrent : yCurrent - yInitial;

        g.setFill(colorPicker.getValue());
        g.setStroke(colorPicker.getValue());
        g.fillRect(xInitial, yInitial, a, b);
    }

    /**
      * This method deals with actions to take when the mouse is released
      *
      * @param e The mouseevent that fired this onRelease.
      * @param g The current graphics context.
      */
    public void onRelease(MouseEvent e, GraphicsContext g) {
        //Empty onRelease method
    }

    /**
     * The name of this tool.
     *
     * @return This tool's name.
     */
    public String getName() {
        return "Rectangle";
    }
}
