package dsa.bst.bookshop;

import java.util.ArrayList;
import java.util.List;

import dsa.bst.exceptions.FullTreeException;
import dsa.bst.exceptions.NotFoundException;

public class BookShopDatabase implements DatabaseTree {
	
	private BSTNode root;
	
	public BookShopDatabase(){
		this.root = null;
	}
	
	public BookShopDatabase(BSTNode book){
		this.root = book;
	}

	@Override
	public void insert(Object object) throws FullTreeException {
		try {
			Book b = (Book) object;
			root = insertBook(b, root);
			
		} catch(OutOfMemoryError ome){
			throw new FullTreeException();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
			// TODO: handle exception
		}
		
	}

	@Override
	public Object delete(String key) throws NotFoundException {
		BSTNode del;
		if((del = findBook(key, root)) == null)
			throw new NotFoundException();
		else
			root = removeBook(key, root);
		
		return del.getContent();	

	}
	

	@Override
	public Object retrieve(String key) throws NotFoundException {
		
		BSTNode searchnode = findBook(key,root);
		if(searchnode.isEmpty())
			throw new NotFoundException(key);
		
		return searchnode.getContent();

	}
	
	public Object retrieve(int isbn) throws NotFoundException {
		BSTNode searchnode = inOrderRetrieve(root, null, isbn);
		
		if (searchnode == null)
			throw new NotFoundException(isbn + "");
		else
			return searchnode.getContent();
	}

	@Override
	public List<Book> printList() {
		List<Book> bookList = new ArrayList<Book>();
		bookList = inOrderPrint(root, bookList, null);
		return bookList;

	}
	
	public List<Book> printList(String key) {
		List<Book> bookList = new ArrayList<Book>();
		bookList = inOrderPrint(root, bookList, key);
		return bookList;

	}
	
	/* Private Methods*/
	
	private BSTNode findBook(String title, BSTNode node){
		
		if(node == null || node.isEmpty())
			return node;
		else if (node.getContent().getTitle().compareTo(title) == 0)
			return node;
		else if (node.getContent().getTitle().compareTo(title) > 0)
			return findBook(title,node.getLeft());
		else
			return findBook(title, node.getRight());
	}
	
	private BSTNode insertBook(Book book, BSTNode node) throws OutOfMemoryError {
		
		if(node == null || node.isEmpty()){
			return new BSTNode(book);
		}
		
		if(book.getTitle().compareTo(node.getContent().getTitle()) < 0 ){
			node.setLeft(insertBook(book, node.getLeft()));
		}
		else if (book.getTitle().compareTo(node.getContent().getTitle()) > 0 ){
			node.setRight(insertBook(book, node.getRight()));
		}
		
		return node;
		
	}
	
	private BSTNode removeBook(String title, BSTNode node){
		
		if(node == null || node.isEmpty()){
			return node;
		}
		else{
			if(node.getContent().getTitle().compareTo(title) > 0){
				node.setLeft(removeBook(title, node.getLeft()));
				return node;
			}
			
			else if(node.getContent().getTitle().compareTo(title) < 0){
				node.setRight(removeBook(title, node.getRight()));
				return node;
			}
			
			else{
				BSTNode newnode;
				if(node.hasLeft() && node.hasRight()){
					Book newroot = findMin(node.getRight()).getContent();
					newnode = new BSTNode(newroot,node.getLeft(),removeMin(node.getRight()));
				}
				else
					newnode = (node.hasLeft()) ? node.getLeft() : node.getRight();
				return newnode;
			}
			
		}
	}
	
	private BSTNode findMin(BSTNode node){
		
		if(!node.isEmpty()){
			if(node.hasLeft())
				return findMin(node.getLeft());
			else
				return node;
		}
		return node;
	}
	
	private BSTNode removeMin(BSTNode node){
		
		if(!node.isEmpty()){
			if(!node.getLeft().isEmpty())
				node.setLeft(removeMin(node.getLeft()));
			else
				node = node.getRight();
		}
		
		return node;
	}
	
	private List<Book> inOrderPrint(BSTNode node, List<Book> list, String Key){
		
		if (node.hasLeft())
			list = inOrderPrint(node.getLeft(), list, Key);
		
		if(Key == null || Key == "")
			list.add(node.getContent());
		else if (node.getContent().getTitle().contains(Key))
			list.add(node.getContent());
		
		if (node.hasRight())
			list = inOrderPrint(node.getRight(), list, Key);
		
		return list;
		
	}
	
	private BSTNode inOrderRetrieve(BSTNode node, BSTNode search, int isbn){
		
		if (node.hasLeft())
			search = inOrderRetrieve(node.getLeft(), search, isbn);
		
		if(node.getContent().getIsbn() == isbn)
			search = node;
		
		if (search != null && node.hasRight())
			search = inOrderRetrieve(node.getRight(), search, isbn);
		
		return search;
	}

}
