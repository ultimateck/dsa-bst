package dsa.bst.exceptions;

@SuppressWarnings("serial")
public class DuplicateUinqueValuesException extends Exception{
	
	String value;
	
	public DuplicateUinqueValuesException(){
		
	}
	
	public DuplicateUinqueValuesException(String s){
		
		super(s);
		this.value = s;
	}

	@Override
	public String getMessage() {
		
		return value + " Already Exist. \nYou cannot duplicate unique values";
	}
	
	
}
