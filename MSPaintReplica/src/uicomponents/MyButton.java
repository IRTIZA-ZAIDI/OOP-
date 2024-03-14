package uicomponents;

import swigncomponents.ButtonListener;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class MyButton
{
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Image image_depressed;
	protected Image image_pressed;
	protected Image current_image;

	//private String text;
	protected boolean pressed;
	protected ButtonListener listener;

	public MyButton(int x, int y, int width, int height, Image i_depressed, Image i_pressed)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		image_depressed = i_depressed.getScaledInstance(width, height, Image.SCALE_FAST);
		image_pressed = i_pressed.getScaledInstance(width, height, Image.SCALE_FAST);
		current_image = image_depressed;

		listener = new ButtonListener() {
			@Override
			public void click(int x, int y) {

			}
		};
	}

	public Image GetImage()
	{
		return current_image;
	}
	
	public Boolean IsPressed()
	{
		return pressed;
	}
	
	public void SetPressed(boolean pressed)
	{
		this.pressed = pressed;
		current_image=image_depressed;
	}


	// x and y coordinates of the mouse click
	public abstract boolean IsClicked(int x, int y);


	public void setListener(ButtonListener listener) {
		this.listener = listener;
	}

	public ButtonListener getListener() {
		return listener;
	}

	public void paint(Graphics graphics, ImageObserver observer) {
		graphics.drawImage(current_image, x, y, observer);
	}
}
