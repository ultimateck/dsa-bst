package dsa.bst.bookshop;

import dsa.bst.exceptions.*;

public interface Database {

	public abstract void insert(Object object) throws FullTreeException;
	
	public abstract void delete(String key) throws NotFoundException;
	
	public abstract void retrieve(String key) throws NotFoundException;
	
	public abstract void list();
}
