package View.GameView;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends Rectangle {
    private boolean isDark;


    public Tile(boolean isDark) {
        this.isDark = isDark;
        setWidth(50);
        setHeight(50);
        if(isDark) {
            setFill(Color.valueOf("#ff478e"));
        } else {
            setFill(Color.valueOf("#ffcce3"));
        }
    }
}
