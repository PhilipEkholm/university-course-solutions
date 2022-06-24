package laboration14;

import java.awt.Color;

import javax.swing.ImageIcon;

import paintwindow.PaintWindow;

public class Animation extends Shape{
	private ImageIcon[] images;
	private int index;
	private boolean calledOnce = false;

	@Override
	public void paint(PaintWindow window) {
		if(!calledOnce){
			for (int i = 0; i < images.length; i++)
				window.showImage(images[i], 50, 50);

			calledOnce = true;
		}
		
		while(this.index < 10){
			PaintWindow.pause(100);
			this.index++;
		}
		
		this.hideIcons(window);
		this.index = 0;
	}
	
	private void hideIcons(PaintWindow window){
	}
	
	public Animation(ImageIcon[] images, int x, int y){
		super(x, y, Color.WHITE);
		this.images = images;
	}
}


































