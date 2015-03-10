package perp.tree.stu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine;
import perp.machine.stu.Machine.Instruction;
import perp.tree.ExpressionNode;

public class UnaryOperation
extends Object
implements ExpressionNode {

	public static final String NEG = "_";
	public static final String SQRT = "#";
	public static final List<String> OPERATORS = new ArrayList<>(Arrays.asList(NEG, SQRT)); 
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
		if (OPERATORS.contains(operator)){
			System.out.print(operator);
			expr.infixDisplay();
		}
		else{
			System.out.println("Invalid Operator.");
		}
		
	}

	@Override
	public List<Instruction> emit() {
		// TODO Auto-generated method stub
		List<Instruction> a = new ArrayList<Instruction>();
		if (operator.equals(NEG)){
			a.addAll(expr.emit());
			a.add(new Machine.Negate());
		}
		if (operator.equals(SQRT)){
			a.addAll(expr.emit());
			a.add(new Machine.SquareRoot());
		}
		return a;
	}

	@Override
	public int evaluate(SymbolTable symTab) {
		// TODO Auto-generated method stub
		int p = 0;
		if (operator.equals(NEG)){
			return p = 0 - expr.evaluate(symTab);
		}
		if (operator.equals(SQRT)){
				return p = (int) Math.sqrt(expr.evaluate(symTab));
		} return p;	
	}
}


