package perp.tree.stu;

import java.util.ArrayList;
import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine;
import perp.machine.stu.Machine.Instruction;
import perp.tree.ActionNode;
import perp.tree.ExpressionNode;

public class Assignment extends Object implements ActionNode {
	//An perp.tree.ActionNode that represents the assignment of the value of an expression to a variable.
	
	String ident = "";
	ExpressionNode rhs;
	
	public Assignment(String ident, ExpressionNode rhs) {
		// Set up an Assignment node.
		this.ident = ident;
		this.rhs = rhs;
	}

	@Override
	public List<Instruction> emit() {
		/*
		 * This method returns a STORE instruction for the variable in question preceded by the code 
		 * emitted by the RHS node that eventually pushes the value of the expression onto the stack.
		 */
		List<Instruction> a = new ArrayList<Instruction>();
		a.addAll(rhs.emit());
		a.add(new Machine.Store(ident));

		return a;
	}

	@Override
	public void execute(SymbolTable symTab) {
		// Evaluate the RHS expression and assign the result value to the variable.
		symTab.put(this.ident, rhs.evaluate(symTab));

	}
	 
	@Override
	public void infixDisplay() {
		// Show this assignment on standard output as a variable followed by an assignment arrow (":=") followed 
		//by the infix form of the RHS expression.
		System.out.print(ident + " := ");
		rhs.infixDisplay();
		System.out.print("\n");

	}

}
