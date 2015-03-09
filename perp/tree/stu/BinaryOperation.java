package perp.tree.stu;

import java.util.Collection;
import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine.Instruction;
import perp.tree.ExpressionNode;

public class BinaryOperation extends Object
implements ExpressionNode {
	
	static String ADD = "+";
	static String DIV = "//";
	static String MUL = "*";
	static Collection<String> OPERATORS = null;
	static String SUB = "-";
	String operator;
	ExpressionNode leftChild;
	ExpressionNode rightChild;
	
	public BinaryOperation(String operator, ExpressionNode leftChild, ExpressionNode rightChild) {
		// TODO Auto-generated constructor stub
		this.operator = operator;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	@Override
	public void infixDisplay() {
		// TODO Auto-generated method stub
		System.out.println(operator + leftChild + rightChild);
		
	}

	@Override
	public List<Instruction> emit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int evaluate(SymbolTable symTab) {
		// TODO Auto-generated method stub
		return 0;
	}

}
