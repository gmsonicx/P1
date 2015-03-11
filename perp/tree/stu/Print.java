package perp.tree.stu;

import java.util.ArrayList;
import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine.Instruction;
import perp.tree.ActionNode;
import perp.tree.ExpressionNode;

public class Print extends Object implements ActionNode {
	//A node that represents the displaying of the value of an expression on the console
	
	ExpressionNode e;
	//Initialize ExpressionNode

	public Print(ExpressionNode printee) {
		// Set up a Print node.
		this.e = printee;
	}

	@Override
	public void infixDisplay() {
		// Show this statement on standard output as the word "Print" followed by the infix form of the expression.
		e.infixDisplay();
	}

	@Override
	public List<Instruction> emit() {
		// This method returns the code emitted by the printee node that pushes the value of the printee expression
		// onto the stack, followed by a PRINT instruction
		List<Instruction> g = new ArrayList<Instruction>();
		g.addAll(e.emit());
		return g;
	}

	@Override
	public void execute(SymbolTable symTab) {
		// Evaluate the expression and display the result on the console.
		System.out.println("=== " + e.evaluate(symTab));

	}

}
