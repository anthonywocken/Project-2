// Anthony Wocken
// 10/11/16
// CSC142

//HW2 - Part 2

// This program uses the drawing panel to create several Ehrenstein Illusions.
// imports drawing class from text book
import java.awt.*;


public class WockenHW2_Part2 {
    public static void main(String[] args) {
        
        DrawingPanel panel = new DrawingPanel(850, 700);    // creates drawing panel
        panel.setBackground(Color.GRAY);                    // colors panel gray
        
        Graphics g = panel.getGraphics();                   // assigns panel to g graphics object
        
        int radius;                                         // radius of disks
        int xOrigin;                                        // x coordinate
        int yOrigin;                                        // y coordinate
        int columns;                                        // columns of disks
        int numberOfRings = 8;                              // number of disk rings
        
        // method calls
        //            x             y            radius     columns    rings
        drawCircle(g, xOrigin=50,   yOrigin=300, radius=30, columns=1, numberOfRings);
        drawCircle(g, xOrigin=750,  yOrigin=550, radius=50, columns=1, numberOfRings);
        drawCircle(g, xOrigin=320,  yOrigin=575, radius=90, columns=1, numberOfRings);
        drawCircle(g, xOrigin=75,   yOrigin=200, radius=25, columns=4, numberOfRings);
        drawCircle(g, xOrigin=25,   yOrigin=550, radius=20, columns=5, numberOfRings);
        drawCircle(g, xOrigin=475,  yOrigin=300, radius=70, columns=3, numberOfRings);
    }
    
    
    public static void  drawCircle(Graphics g, int xOrigin, int yOrigin, int radius, int columns, int numberOfRings) {
        int rows = 1;                                           // number of disks in leftmost column
        double circleSpace = (double)radius/numberOfRings;      // spacing of rings
        // reposition for next column
        for(int x = 1; x <= columns; x++) {
            // column of disks
            for(int a = 1; a <= rows; a++) {
                g.setColor(Color.CYAN);                                         // color of disk
                g.fillOval(xOrigin-radius, yOrigin-radius, radius*2, radius*2); // draws background disk
                g.setColor(Color.RED);                                          // color of concentric rings
                
                // draws concentric disk rings
                for (int i = numberOfRings; i >= 0; i--) {
                    g.drawOval((xOrigin-(int)(circleSpace*i)), (yOrigin-(int)(circleSpace*i)), (int)(circleSpace*i*2), (int)(circleSpace*i*2));
                }
                // draws disk lines
                // lines   x1               y1              x2              y2
                g.drawLine(xOrigin+radius,  yOrigin,        xOrigin,        yOrigin+radius);
                g.drawLine(xOrigin+radius,  yOrigin,        xOrigin,        yOrigin-radius);
                g.drawLine(xOrigin,         yOrigin+radius, xOrigin-radius, yOrigin);
                g.drawLine(xOrigin,         yOrigin-radius, xOrigin-radius, yOrigin);
                
                yOrigin+=2*radius;              // to center of next disk
            }
            xOrigin+=radius;                    // positions x value for next disk
            
            yOrigin-=(radius+2*radius*rows);    // positions y value for next disk
            rows+=1;                            // adds circle to next column, for triangle shape
        
        }
        xOrigin+=radius;                        // positions x value for next column        
        yOrigin-=radius;                        // positions y value for next column    
        
    }
}
        