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
	
	static String ADD = "+";
	static String DIV = "//";
	static String MUL = "*";
	static String SUB = "-";
	static Collection<String> OPERATORS = new ArrayList<>(Arrays.asList(ADD, DIV, MUL, SUB));
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
	/*public String toString(){
	leftChild.infixDisplay();
	System.out.print(" " + this.operator + " ");
	rightChild.infixDisplay();
	}*/
	
	public void infixDisplay() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
