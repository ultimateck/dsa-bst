package dsa.bst.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;

import dsa.bst.bookshop.Book;
import dsa.bst.exceptions.NotFoundException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearchAndDelete;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private void Clear(){
		
		txtSearchAndDelete.setText("");
	}
	
	public Delete() {
		setTitle("Delete a Book");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 249);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtSearchAndDelete = new JTextField();
		txtSearchAndDelete.setColumns(10);
		
		JLabel lblDeleteABook = new JLabel("Delete a Book");
		lblDeleteABook.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblSearch = new JLabel("Name");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnFindAndDelete = new JButton("Find and Delete");
		btnFindAndDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Book book = new Book();
				
				if(txtSearchAndDelete.getText().length() > 0){
					
					
					try {
						Main.bookShopDatabase.delete(txtSearchAndDelete.getText());
						JOptionPane.showMessageDialog(null,"Successfully Deleted... !!!" , "Deleted" , JOptionPane.INFORMATION_MESSAGE);
						Clear();
					} catch (NotFoundException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Sorry.. This Book is Not in our Books Store .. !!!" , "No Match !!!" , JOptionPane.ERROR_MESSAGE);
					} catch (Exception e) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null,"Error "+e.getMessage() , "Error !!!" , JOptionPane.ERROR_MESSAGE);
					}
				}else{
					JOptionPane.showMessageDialog(null,"Please fill a Book to Delete... !!!" , "Deleted" , JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblDeleteABook)
					.addContainerGap(285, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(34, Short.MAX_VALUE)
					.addComponent(lblSearch)
					.addGap(18)
					.addComponent(txtSearchAndDelete, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
					.addGap(92))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(151)
					.addComponent(btnFindAndDelete)
					.addContainerGap(166, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDeleteABook)
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSearchAndDelete, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSearch))
					.addGap(18)
					.addComponent(btnFindAndDelete)
					.addContainerGap(62, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
