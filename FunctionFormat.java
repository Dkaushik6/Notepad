package abc;

import java.awt.Font;

public class FunctionFormat {

	GUIT gui;
	Font arial,comicSansMS,sansSerif;
	String selectedFont;
	int selectedFontSize;
	
	public FunctionFormat(GUIT gui) {
		this.gui=gui;
		
	}

	public void wordWrap() {
		if(gui.wordWrapOn==false) {
			gui.wordWrapOn=true;
			gui.textArea.setLineWrap(true);
			gui.iWrap.setText("Word Wrap:On");
			
		}
		else if(gui.wordWrapOn==true) {
			gui.wordWrapOn=false;
			gui.textArea.setLineWrap(false);
			gui.iWrap.setText("Word Wrap:Off");
		}
	}
	public void createFont(int fontSize) {
		arial=new Font("Arial",Font.PLAIN,fontSize);
		comicSansMS=new Font("Comic Sans MS",Font.PLAIN,fontSize);
		sansSerif=new Font("Sans serif",Font.PLAIN,fontSize);
		//sansSerif=new Font("Sans serif",Font.BOLD,fontSize);
		
		
		setFont(selectedFont);
		
	}

	public void setFont(String font) {
		selectedFont=font;
		
		switch(selectedFont) {
		
		
		case "Arial":
			gui.textArea.setFont(arial);
			break;
		case "Comic Sans MS":
			gui.textArea.setFont(comicSansMS);
			break;
		case "Sans serif":
			gui.textArea.setFont(sansSerif);
			break;
			
		
		}
	}
	
}
