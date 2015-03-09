package perp.tree.stu;

import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine.Instruction;
import perp.tree.ExpressionNode;

public class Constant extends Object implements ExpressionNode {
	private int value;

	public Constant(int value) {
		// TODO Auto-generated constructor stub
		this.value = value;
	}

	@Override
	public void infixDisplay() {
		System.out.println(value);
		
	}

	@Override
	public List<Instruction> emit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int evaluate(SymbolTable symTab) {
		// TODO Auto-generated method stub
		return value;
	}

}
