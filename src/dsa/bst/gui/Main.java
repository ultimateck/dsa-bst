package dsa.bst.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame{

	private JFrame frmBooksStore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmBooksStore.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBooksStore = new JFrame();
		frmBooksStore.setTitle("Books Store");
		frmBooksStore.setBounds(100, 100, 394, 271);
		frmBooksStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnInsertABook = new JButton("Insert a Book");
		btnInsertABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//
				
			}
		});
		
		JButton btnDeleteABook = new JButton("Print");
		
		JButton btnSearchABook = new JButton("Search a Book");
		btnSearchABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SearchBook searchBook = new SearchBook();
				searchBook.setVisible(true);
			}
		});
		
		JButton btnDeleteABook_1 = new JButton("Delete a Book");
		
		JLabel lblBooksStore = new JLabel("Books Store");
		lblBooksStore.setFont(new Font("Tahoma", Font.BOLD, 15));
		GroupLayout groupLayout = new GroupLayout(frmBooksStore.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnInsertABook, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnSearchABook, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnDeleteABook, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnDeleteABook_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblBooksStore)))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblBooksStore)
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInsertABook)
						.addComponent(btnDeleteABook))
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSearchABook)
						.addComponent(btnDeleteABook_1))
					.addContainerGap(62, Short.MAX_VALUE))
		);
		frmBooksStore.getContentPane().setLayout(groupLayout);
	}
}
