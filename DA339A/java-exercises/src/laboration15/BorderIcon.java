package laboration15;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class BorderIcon implements Icon{
	private Icon icon;
    private int width;
    private Color color;
    
    public BorderIcon(Icon iconObject, int width) {
        this.icon = iconObject;
        this.width = width;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        icon.paintIcon(c,g,x,y);
        g.setColor(this.color);
        g.drawRect(x, y, getIconWidth(), getIconHeight());
        
    }

    public int getIconWidth() {
        return icon.getIconWidth();
    }

    public int getIconHeight() {
        return icon.getIconHeight();
    }
    
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("images/Gubbe.jpg");
        IconWindow.showIcon(new BorderIcon(icon,5));
    }
}
