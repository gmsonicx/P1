package perp.tree.stu;

import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine.Instruction;
import perp.tree.ExpressionNode;

public class Variable
extends Object
implements ExpressionNode {
	private String name;

	public Variable(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public void infixDisplay() {
		// TODO Auto-generated method stub
		System.out.println(name);
		
	}

	@Override
	public List<Instruction> emit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int evaluate(SymbolTable symTab) {
		// TODO Auto-generated method stub
		return symTab.get(name);
	}

}
