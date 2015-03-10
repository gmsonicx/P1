package perp.tree.stu;

import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine.Instruction;
import perp.tree.ActionNode;
import perp.tree.ExpressionNode;

public class Assignment extends Object implements ActionNode {

	String ident;
	ExpressionNode rhs;
	
	public Assignment(String ident, ExpressionNode rhs) {
		// TODO Auto-generated constructor stub
		this.ident = ident;
		this.rhs = rhs;
	}

	@Override
	public List<Instruction> emit() {
		// TODO Auto-generated method stub
		return rhs.emit();
	}

	@Override
	public void execute(SymbolTable symTab) {
		// TODO Auto-generated method stub
		symTab.put(this.ident, rhs.evaluate(symTab));

	}
	 
	@Override
	public void infixDisplay() {
		// TODO Auto-generated method stub
		System.out.print(ident + " := ");
		rhs.infixDisplay();
		System.out.print("\n");

	}

}
