package perp.tree.stu;

import perp.Errors;
import perp.SymbolTable;
import perp.machine.stu.Machine;
import perp.tree.ActionNode;
import perp.tree.ExpressionNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Operations that are done on a Perp code parse tree.
 *
 * THIS CLASS IS UNIMPLEMENTED. All methods are stubbed out.
 *
 * @author YOUR NAME HERE
 */
public class ParseTree {
	
	private ActionSequence tree; 
	public SymbolTable symTab = new SymbolTable();

    /**
     * Parse the entire list of program tokens. The program is a
     * sequence of actions (statements), each of which modifies something
     * in the program's set of variables. The resulting parse tree is
     * stored internally.
     * @param program the token list (Strings)
     */
    public ParseTree( List< String > program ) {
    	tree = new ActionSequence();
    	while (!program.isEmpty()){
    		tree.addAction(parseAction(program));
    		
    	}
    }

    /**
     * Parse the next action (statement) in the list.
     * (This method is not required, just suggested.)
     * @param program the list of tokens
     * @return a parse tree for the action
     */

    @SuppressWarnings("unused")
	private ActionNode parseAction( List< String > program ) {
    	String a = program.remove(0);
    	ActionNode e = null;
      	if (a.equals(":=")){
       		e = new Assignment(program.remove(0), parseExpr(program)); 
       	}
        else if (a.equals("@")){
       		e = new Print(parseExpr(program));
        	}
		return e;
    }

    /**
     * Parse the next expression in the list.
     * (This method is not required, just suggested.)
     * @param program the list of tokens
     * @return a parse tree for this expression
     */
    private ExpressionNode parseExpr( List< String > program ) {
    	ExpressionNode w = null;
    	String b = program.remove(0);
    	
    	if (b.equals("+") || b.equals("//") || b.equals("*") || b.equals("-")){
    		w = new BinaryOperation(b, parseExpr(program), parseExpr(program));
        }
        else if(b.equals("#") || b.equals("_")){
        	w = new UnaryOperation(b, parseExpr(program));
        		}
        else if(b.matches( "^[a-zA-Z].*" )){
        	w = new Variable(b);
        }
        else {
        	w= new Constant(Integer.parseInt(b));
        }
    	return w;     		
        }
		

    /**
     * Print the program the tree represents in a more typical
     * infix style, and with one statement per line.
     * @see perp.tree.ActionNode#infixDisplay()
     */
    public void displayProgram() {
    	System.out.println("The program, with expressions in infix notation: ");
    	tree.infixDisplay();
    	
    }

    /**
     * Run the program represented by the tree directly
     * @see perp.tree.ActionNode#execute(perp.SymbolTable)
     */
    public void interpret() {
    	System.out.println("\nInterpreting the parse tree ");
    	tree.execute(symTab);
    	System.out.println("Interpretation Complete. ");
    }

    /**
     * Build the list of machine instructions for
     * the program represented by the tree.
     * @return the Machine.Instruction list
     * @see perp.machine.stu.Machine.Instruction#execute()
     */
    public List< Machine.Instruction > compile() {
        List<Machine.Instruction> t = new ArrayList<Machine.Instruction>();
        t.addAll(tree.emit());
        return t;
    }

}
