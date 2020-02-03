// Anthony Wocken
// 10/11/16
// CSC142

//HW2 - Part 1

// This program uses the drawing panel to create several Ehrenstein Illusions.
// imports drawing class from text book
import java.awt.*;

public class WockenHW2_Part1 {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(400, 400);    // creates drawing panel
        panel.setBackground(Color.WHITE);                   // white background
        
        Graphics g = panel.getGraphics();                   // assigns panel to object g
        
        // target shape
        g.setColor(Color.CYAN);                             // outermost circle
        g.fillOval(50, 50, 310, 310);
        g.setColor(Color.RED);
        g.fillOval(70, 70, 270, 270);
        g.setColor(Color.CYAN);
        g.fillOval(90, 90, 230, 230);
        g.setColor(Color.RED);
        g.fillOval(110, 110, 190, 190);                     // innermost circle
        
        g.setColor(Color.WHITE);                            // changes color to white
        
        for (int a = 10; a <= 400; a+=10) {                 // arrays line radially
            g.drawLine(200, 400, -10+a, 0);
            
        }
        g.setColor(Color.GRAY);                             // gray rectangle behind text
        g.fillRect(15, 367, 400, 18);
        g.setColor(Color.WHITE);
        g.drawString("Anthony Wocken", 20, 380);            // white text
    }
}
        