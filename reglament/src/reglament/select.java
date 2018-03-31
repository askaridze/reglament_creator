package reglament;

import java.awt.BorderLayout;
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
public class select extends JFrame {
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					select frame = new select();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public select() {
		setTitle("Формирование регламента");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 225);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);		
		JButton admin = new JButton("Администрирование");
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin_select a = new admin_select();
				a.setVisible(true);
			}
		});
		admin.setFont(new Font("Tahoma", Font.PLAIN, 14));	
		JButton level1 = new JButton("Уровень доступа 1");
		level1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inspectReglament uroven_1;
				try {
					uroven_1 = new inspectReglament("1","1");
					uroven_1.setSize(600,500);
					uroven_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		level1.setFont(new Font("Tahoma", Font.PLAIN, 14));	
		JButton level2 = new JButton("Уровень доступа 2");
		level2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				inspectReglament uroven_2;
				try {
					uroven_2 = new inspectReglament("1","2");
					uroven_2.setSize(600,500);
					uroven_2.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		level2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JButton level3 = new JButton("Уровень доступа 3");
		level3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inspectReglament uroven_3;
				try {
					uroven_3 = new inspectReglament("1","3");
					uroven_3.setSize(600,500);
					uroven_3.setVisible(true);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		level3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(level1, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
						.addComponent(admin, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
						.addComponent(level2, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
						.addComponent(level3, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(admin)
					.addGap(18)
					.addComponent(level1)
					.addGap(18)
					.addComponent(level2)
					.addGap(18)
					.addComponent(level3)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
