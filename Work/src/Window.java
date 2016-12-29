
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Window extends JFrame {
	public Window(){
	super("Доска");
	setBounds(0,0,1000,500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint (Graphics g){
		
        Color oldColor = g.getColor();
        Color newColor = new Color(0, 0, 255);
        g.setColor(newColor);
        g.setColor(oldColor);
        g.drawRect(10, 50, 100, 100);
        newColor = new Color(0, 215, 255);
        g.setColor(newColor);
        g.fillRect(11, 51, 99,99);
        g.setColor(oldColor);
        g.drawRect(10, 150, 100, 100);
        newColor = new Color(0, 215, 255);
        g.setColor(newColor);
        g.fillRect(11, 151, 99,99);
        g.setColor(oldColor);
        g.drawRect(100, 50, 100, 100);
        newColor = new Color(0, 215, 255);
        g.setColor(newColor);
        g.fillRect(101, 51, 99,99);
        g.setColor(oldColor);
        g.drawRect(100, 150, 100, 100);
        newColor = new Color(0, 215, 255);
        g.setColor(newColor);
        g.fillRect(101, 151, 99,99);
        g.setColor(oldColor);
        
	}

}
