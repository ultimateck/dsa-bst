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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import dsa.bst.bookshop.*;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtBook;
	private JTextField txtISBN;
	private JTextField txtFirstName;
	private JTextField txtLastName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/* Numeric Check */
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
	public AddBook() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 521, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAddBook = new JLabel("Add Book");
		lblAddBook.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblBook = new JLabel("Book");
		lblBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtBook = new JTextField();
		txtBook.setColumns(10);
		
		JLabel lblIsbn = new JLabel("ISBN");
		lblIsbn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtFirstName = new JTextField();
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtLastName = new JTextField();
		txtLastName.setColumns(10);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int mandatoryFeildCheck = 0;
				int numericReuired = 0;
				
				Book book = new Book();
				book.setCategory("Not yet Set");
				
				if(txtBook.getText().length() > 0){
					book.setTitle(txtBook.getText());
				}else{
					mandatoryFeildCheck +=1;
				}
				
				if(txtFirstName.getText().length() > 0){
					book.setFirstName(txtFirstName.getText());
				}else{
					mandatoryFeildCheck +=1;
				}
				
				if(txtLastName.getText().length() > 0){
					book.setSurName(txtLastName.getText());
				}else{
					mandatoryFeildCheck +=1;
				}
				
				if(txtISBN.getText().length() > 0){
					if(isNumeric(txtISBN.getText())){
						book.setIsbn(Integer.parseInt(txtISBN.getText()));
					}else{
						numericReuired += 1;
					}
				}else{
					mandatoryFeildCheck +=1;
				}
				
				
				if(mandatoryFeildCheck > 0){
					
					System.out.println("One or more feilds are missing");
				}else if(mandatoryFeildCheck == 0){
					if(numericReuired > 0){
						System.out.println("Numeric Required For ISBN");
					}else{
						System.out.println("You are Done !!!");
					}
				}
				
			}
		});
		
		JButton btnClear = new JButton("Clear");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAddBook)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(4)
											.addComponent(lblFirstName)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtFirstName, 136, 136, 136))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblBook)
											.addGap(18)
											.addComponent(txtBook, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(22)
											.addComponent(lblIsbn)
											.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
											.addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addGap(21)
											.addComponent(lblLastName)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtLastName, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(btnAddBook, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnClear, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
									.addGap(134)))
							.addGap(22))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblAuthor)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblAddBook)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBook)
						.addComponent(txtBook, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIsbn)
						.addComponent(txtISBN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addComponent(lblAuthor)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName)
						.addComponent(txtFirstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLastName)
						.addComponent(txtLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAddBook)
						.addComponent(btnClear)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
