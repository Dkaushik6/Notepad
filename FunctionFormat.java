package abc;

public class FunctionFormat {

	GUI gui;
	
	public FunctionFormat(GUIT guit) {
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
}
