package perp.tree.stu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine;
import perp.machine.stu.Machine.Instruction;
import perp.tree.ExpressionNode;

public class BinaryOperation extends Object
implements ExpressionNode {
	
	//A calculation represented by a binary operator and its two operands.
	
	static String ADD = "+";
	//The operator symbol used for addition
	
	static String DIV = "//";
	//The operator symbol used for division
	
	static String MUL = "*";
	//The operator symbol used for multiplication
	
	static String SUB = "-";
	//The operator symbol used for subtraction
	
	static Collection<String> OPERATORS = new ArrayList<>(Arrays.asList(ADD, DIV, MUL, SUB));
	//Container of all legal binary operators, for use by parsers
	
	String operator;
	//Initializing the operator
	
	ExpressionNode leftChild;
	//Initializing leftChild
	
	ExpressionNode rightChild;
	//Initializing rightChild
	
	public BinaryOperation(String operator, ExpressionNode leftChild, ExpressionNode rightChild) {
		// Create a new BinaryOperation node.
		this.operator = operator;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public void infixDisplay() {
		// Print, on standard output, the infixDisplay of the two child nodes separated by the operator and surrounded by parentheses.
		if (OPERATORS.contains(operator)){
			System.out.print(" ( ");
			leftChild.infixDisplay();
			System.out.print(" " + this.operator + " ");
			rightChild.infixDisplay();
			System.out.print(" ) ");
		}
		else{
			System.out.println("Invalid Operator.");
		}
		
		
	}

	@Override
	public List<Instruction> emit() {
		// Emit the Machine instructions necessary to perform the computation of this BinaryOperation.
		List<Instruction> s = new ArrayList<Instruction>();
		s.addAll(leftChild.emit());
		s.addAll(rightChild.emit());
		if (operator.equals(ADD)){
			s.add(new Machine.Add());
		}
		if (operator.equals(SUB)){
			s.add(new Machine.Subtract());
		}
		if (operator.equals(DIV)){
			s.add(new Machine.Divide());
		}
		if (operator.equals(MUL)){
			s.add(new Machine.Multiply());
		}
		return s;
	}

	@Override
	public int evaluate(SymbolTable symTab) {
		// Compute the result of evaluating both operands and applying the operator to them.
		int result = 0;
		int a = leftChild.evaluate(symTab);
		int b = rightChild.evaluate(symTab);
		if (operator == ADD){
			result= (a + b);
		}
		if (operator == DIV){
			result = (a / b);
		}
		if (operator == MUL){
			result = (a*b);
		}
		if (operator == SUB){
			result = (a-b);
		}
		return result;
	}

}
