package se.gu.ctl.visitors;

import se.gu.ctl.CTLConjunction;
import se.gu.ctl.CTLDisjunction;
import se.gu.ctl.CTLExists;
import se.gu.ctl.CTLIff;
import se.gu.ctl.CTLImplies;
import se.gu.ctl.CTLNeg;
import se.gu.ctl.CTLNext;
import se.gu.ctl.CTLUntil;
import se.gu.ctl.atoms.CTLPAAtom;
import se.gu.ctl.atoms.CTLPEAtom;
import se.gu.ctl.atoms.CTLPLAtom;
import se.gu.ctl.atoms.CTLPropositionalAtom;
import se.gu.ctl.atoms.CTLTrue;

public class CTL2NuSMV extends CTLFormulaToStringVisitor{
	
	
	@Override
	public String visit(CTLDisjunction formula) {
		return "( " + formula.getLeftChild().accept(this) + ") || (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(CTLTrue formula) {
		return "TRUE";
	}

	@Override
	public String visit(CTLConjunction formula) {
		return "( " + formula.getLeftChild().accept(this) + ") & (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(CTLNeg formula) {
		return " ! (" + formula.getChild().accept(this) + ")";
	}

	@Override
	public String visit(CTLUntil formula) {
		return "( " + formula.getLeftChild().accept(this) + ") U (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(CTLImplies formula) {
		return "( " + formula.getLeftChild().accept(this) + ") -> (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(CTLIff formula) {
		return "( " + formula.getLeftChild().accept(this) + ") <-> (" + formula.getRightChild().accept(this) + " )";
	}


	@Override
	public String visit(CTLPropositionalAtom formula) {
		return formula.getAtomName();
	}

	@Override
	public String visit(CTLExists mitliEventually) {
		return " E (" + mitliEventually.getChild().accept(this) + ")";
	}


	@Override
	public String visit(CTLNext ltlNext) {
		return " X (" + ltlNext.getChild().accept(this) + ")";
	}

	@Override
	public String visit(CTLPLAtom ltlplAtom) {
		return "(" + ltlplAtom.getLocationName() + ")";
	}

	@Override
	public String visit(CTLPEAtom ltlpeAtom) {
		return "("+ltlpeAtom.getCondition()+")";
		
	}

	@Override
	public String visit(CTLPAAtom ltlpaAtom) {
		return "(" + ltlpaAtom.getActionName() + ")";
	}

	



}
