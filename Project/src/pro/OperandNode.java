package pro;

public class OperandNode extends ExpNode{
	double operand;
	
	public OperandNode(String value) {
		super(value);
		this.operand = Double.parseDouble(value);
	}

	@Override
	public double evaluate() throws ArithmeticException {
		return operand;
	}

}
