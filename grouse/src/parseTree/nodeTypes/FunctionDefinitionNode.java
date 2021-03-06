package parseTree.nodeTypes;

import parseTree.ParseNode;
import parseTree.ParseNodeVisitor;
import tokens.Token;
import utilities.Debug;

public class FunctionDefinitionNode extends ParseNode {
	Debug debug = new Debug();
	
	public FunctionDefinitionNode(Token token) {
		super(token);
		
		debug.out("In FunctionDefnNode: " + token);
	}
	
	public FunctionDefinitionNode(ParseNode node) {
		super(node);
	}
	
	////////////////////////////////////////////////////////////
	// ATTRIBUTES
	////////////////////////////////////////////////////////////
	
	////////////////////////////////////////////////////////////
	// CONVENIENCE FACTORY
	////////////////////////////////////////////////////////////
	
	public static FunctionDefinitionNode withChildren(
			Token token, 
			ParseNode declaredName, 
			ParseNode parameterList, 
			ParseNode parameterTuple,
			ParseNode block) {
		FunctionDefinitionNode node = new FunctionDefinitionNode(token);
		
		node.appendChild(declaredName);
		node.appendChild(parameterList);
		node.appendChild(parameterTuple);
		node.appendChild(block);
		
		return node;
	}
	
	///////////////////////////////////////////////////////////
	// BOILERPLATE FOR VISITORS
	///////////////////////////////////////////////////////////
	
	public void accept(ParseNodeVisitor visitor) {
		visitor.visitEnter(this);
		visitChildren(visitor);
		visitor.visitLeave(this);
	}
}
