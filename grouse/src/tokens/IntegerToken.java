package tokens;

import inputHandler.TextLocation;
import utilities.Debug;

public class IntegerToken extends TokenImp {
	protected int value;
	
	protected IntegerToken(TextLocation location, String lexeme) {
		super(location, lexeme);
	}
	protected void setValue(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	
	static Debug debug = new Debug();
	
	public static IntegerToken make(TextLocation location, String lexeme) {
		IntegerToken result = new IntegerToken(location, lexeme);
		
		result.setValue(Integer.parseInt(lexeme));
		
		return result;
	}
	
	@Override
	protected String rawString() {
		return "number, " + value;
	}
}
