package reglament;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class inspectReglament extends JFrame implements ActionListener{

			JTextArea textArea = new JTextArea();
			JPanel mainpanel;
            Font f;
            String input_level;
            String str=" ";
            String str6=" ";
            String str4=" ";
            String dir;
            String file;
            int len1;
            int i=0;
            int pos1;
            int len;

public inspectReglament(String str, String input_level) throws Exception{

	super("Просмотр регламента для уровня доступа " + input_level);
	setResizable(false);

	mainpanel=new JPanel();
	mainpanel=(JPanel)getContentPane();
	
	f=new Font("Monotype Corsiva",Font.PLAIN,15);
	JButton save_btn = new JButton("Сохранить регламент на диск");
	save_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
	save_btn.addActionListener(this);
	
	textArea.setEditable(false);
	
	JButton OK_btn = new JButton("OK");
	OK_btn.setFont(new Font("Tahoma", Font.PLAIN, 14));
	OK_btn.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	});
	GroupLayout groupLayout = new GroupLayout(getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(OK_btn, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(save_btn, GroupLayout.PREFERRED_SIZE, 204, Short.MAX_VALUE)))
				.addContainerGap())
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.TRAILING)
			.addGroup(groupLayout.createSequentialGroup()
				.addContainerGap()
				.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
					.addComponent(OK_btn)
					.addComponent(save_btn))
				.addContainerGap())
	);
	getContentPane().setLayout(groupLayout);
	try{
		String data = readFileAsString("level" + input_level + ".txt");
		textArea.setText(data);
	}
	catch(IOException e){}
}
	public static String readFileAsString(String fileName)throws Exception{
		String data = "";
  		data = new String(Files.readAllBytes(Paths.get(fileName)));
  		return data;
	}
	public void actionPerformed(ActionEvent e){
			try {
			FileDialog dialog1=new FileDialog(this,"Сохранить как..",FileDialog.SAVE);
			dialog1.setVisible(true);
			dir=dialog1.getDirectory();
			file=dialog1.getFile();
			str6=textArea.getText();
			len1=str6.length();
			byte buf[]=str6.getBytes();
			File f1=new File(dir + file + ".txt");
			FileOutputStream fobj1=new FileOutputStream(f1);
			for(int k=0;k<len1;k++){
				fobj1.write(buf[k]);
			}
			fobj1.close();
			}
		catch(IOException e1){}
	}
}


