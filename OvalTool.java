import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ColorPicker;

/**
 * This class represents an OvalTool
 * @author Aditya Vishwanath
 * @version 1.0
 */
public class OvalTool implements Tool {

    private ColorPicker colorPicker;
    private double xInitial;
    private double yInitial;

    /**
     * OvalTool Constructor
     * @param colorPicker ColorPicker type
     */
    public OvalTool(ColorPicker colorPicker) {
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
    }

    /**
      * This method deals with actions to be called when the mouse is dragged
      *
      * @param e The mouseevent that fired this onDrag.
      * @param g The current graphics context.
      */
    public void onDrag(MouseEvent e, GraphicsContext g) {
        //Empty onDrag method
    }

    /**
      * This method deals with actions to take when the mouse is released
      *
      * @param e The mouseevent that fired this onRelease.
      * @param g The current graphics context.
      */
    public void onRelease(MouseEvent e, GraphicsContext g) {
        g.setFill(colorPicker.getValue());
        if (xInitial != e.getX() && yInitial != e.getY()) {
            g.fillOval(xInitial, yInitial, (e.getX() - xInitial),
                (e.getY() - yInitial));
        }
    }

    /**
     * The name of this tool.
     *
     * @return This tool's name.
     */
    public String getName() {
        return "Oval";
    }
}
