package perp.tree.stu;

import perp.Errors;
import perp.SymbolTable;
import perp.machine.stu.Machine;
import perp.tree.ActionNode;
import perp.tree.ExpressionNode;

import java.util.List;

/**
 * Operations that are done on a Perp code parse tree.
 *
 * THIS CLASS IS UNIMPLEMENTED. All methods are stubbed out.
 *
 * @author YOUR NAME HERE
 */
public class ParseTree {

    /**
     * Parse the entire list of program tokens. The program is a
     * sequence of actions (statements), each of which modifies something
     * in the program's set of variables. The resulting parse tree is
     * stored internally.
     * @param program the token list (Strings)
     */
    public ParseTree( List< String > program ) {
    }

    /**
     * Parse the next action (statement) in the list.
     * (This method is not required, just suggested.)
     * @param program the list of tokens
     * @return a parse tree for the action
     */
    private ActionNode parseAction( List< String > program ) {
        return null;
    }

    /**
     * Parse the next expression in the list.
     * (This method is not required, just suggested.)
     * @param program the list of tokens
     * @return a parse tree for this expression
     */
    private ExpressionNode parseExpr( List< String > program ) {
        return null;
    }

    /**
     * Print the program the tree represents in a more typical
     * infix style, and with one statement per line.
     * @see perp.tree.ActionNode#infixDisplay()
     */
    public void displayProgram() {
    }

    /**
     * Run the program represented by the tree directly
     * @see perp.tree.ActionNode#execute(perp.SymbolTable)
     */
    public void interpret() {
    }

    /**
     * Build the list of machine instructions for
     * the program represented by the tree.
     * @return the Machine.Instruction list
     * @see perp.machine.stu.Machine.Instruction#execute()
     */
    public List< Machine.Instruction > compile() {
        return null;
    }

}
