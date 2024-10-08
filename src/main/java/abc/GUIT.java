package abc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUIT implements ActionListener {

	JFrame window;
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
	JMenuBar menuBar;
	JMenu menuFile , menuEdit,menuFormat,menuColor;
	JMenuItem iNew,iOpen,iSave,iSaveAs,iExit;
	JMenuItem iWrap,iFontArial,iFontCSMS,iFontSS, iFontSize8,iFontSize12,iFontSize16,iFontSize20,iFontSize24,iUndo,iRedo;
	JMenu menuFont,menuFontSize;
	
	JMenuItem iColor1,iColor2,iColor3,iColor4;
	
	FunctionFile file=new FunctionFile(this);
	FunctionColor color = new FunctionColor(this);
	FunctionFormat format= new FunctionFormat(this);
	FunctionEdit edit= new FunctionEdit(this);
	
	UndoManager um= new UndoManager();
		
	public static void main(String[] args) {
		
		new GUIT();
	}
	public GUIT() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createFormatMenu();
		createColorMenu();
		createEditMenu();
		
		format.selectedFont="Arial";
		format.createFont(20);
		format.wordWrap();
		
		window.setVisible(true);
	}
	public void createWindow() {
		window = new JFrame("Notepad");
		window.setSize(600,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void createTextArea() {
		textArea= new JTextArea();
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				}
				);
		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
		//window.add(textArea);
		
	}
	public void createMenuBar() {
	menuBar= new JMenuBar();
	window.setJMenuBar(menuBar);
	
	menuFile = new JMenu("File");
	menuBar.add(menuFile);
	
	menuEdit = new JMenu("Edit");
	menuBar.add(menuEdit);

	menuFormat = new JMenu("Format");
	menuBar.add(menuFormat);

	menuColor = new JMenu("Color");
	menuBar.add(menuColor);

	}
	public void createFileMenu() {
		
		iNew=new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen=new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave=new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs=new JMenuItem("Save As");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		menuFile.add(iSaveAs);
		
		iExit=new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
		
	}
	
	public void createColorMenu() {
		iColor1 = new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		menuColor.add(iColor1);
		iColor2 = new JMenuItem("Red");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Red");
		menuColor.add(iColor2);
		iColor3 = new JMenuItem("Blue");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Blue");
		menuColor.add(iColor3);
		iColor4 = new JMenuItem("Black");
		iColor4.addActionListener(this);
		iColor4.setActionCommand("Black");
		menuColor.add(iColor4);
		
	}
	public void createEditMenu() {
		
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
		
	}
		
	public void createFormatMenu() {

		iWrap= new JMenuItem("Word Wrap: Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuFormat.add(iWrap);

		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);

		
		iFontArial= new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);

		iFontCSMS =new JMenuItem("Comic Sans Ms");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);

		iFontSS =new JMenuItem("Sans serif");
		iFontSS.addActionListener(this);
		iFontSS.setActionCommand("Sans serif");
		menuFont.add(iFontSS);

		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);

		 
		iFontSize8 =new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("size8");
		menuFontSize.add(iFontSize8);
		
		iFontSize12 =new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("size12");
		menuFontSize.add(iFontSize12);
 
		iFontSize16= new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("size16");
		menuFontSize.add(iFontSize16);

		iFontSize20 =new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("size20");
		menuFontSize.add(iFontSize20);

		iFontSize24=new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("size24");
		menuFontSize.add(iFontSize24);

		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		
		switch(command) {
		case "New": file.newFile(); break;
		case"Open": file.open(); break;
		case"Save": file.save(); break;
		case"SaveAs": file.saveAs(); break;
		case"Exit": file.exit(); break;
		case"Word Wrap": format.wordWrap(); break;
		case"Arial": format.setFont(command); break;
		case"Comic Sans MS": format.setFont(command); break;
		case"Sans serif": format.setFont(command); break;
		case"size8": format.createFont(8); break;
		case"size12": format.createFont(12); break;
		case"size16": format.createFont(16); break;
		case"size20": format.createFont(20); break;
		case"size24": format.createFont(24); break;
		//case"Bold":format.setFont()
		case "Undo":edit.undo(); break;
		case "Redo":edit.redo(); break;
		case "White":color.changeColor(command); break;
		case "Red":color.changeColor(command); break;
		case "Blue":color.changeColor(command); break;
		case "Black":color.changeColor(command); break;
		}
	}
	
}


