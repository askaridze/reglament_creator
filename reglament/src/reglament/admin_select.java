package reglament;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin_select extends JFrame {

	private JPanel contentPane;
	public admin_select() {
		setResizable(false);
		setTitle("Настроить регламент");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton nLevel_1 = new JButton("Уровень доступа 1");
		nLevel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setReglament uroven_1 = new setReglament("1","1");
				uroven_1.setSize(600,500);
				uroven_1.setVisible(true);
			}
		});
		nLevel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton nLevel_2 = new JButton("Уровень доступа 2");
		nLevel_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setReglament uroven_2 = new setReglament("1","2");
				uroven_2.setSize(600,500);
				uroven_2.setVisible(true);
			}
		});
		nLevel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton nLevel_3 = new JButton("Уровень доступа 3");
		nLevel_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setReglament uroven_3 = new setReglament("1","3");
				uroven_3.setSize(600,500);
				uroven_3.setVisible(true);
			}
		});
		nLevel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton back = new JButton("Назад");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		back.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(nLevel_2, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
						.addComponent(nLevel_1, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
						.addComponent(nLevel_3, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
						.addComponent(back))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(nLevel_1)
					.addGap(18)
					.addComponent(nLevel_2)
					.addGap(18)
					.addComponent(nLevel_3)
					.addGap(18)
					.addComponent(back)
					.addContainerGap(29, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

