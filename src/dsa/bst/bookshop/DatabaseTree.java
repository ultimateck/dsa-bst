package dsa.bst.bookshop;

import dsa.bst.exceptions.*;

public interface DatabaseTree {

	public void insert(Object object) throws FullTreeException;
	
	public Object delete(String key) throws NotFoundException;
	
	public Object retrieve(String key) throws NotFoundException;
	
	public Object printList();
}
