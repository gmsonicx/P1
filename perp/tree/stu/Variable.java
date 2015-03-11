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
	//The ExpressionNode for a simple variable
	
	private String name;
	//Initialize the name

	public Variable(String name) {
		// TSet the name of this new Variable.
		this.name = name;
	}

	@Override
	public void infixDisplay() {
		// Print on standard output the Variable's name.
		System.out.print(name);
		
	}

	@Override
	public List<Instruction> emit() {
		// Emit a LOAD instruction that pushes the Variable's value onto the stack.
		List<Instruction> a = new ArrayList<Instruction>();
		a.add(new Machine.Load(name));
		return a;
	}

	@Override
	public int evaluate(SymbolTable symTab) {
		// Evaluate a variable by fetching its value
		return symTab.get(name);
	}

}
