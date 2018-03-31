package reglament;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class setReglament extends JFrame implements ActionListener{
            MenuBar mbar;
            Menu edit,format,font,font1,font2;
            MenuItem item1,item2,item3,item4,item5,item6;
            MenuItem fname1,fname2,fname3,fname4;
            MenuItem fstyle1,fstyle2,fstyle3,fstyle4;
            MenuItem fsize1,fsize2,fsize3,fsize4;
            JPanel mainpanel;
            TextArea text;
            Font f;
            String months[]={"Января","Февраля","Марта","Апреля","Мая","Июня","Июля","Августа","Сентября","Октября","Ноября","Декабря"};
            GregorianCalendar gcalendar;
            String input_level;
            String command=" ";
            String str=" ";
            String str6=" ";
            int len1;
            int i=0;
            int pos1;
            int len;

public setReglament(String str, String input_level){

	super("Создание регламента для уровня доступа " + input_level);
	setResizable(false);

	mainpanel=new JPanel();
	mainpanel=(JPanel)getContentPane();


	mbar=new MenuBar();
	setMenuBar(mbar);

	edit=new Menu("Изменить");
	format=new Menu("Форматирование");
	font=new Menu("Шрифт");
	font1=new Menu("Стиль шрифта");
	font2=new Menu("Размер шрифта");


	edit.add(item1=new MenuItem("Вырезать (Ctrl+X)"));
	edit.add(item2=new MenuItem("Копировать (Ctrl+C)"));
	edit.add(item3=new MenuItem("Вставить (Ctrl+V)"));
	edit.add(item4=new MenuItem("Удалить"));
	edit.add(item6=new MenuItem("Выбрать все (Ctrl+A)"));
	edit.add(item5=new MenuItem("Вставить Время/Дату"));
	mbar.add(edit);

	format.add(font);
	format.add(font1);
	format.add(font2);
	
	font.add(fname1=new MenuItem("Courier"));
	font.add(fname2=new MenuItem("Sans Serif"));
	font.add(fname3=new MenuItem("Monospaced"));
	font.add(fname4=new MenuItem("Symbol"));
	
	font1.add(fstyle1=new MenuItem("Обычный"));
	font1.add(fstyle2=new MenuItem("Жирный"));
	font1.add(fstyle3=new MenuItem("Курсив"));
	font1.add(fstyle4=new MenuItem("Жирный курсив"));
	
	font2.add(fsize1=new MenuItem("12"));
	font2.add(fsize2=new MenuItem("14"));
	font2.add(fsize3=new MenuItem("18"));
	font2.add(fsize4=new MenuItem("20"));
	
	mbar.add(format);
	
	item1.addActionListener(this);
	item2.addActionListener(this);
	item3.addActionListener(this);
	item4.addActionListener(this);
	item5.addActionListener(this);
	item6.addActionListener(this);
	fname1.addActionListener(this);
	fname2.addActionListener(this);
	fname3.addActionListener(this);
	fname4.addActionListener(this);
	fstyle1.addActionListener(this);
	fstyle2.addActionListener(this);
	fstyle3.addActionListener(this);
	fstyle4.addActionListener(this);
	fsize1.addActionListener(this);
	fsize2.addActionListener(this);
	fsize3.addActionListener(this);
	fsize4.addActionListener(this);
	
	
	text=new TextArea(25,25);
	
	f=new Font("Monotype Corsiva",Font.PLAIN,15);
	text.setFont(f);
	
	JButton save_1 = new JButton("Сохранить регламент");
	save_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try{
					str6=text.getText();
					len1=str6.length();
					byte buf[]=str6.getBytes();
			
					File f1=new File("level" + input_level + ".txt");
					FileOutputStream fobj1=new FileOutputStream(f1);
					for(int k=0;k<len1;k++){
						fobj1.write(buf[k]);
					}
					fobj1.close();
			}
			catch(IOException e){}
			dispose();
		}
	});
	GroupLayout groupLayout = new GroupLayout(getContentPane());
	groupLayout.setHorizontalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(10)
				.addComponent(text, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
				.addContainerGap())
			.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
				.addGap(196)
				.addComponent(save_1, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
				.addGap(194))
	);
	groupLayout.setVerticalGroup(
		groupLayout.createParallelGroup(Alignment.LEADING)
			.addGroup(groupLayout.createSequentialGroup()
				.addGap(32)
				.addComponent(text, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
				.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
				.addComponent(save_1)
				.addContainerGap())
	);
	getContentPane().setLayout(groupLayout);
}
public void actionPerformed(ActionEvent ae)
{
	command=(String)ae.getActionCommand();
	if(command.equals("Вырезать (Ctrl+X)")){
		str=text.getSelectedText();
		i=text.getText().indexOf(str);
		text.replaceRange(" ",i,i+str.length());
	}
	
	if(command.equals("Копировать (Ctrl+C)")){
		str=text.getSelectedText();
	}
	
	if(command.equals("Вставить (Ctrl+V)")){
		pos1=text.getCaretPosition();
		text.insert(str,pos1);
	}
	if(command.equals("Выбрать все (Ctrl+A)")){
		String strText=text.getText();
		int strLen=strText.length();
		text.select(0,strLen);
}
	if(command.equals("Удалить")){
		String msg=text.getSelectedText();
		i=text.getText().indexOf(msg);
		text.replaceRange(" ",i,i+msg.length());
	}
	if(command.equals("Вставить Время/Дату")){
		gcalendar=new GregorianCalendar();
		String h=String.valueOf(gcalendar.get(Calendar.HOUR));
		String m=String.valueOf(gcalendar.get(Calendar.MINUTE));
		String s=String.valueOf(gcalendar.get(Calendar.SECOND));
		String date=String.valueOf(gcalendar.get(Calendar.DATE));
		String mon=months[gcalendar.get(Calendar.MONTH)];
		String year=String.valueOf(gcalendar.get(Calendar.YEAR));
		String hms="Время"+" - "+h+":"+m+":"+s+" Дата"+" - "+date+" "+mon+" "+year;
		int loc=text.getCaretPosition();
		text.insert(hms,loc);
	}
	if(command.equals("Courier")){
		int fontSize=f.getSize();
		int fontStyle=f.getStyle();
	
		f=new Font("Courier",fontStyle,fontSize);
		text.setFont(f);
	}
	if(command.equals("Sans Serif")){
		int fontSize=f.getSize();
		int fontStyle=f.getStyle();
	
		f=new Font("Sans Serif",fontStyle,fontSize);
		text.setFont(f);
	}
	if(command.equals("Monospaced")){
		int fontSize=f.getSize();
		int fontStyle=f.getStyle();
		
		f=new Font("Monospaced",fontStyle,fontSize);
		text.setFont(f);
	}
	
	if(command.equals("Symbol")){
		int fontSize=f.getSize();
		int fontStyle=f.getStyle();
		
		f=new Font("Symbol",fontStyle,fontSize);
		text.setFont(f);
		System.out.println(f.getFamily());
	}
	if(command.equals("Обычный")){
		String fontName=f.getName();
		int fontSize=f.getSize();
		
		f=new Font(fontName,Font.PLAIN,fontSize);
		text.setFont(f);
	}
	if(command.equals("Жирный")){
		String fontName=f.getName();
		int fontSize=f.getSize();
		
		f=new Font(fontName,Font.BOLD,fontSize);
		text.setFont(f);
	}
	if(command.equals("Курсив")){
		String fontName=f.getName();
		int fontSize=f.getSize();
		
		f=new Font(fontName,Font.ITALIC,fontSize);
		text.setFont(f);
	}
	if(command.equals("Жирный курсив")){
		String fontName=f.getName();
		int fontSize=f.getSize();
		
		f=new Font(fontName,Font.BOLD|Font.ITALIC,fontSize);
		text.setFont(f);
	}
	
	if(command.equals("12")){
		String fontName=f.getName();
		int fontStyle=f.getStyle();
		
		f=new Font(fontName,fontStyle,12);
		text.setFont(f);
	}
	
	if(command.equals("14")){
		String fontName=f.getName();
		int fontStyle=f.getStyle();
		
		f=new Font(fontName,fontStyle,14);
		text.setFont(f);
	}
	if(command.equals("18")){
		String fontName=f.getName();
		int fontStyle=f.getStyle();
		
		f=new Font(fontName,fontStyle,18);
		text.setFont(f);
	}
	if(command.equals("20")){
		String fontName=f.getName();
		int fontStyle=f.getStyle();	
		f=new Font(fontName,fontStyle,20);
		text.setFont(f);
	}
}
}


