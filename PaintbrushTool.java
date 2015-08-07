import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.ColorPicker;

/**
 * This class represents a PaintbrushTool
 * @author Aditya Vishwanath
 * @version 1.0
 */
public class PaintbrushTool implements Tool {

    private ColorPicker colorPicker;

    /**
     * PaintbrushTool Constructor
     * @param colorPicker ColorPicker type
     */
    public PaintbrushTool(ColorPicker colorPicker) {
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
        g.setLineWidth(12);
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
        g.setLineWidth(12);
        g.stroke();
    }

    /**
     * This method deals with actions to take when the mouse is released
     *
     * @param e The mouseevent that fired this onRelease.
     * @param g The current graphics context.
     */
    public void onRelease(MouseEvent e, GraphicsContext g) {
        g.setLineWidth(1);
    }

    /**
     * The name of this tool.
     *
     * @return This tool's name.
     */
    public String getName() {
        return "Paintbrush";
    }
}
