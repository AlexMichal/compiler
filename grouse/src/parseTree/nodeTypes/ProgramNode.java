package parseTree.nodeTypes;

import parseTree.ParseNode;
import parseTree.ParseNodeVisitor;
import tokens.Token;

public class ProgramNode extends ParseNode {

	public ProgramNode(Token token) {
		super(token);
	}
	public ProgramNode(ParseNode node) {
		super(node);
	}
	
	////////////////////////////////////////////////////////////
	// ATTRIBUTES
	////////////////////////////////////////////////////////////

	
	///////////////////////////////////////////////////////////
	// BOILERPLATE FOR VISITORS
	///////////////////////////////////////////////////////////
	
	public void accept(ParseNodeVisitor visitor) {
		visitor.visitEnter(this);
		visitChildren(visitor);
		visitor.visitLeave(this);
	}
}
