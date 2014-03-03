package dsa.bst.bookshop;

public class BSTNode implements TreeNode {

	private Book book;
	private BSTNode leftchild;
	private BSTNode rightchild;
	
	public BSTNode(){
		this.book = null;
		this.leftchild = null;;
		this.rightchild = null;
	}
	
	public BSTNode(Book book){
		this();
		this.book = book;
	}
	
	public BSTNode(Book book, BSTNode leftchild, BSTNode rightchild){
		this.book = book;
		this.leftchild = leftchild;
		this.rightchild = rightchild;		
	}
	
	@Override
	public boolean isEmpty() {
		
		if(this.book == null)
			return true;
		else
			return false;
	}

	@Override
	public boolean isLeaf() {
		
		return (leftchild.isEmpty() && rightchild.isEmpty());
	}

	@Override
	public Book getContent() {
		
		return this.book;
	}
	
	@Override
	public void setContent(Object o){
		this.book = (Book)o;
	}

	@Override
	public BSTNode getLeft() {
		
		return this.leftchild;
	}

	@Override
	public BSTNode getRight() {
		
		return this.rightchild;
	}

	@Override
	public void setLeft(TreeNode t) {
		
		this.leftchild = (BSTNode)t;

	}

	@Override
	public void setRight(TreeNode t) {
		
		this.rightchild = (BSTNode)t;

	}

	@Override
	public boolean hasLeft() {
	
		if (this.leftchild == null) return false;
		
		return true;
	}

	@Override
	public boolean hasRight() {
		
		if (this.rightchild == null) return false;
		
		return true;
	}

}
