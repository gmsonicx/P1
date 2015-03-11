package perp.tree.stu;

import java.util.ArrayList;
import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine;
import perp.machine.stu.Machine.Instruction;
import perp.tree.ExpressionNode;

public class Constant extends Object implements ExpressionNode {
	//An expression node representing a constant, i.e., literal value
	
	private int value;
	//Initialize value

	public Constant(int value) {
		// Store the integer value in this new Constant.
		this.value = value;
	}

	@Override
	public void infixDisplay() {
		//Print this Constant's value on standard output.
		System.out.print(value);
		
	}

	@Override
	public List<Instruction> emit() {
		// Emit an instruction to push the value onto the stack.
		List<Instruction> a = new ArrayList<Instruction>();
		a.add(new Machine.PushConst(value));
		return a;
		
	}

	@Override
	public int evaluate(SymbolTable symTab) {
		// Evaluate the constant
		return value;
	}

}
