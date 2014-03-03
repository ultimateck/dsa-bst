package dsa.bst.exceptions;

@SuppressWarnings("serial")
public class FullTreeException extends Exception{
	
	public FullTreeException() {
		
	}

	public String messageForUser(){
		
		return "Full Tree Exception Happend....";
		
	}
	
}
