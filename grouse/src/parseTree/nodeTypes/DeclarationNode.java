package parseTree.nodeTypes;

import parseTree.ParseNode;
import parseTree.ParseNodeVisitor;
import lexicalAnalyzer.Keyword;
import lexicalAnalyzer.Lextant;
import tokens.LextantToken;
import tokens.Token;

public class DeclarationNode extends ParseNode {
	public DeclarationNode(Token token) {
		super(token);
		assert(token.isLextant(Keyword.IMMUTABLE) || token.isLextant(Keyword.VARIABLE) || token.isLextant(Keyword.LET));
	}

	public DeclarationNode(ParseNode node) {
		super(node);
	}
	
	////////////////////////////////////////////////////////////
	// ATTRIBUTES
	////////////////////////////////////////////////////////////
	
	public Lextant getDeclarationType() {
		return lextantToken().getLextant();
	}
	
	public LextantToken lextantToken() {
		return (LextantToken)token;
	}	
	
	////////////////////////////////////////////////////////////
	// CONVENIENCE FACTORY
	////////////////////////////////////////////////////////////
	
	public static DeclarationNode withChildren(Token token, ParseNode declaredName, ParseNode initializer) {
		DeclarationNode node = new DeclarationNode(token);
		node.appendChild(declaredName);
		node.appendChild(initializer);
		return node;
	}
	
	public static DeclarationNode withChildren(Token token, ParseNode declaredName, ParseNode initializer, ParseNode staticNode) {
		DeclarationNode node = new DeclarationNode(token);
		node.appendChild(declaredName);
		node.appendChild(initializer);
		node.appendChild(staticNode);
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
