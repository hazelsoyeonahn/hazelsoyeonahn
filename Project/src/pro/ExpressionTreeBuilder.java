package pro;

import java.util.Stack;

public class ExpressionTreeBuilder {
	Stack<ExpNode> S = new Stack<ExpNode>();
	ExpNode P,P1,P2;
	int i;
	int count = 0;
		
	public ExpNode buildExpressionTree(String[] postfixStrings) {
		for(int i=0; i<postfixStrings.length; i++) {
			if(!isInteger(postfixStrings)) {
				P = new OperandNode(postfixStrings[i]);
				S.push(P);	
				++count;		
		}
			
		else if (postfixStrings.equals("+")||postfixStrings.equals("-")||postfixStrings.equals("*")||postfixStrings.equals("/")) {
				P = new OperatorNode(postfixStrings[i]);
				P1 = S.pop();
				P.rightChild = P1;
				P2 = S.pop();
				P.leftChild = P2;
				
			}
		else if (postfixStrings.equals("~")){
			P = new OperatorNode(postfixStrings[i]);
			P1 = S.pop();
			P.rightChild = P1;
		}
		}
		return P;
	}
	
	public static boolean isInteger(String[] postfixStrings)
	{ for(int i=0; i<postfixStrings.length; i++) {
	    try { 
	        Integer.parseInt(postfixStrings[i]); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
		}
	  return true;
	}
	
	public int countNodes() {
		return count;
	}
	public String toInfixString(ExpNode node) {
		String returnThis = null;
		
		
		
		return returnThis;
	}
}
