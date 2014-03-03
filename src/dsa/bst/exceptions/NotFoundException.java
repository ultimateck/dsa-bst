package dsa.bst.exceptions;

@SuppressWarnings("serial")
public class NotFoundException extends Exception {
	
	NotFoundException(){}
	
	NotFoundException(String s){
		super(s);
    }

	public String messageForUser(){
		
		return "Not Found Exception Happend....";
		
	}
	
}
