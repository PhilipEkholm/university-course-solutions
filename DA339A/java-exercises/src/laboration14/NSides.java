package laboration14;

import java.awt.Color;

import paintwindow.PaintWindow;

public class NSides extends Shape{
	private Point[] points;

	@Override
	public void paint(PaintWindow window) {
		
		for(int i = 0; i < points.length - 1; i++){
			int x1 = points[i].getX() + super.x,
				x2 = points[i + 1].getX() + super.x,
				y1 = points[i].getY() + super.y,
				y2 = points[i + 1].getY() + super.y;
			
			window.line(x1, y1, x2, y2, color, 1);
		}
		
		window.line(points[7].getX() + super.x, points[7].getY() + super.y, points[0].getX() + super.x, points[0].getY() + super.y, color, 1);
	}
	
	public NSides(int x, int y, Point[] points, Color color){
		super(x, y, color);
		this.points = points;
	}
}
