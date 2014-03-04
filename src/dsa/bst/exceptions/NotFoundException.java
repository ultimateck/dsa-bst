package dsa.bst.exceptions;

@SuppressWarnings("serial")
public class NotFoundException extends Exception {
	
	public NotFoundException(){}
	
	public NotFoundException(String s){
		super(s);
    }

	public String messageForUser(){
		
		return "Not Found Exception Happend....";
		
	}
	
}
