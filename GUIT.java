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

public class GUIT implements ActionListener {

	JFrame window;
	JTextArea textArea;
	JScrollPane scrollPane;
	JMenuBar menuBar;
	JMenu menuFile , menuEdit,menuFormat,menuColor;
	JMenuItem iNew,iOpen,iSave,iSaveAs,iExit;
	
	JMenuItem iColor1,iColor2,iColor3,iColor4;
	
	FunctionFile file=new FunctionFile(this);
	FunctionColor color = new FunctionColor(this);
	FunctionFormat format= new FunctionFormat(this);
	
		
	public static void main(String[] args) {
		
		new GUIT();
	}
	public GUIT() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		
		createColorMenu();
		
		window.setVisible(true);
	}
	public void createWindow() {
		window = new JFrame("Notepad");
		window.setSize(600,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void createTextArea() {
		textArea= new JTextArea();
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
		
	public void createFormatMenu() {

		iWrap new JMenuItem("Word Wrap: Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuFormat.add(iWrap);

		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);

		iFontArial new MenuItem("Arial");


		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		menuFont.add(iFontArial);

		iFontCSMS new MenuItem("Comic Sans Ms");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		menuFont.add(iFontCSMS);

		iFontTRN new MenuItem("Times New Roman");
		iFontTRN.addActionListener(this);
		iFontTRN.setActionCommand("Times New Roman");
		menuFont.add(iFontTRN);

		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);

		 }
		
        
		
		FontCSMS new MenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		FontCSMS.setActionCommand("Comic Sans MS"); 
		menuFont.add(iFontCSMS);
		
		FontAriel new MenuItem("Ariel");
		iFontAriel.addActionListener(this);
		FontCSMS.setActionCommand("Ariel"); 
		menuFont.add(iFontAriel);

		Font TNR new MenuItem("Times New Roman");
		iFont TNR.addActionListener(this);
		iFont TNR.setActionCommand("Times New Roman");
		menuFont.add(iFont TNR);

		menuFontSize new JMenu("Font Size"); 
		menuFormat.add(menuFontSize);

		iFontSize8 new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("size8");
		menuFontSize.add(iFontSize8);
		
		iFontSize12 new MenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("size12");
		menuFontSize.add(iFontSize12);

		iFontSize16 new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("size16");
		menuFontSize.add(iFontSize16);

		1FontSize20 new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("size20");
		menuFontSize.add(iFontSize20);

		1FontSize24new MenuItem("24");
		1FontSize24.addActionListener(this);
		1FontSize24.setActionCommand("Times New Roman);
		menuFontSize.add(iFontSize24);

		iFontSize28 new MenuItem("8");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("Times New Roman");
		menuFontSize.add(iFontSize28);
		
		
		
		
		
		
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
		case "White":color.changeColor(command); break;
		case "Red":color.changeColor(command); break;
		case "Blue":color.changeColor(command); break;
		case "Black":color.changeColor(command); break;
		}
	}
	
}


