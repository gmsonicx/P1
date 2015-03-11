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
	//A calculation represented by a unary operator and its operand.

	public static final String NEG = "_";
	//arithmetic negation operator
	
	public static final String SQRT = "#";
	//square root operator
	
	public static final List<String> OPERATORS = new ArrayList<>(Arrays.asList(NEG, SQRT)); 
	//Container of all legal unary operators, for use by parsers
	
	String operator;
	//Initialize operator
	
	ExpressionNode expr;
	//Initialize expr
	
	public UnaryOperation(String operator, ExpressionNode expr) {
		// Create a new UnaryOperation node.
		this.operator = operator;
		this.expr = expr;
	}

	@Override
	public void infixDisplay() {
		// Print, on standard output, the infixDisplay of the child nodes preceded by the operator and without an intervening blank.
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
		// Emit the Machine instructions necessary to perform the computation of this UnaryOperation.
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
		// Compute the result of evaluating the expression and applying the operator to it.
		int p = 0;
		if (operator.equals(NEG)){
			return p = 0 - expr.evaluate(symTab);
		}
		if (operator.equals(SQRT)){
				return p = (int) Math.sqrt(expr.evaluate(symTab));
		} return p;	
	}
}


