package perp.tree.stu;

import java.util.ArrayList;
import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine;
import perp.machine.stu.Machine.Instruction;
import perp.tree.ActionNode;

// An ActionNode used to string actions together into a sequence. An ActionSequence contains an ordered sequence of ActionNodes.

public class ActionSequence
extends Object
implements ActionNode {
	
	ArrayList<ActionNode> ActionSequence = new ArrayList<ActionNode>();
	public ActionSequence() {
		// Initialize this instance as an empty sequence of ActionNode children.
	}
	
	public void addAction(ActionNode newNode){
		//Add a child of this ActionSequence node.
		ActionSequence.add(newNode);
	}
	@Override
	public void infixDisplay() {
		// Show the infix displays of all children on standard output.
		for (ActionNode E:  ActionSequence){
			E.infixDisplay();			
		}
	}

	@Override
	public List<Instruction> emit() {
		// Create a list of instructions emitted by each child, from the first-added child to the last-added.
		List<Machine.Instruction> f = new ArrayList<Machine.Instruction>();
		for (ActionNode x: ActionSequence){
			f.addAll(x.emit());
		}
		return f;
	}

	@Override
	public void execute(SymbolTable symTab) {
		//Execute each ActionNode in this object, from first-added to last-added.
		for (ActionNode E:  ActionSequence){
			E.execute(symTab);
		}
		
	}

}
