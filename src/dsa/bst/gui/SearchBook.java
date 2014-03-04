package dsa.bst.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import com.sun.org.apache.bcel.internal.generic.DMUL;
import com.sun.rowset.internal.Row;

import dsa.bst.bookshop.Book;
import dsa.bst.exceptions.NotFoundException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class SearchBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable dgbook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBook frame = new SearchBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*Check Is Numeric */
	private boolean isNumeric(String text) {
        if (text == null || text.trim().equals("")) {
            return false;
        }
        for (int iCount = 0; iCount < text.length(); iCount++) {
            if (!Character.isDigit(text.charAt(iCount))) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Create the frame.
	 */
	public SearchBook() {
		setTitle("Search a Book");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 497, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtSearch = new JTextField();
		txtSearch.setColumns(10);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		final JRadioButton rdbtnByName = new JRadioButton("By Name");
		rdbtnByName.setSelected(true);
		buttonGroup.add(rdbtnByName);
		
		final JRadioButton rdbtnByIsbn = new JRadioButton("By ISBN");
		buttonGroup.add(rdbtnByIsbn);
		
		JLabel lblSearchABook = new JLabel("Search A Book");
		lblSearchABook.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Book book = new Book();
					if(txtSearch.getText().length()>0){
						if(rdbtnByName.isSelected()){						
							
							book = (Book) Main.bookShopDatabase.retrieve(txtSearch.getText().toString());
							DefaultTableModel defaultTableModel = (DefaultTableModel)dgbook.getModel();
							
							for(int i=0; i<dgbook.getRowCount(); i++){
								defaultTableModel.removeRow(i);
							}
							
							defaultTableModel.addRow(new String[]{book.getTitle(),book.getFirstName(),book.getSurName(),String.valueOf(book.getIsbn()),book.getCategory()});
							
							
							//book.getFirstName().toString());
						
						}else if(rdbtnByIsbn.isSelected()){
							
							if(isNumeric(txtSearch.getText())){
									
								
								book = (Book) Main.bookShopDatabase.retrieve(Integer.parseInt(txtSearch.getText()));
								DefaultTableModel defaultTableModel = (DefaultTableModel)dgbook.getModel();
								
								for(int i=0; i<dgbook.getRowCount(); i++){
									defaultTableModel.removeRow(i);
								}
								
								defaultTableModel.addRow(new String[]{book.getTitle(),book.getFirstName(),book.getSurName(),String.valueOf(book.getIsbn()),book.getCategory()});
							}
							
						}
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSearchABook))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(69)
							.addComponent(lblSearch)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnByName)
									.addGap(18)
									.addComponent(rdbtnByIsbn)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnSearch))
								.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 432, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSearchABook)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSearch)
						.addComponent(txtSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnByName)
						.addComponent(btnSearch)
						.addComponent(rdbtnByIsbn))
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		dgbook = new JTable();
		dgbook.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"Book","First Name", "Last Name", "ISBN", "Category" 
			}
		));
		scrollPane.setViewportView(dgbook);
		contentPane.setLayout(gl_contentPane);
	}
}
