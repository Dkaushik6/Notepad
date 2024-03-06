package abc;

public class FunctionEdit {
	GUIT gui;
	public FunctionEdit(GUIT gui) {
		this.gui=gui;
	}
	public void undo() {
		gui.um.undo();
	}
	public void redo() {
		gui.um.redo();
	}

}
