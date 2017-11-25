enum Value{
	EMPTY, X, O;
}
public class Cell {
	Value val;
	
	
	
	public Cell() {
		val = Value.EMPTY;
	}
	
	public Value getVal() {
		return val;
	}
	
	public void setVal(Value val) {
		this.val = val;
	}
}
