package abc;

import java.awt.Color;

public class FunctionColor {

	GUIT gui;
	public FunctionColor(GUIT gui) {
		this.gui=gui;
	}
	public void changeColor(String color) {
		switch(color) {
		case "White":
			gui.window.getContentPane().setBackground(Color.white);
			gui.textArea.setBackground(Color.WHITE);
			gui.textArea.setForeground(Color.black);
			break;
		case "Red":
			gui.window.getContentPane().setBackground(Color.red);
			gui.textArea.setBackground(Color.red);
			gui.textArea.setForeground(Color.black);
			break;
		case "Blue":
			gui.window.getContentPane().setBackground(Color.blue);
			gui.textArea.setBackground(Color.blue);
			gui.textArea.setForeground(Color.yellow);
			break;
		case "Black":
			gui.window.getContentPane().setBackground(Color.black);
			gui.textArea.setBackground(Color.black);
			gui.textArea.setForeground(Color.MAGENTA);
			break;
		}
	}
}
