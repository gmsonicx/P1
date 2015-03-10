package perp.tree.stu;

import java.util.ArrayList;
import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine;
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
		System.out.print(name);
		
	}

	@Override
	public List<Instruction> emit() {
		// TODO Auto-generated method stub
		List<Instruction> a = new ArrayList<Instruction>();
		a.add(new Machine.Load(name));
		return a;
	}

	@Override
	public int evaluate(SymbolTable symTab) {
		// TODO Auto-generated method stub
		return symTab.get(name);
	}

}
