package hotel.management;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DragListener extends MouseAdapter {
    private Point initialClick;

    @Override
    public void mousePressed(MouseEvent e) {
        initialClick = e.getPoint();
        Reservas.getWindows()[0].getComponentAt(initialClick);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // get location of Window
        int thisX = Reservas.getWindows()[0].getLocation().x;
        int thisY = Reservas.getWindows()[0].getLocation().y;

        // Determine how much the mouse moved since the initial click
        int xMoved = e.getX() - initialClick.x;
        int yMoved = e.getY() - initialClick.y;

        // Move window to new location
        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        Reservas.getWindows()[0].setLocation(X, Y);
    }
}

