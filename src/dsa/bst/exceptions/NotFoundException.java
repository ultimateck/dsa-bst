package dsa.bst.exceptions;

@SuppressWarnings("serial")
public class NotFoundException extends Exception {
	String key;
	public NotFoundException(){}
	
	public NotFoundException(String key){
		super(key);
		this.key = key;
		
    }

	public String messageForUser(){
		
		return "Not Found Exception Happend....";
		
	}

	@Override
	public String getMessage() {
		
		return key + " Not Found !";
	}
	
}
