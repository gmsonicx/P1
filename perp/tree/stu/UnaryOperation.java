package perp.tree.stu;

import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine.Instruction;
import perp.tree.ExpressionNode;

public class UnaryOperation
extends Object
implements ExpressionNode {

	public static final String NEG = "_";
	public static final String SQRT = "#";
	public static final List<String> OPERATORS = null; 
	String operator;
	ExpressionNode expr;
	public UnaryOperation(String operator, ExpressionNode expr) {
		// TODO Auto-generated constructor stub
		this.operator = operator;
		this.expr = expr;
	}

	@Override
	public void infixDisplay() {
		// TODO Auto-generated method stub
		System.out.println(operator + expr);
		
	}

	@Override
	public List<Instruction> emit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int evaluate(SymbolTable symTab) {
		// TODO Auto-generated method stub
		return 
				expr.evaluate(symTab);
	}

}
