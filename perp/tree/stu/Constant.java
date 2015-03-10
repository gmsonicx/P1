package perp.tree.stu;

import java.util.ArrayList;
import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine;
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
		System.out.print(value);
		
	}

	@Override
	public List<Instruction> emit() {
		// TODO Auto-generated method stub
		List<Instruction> a = new ArrayList<Instruction>();
		a.add(new Machine.PushConst(value));
		return a;
		
	}

	@Override
	public int evaluate(SymbolTable symTab) {
		// TODO Auto-generated method stub
		return value;
	}

}
