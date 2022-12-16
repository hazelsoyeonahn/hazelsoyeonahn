package pro;

public class OperatorNode extends ExpNode{
	String operator;
	
	public OperatorNode(String value) {
		super(value);
		this.operator = value;
	}
	
	boolean isOperator () {
		if(operator.equals("+")||operator.equals("-")||operator.equals("*")||operator.equals("/")||operator.equals("~")) {
			return true;
		}
		return false;
	}

	@Override
	public double evaluate() throws ArithmeticException {
	if(isOperator() == false) {
		throw new ArithmeticException("Unvalid operator");
	}
	if(operator.equals("+")) {
	return	super.leftChild.evaluate()+super.rightChild.evaluate();
	}
	else if(operator.equals("-")) {
	return super.leftChild.evaluate()-super.rightChild.evaluate();
	}
	else if(operator.equals("*")) {
		return super.leftChild.evaluate()*super.rightChild.evaluate();
	}
	else if(operator.equals("/")) {
		return super.leftChild.evaluate()*super.rightChild.evaluate();
	}
	else if(operator.equals("~")) {
		return 1/(super.rightChild.evaluate());
	}
	
		
		return 0;
	}

}
