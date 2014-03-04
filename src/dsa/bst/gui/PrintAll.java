package dsa.bst.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;

import dsa.bst.bookshop.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PrintAll extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private static JTable dgSearchedItems;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintAll frame = new PrintAll();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/* View all books */
	public static void ViewAllBooks(){
		DefaultTableModel defaultTableModel = (DefaultTableModel)dgSearchedItems.getModel();
		ArrayList<Book> bk = (ArrayList<Book>) Main.bookShopDatabase.printList();  
		
		for(int i=0; i<dgSearchedItems.getRowCount(); i++){
			defaultTableModel.removeRow(i);
		}
		
		for(int i=0;i<bk.size();i++){
			Book book = bk.get(i);
			defaultTableModel.addRow(new String[]{book.getTitle(),book.getFirstName(),book.getSurName(),String.valueOf(book.getIsbn()),book.getCategory()});
		}	
	}
	
	/* View specific books */
	public static void ViewAllBooks(String searchQuery){
		DefaultTableModel defaultTableModel = (DefaultTableModel)dgSearchedItems.getModel();
		ArrayList<Book> bk = (ArrayList<Book>) Main.bookShopDatabase.printList(searchQuery);  
		
		//for(int i=0; i<dgSearchedItems.getRowCount(); i++){
			//defaultTableModel.removeRow(i);
			defaultTableModel.setRowCount(0);
		//}
		
		for(int i=0;i<bk.size();i++){
			Book book = bk.get(i);
			defaultTableModel.addRow(new String[]{book.getTitle(),book.getFirstName(),book.getSurName(),String.valueOf(book.getIsbn()),book.getCategory()});
		}	
	}
	
	/**
	 * Create the frame.
	 */
	public PrintAll() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				ViewAllBooks();
			}
		});
		
		setTitle("Print");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 504, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblPrintItems = new JLabel("Print Items");
		lblPrintItems.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtSearch.getText().length() > 0){
					ViewAllBooks(txtSearch.getText().trim());
				}else{
					ViewAllBooks();
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPrintItems)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addComponent(lblSearch)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(193)
							.addComponent(btnSearch))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblPrintItems)
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearch)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSearch)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		dgSearchedItems = new JTable();
		dgSearchedItems.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					 "Book", "First Name", "Last Name","ISBN","Category"
			}
		));
		scrollPane.setViewportView(dgSearchedItems);
		contentPane.setLayout(gl_contentPane);
	}
}
