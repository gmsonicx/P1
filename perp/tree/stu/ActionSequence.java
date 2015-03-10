package perp.tree.stu;

import java.util.ArrayList;
import java.util.List;

import perp.SymbolTable;
import perp.machine.stu.Machine;
import perp.machine.stu.Machine.Instruction;
import perp.tree.ActionNode;

public class ActionSequence
extends Object
implements ActionNode {
	
	ArrayList<ActionNode> ActionSequence = new ArrayList<ActionNode>();
	public ActionSequence() {
		// TODO Auto-generated constructor stub
	}
	
	public void addAction(ActionNode newNode){
		ActionSequence.add(newNode);
	}
	@Override
	public void infixDisplay() {
		// TODO Auto-generated method stub
		for (ActionNode E:  ActionSequence){
			E.infixDisplay();			
		}
	}

	@Override
	public List<Instruction> emit() {
		// TODO Auto-generated method stub
		List<Machine.Instruction> f = new ArrayList<Machine.Instruction>();
		for (ActionNode x: ActionSequence){
			f.addAll(x.emit());
		}
		return f;
	}

	@Override
	public void execute(SymbolTable symTab) {
		for (ActionNode E:  ActionSequence){
			E.execute(symTab);
		}
		
	}

}
