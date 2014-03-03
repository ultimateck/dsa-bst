package dsa.bst.bookshop;

public interface TreeNode {
	
	public boolean isEmpty();
    public boolean isLeaf();
    public Object getContent();
    public void setContent(Object o);
    public boolean hasLeft();
    public boolean hasRight(); 
    public TreeNode getLeft();
    public TreeNode getRight();
    public void setLeft(TreeNode t);
    public void setRight(TreeNode t);
    
}
