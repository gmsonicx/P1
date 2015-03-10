package perp.tree.stu;

import java.util.ArrayList;
import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine.Instruction;
import perp.tree.ActionNode;
import perp.tree.ExpressionNode;

public class Print extends Object implements ActionNode {
	ExpressionNode e;

	public Print(ExpressionNode printee) {
		// TODO Auto-generated constructor stub
		this.e = printee;
	}

	@Override
	public void infixDisplay() {
		// TODO Auto-generated method stub
		e.infixDisplay();
	}

	@Override
	public List<Instruction> emit() {
		// TODO Auto-generated method stub
		List<Instruction> g = new ArrayList<Instruction>();
		g.addAll(e.emit());
		return g;
	}

	@Override
	public void execute(SymbolTable symTab) {
		// TODO Auto-generated method stub
		System.out.println("=== " + e.evaluate(symTab));

	}

}
