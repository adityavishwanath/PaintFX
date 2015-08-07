import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ColorPicker;

/**
 * This class represents a PencilTool
 * @author Aditya Vishwanath
 * @version 1.0
 */
public class PencilTool implements Tool {

    private ColorPicker colorPicker;

    /**
     * PencilTool Constructor
     * @param colorPicker ColorPicker type
     */
    public PencilTool(ColorPicker colorPicker) {
        this.colorPicker = colorPicker;
    }

    /**
     * This method deals with actions to be called when the mouse is pressed
     *
     * @param e The mouseevent that fired this onPress.
     * @param g The current graphics context.
     */
    public void onPress(MouseEvent e, GraphicsContext g) {
        g.beginPath();
        g.moveTo(e.getX(), e.getY());
        g.setStroke(colorPicker.getValue());
        g.stroke();
    }

    /**
     * This method deals with actions to be called when the mouse is dragged
     *
     * @param e The mouseevent that fired this onDrag.
     * @param g The current graphics context.
     */
    public void onDrag(MouseEvent e, GraphicsContext g) {
        g.lineTo(e.getX(), e.getY());
        g.setStroke(colorPicker.getValue());
        g.stroke();
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
        return "Pencil";
    }
}
