package se.gu.ctl.visitors;

import se.gu.ctl.CTLConjunction;
import se.gu.ctl.CTLDisjunction;
import se.gu.ctl.CTLExists;
import se.gu.ctl.CTLEventually;
import se.gu.ctl.CTLForall;
import se.gu.ctl.CTLFormula;
import se.gu.ctl.CTLGlobally;
import se.gu.ctl.CTLIff;
import se.gu.ctl.CTLImplies;
import se.gu.ctl.CTLNeg;
import se.gu.ctl.CTLNext;
import se.gu.ctl.CTLUntil;
import se.gu.ctl.CTLWeakUntil;
import se.gu.ltl.atoms.PAAtom;
import se.gu.ltl.atoms.PCAtom;
import se.gu.ltl.atoms.PLAtom;
import se.gu.ltl.atoms.PropositionalAtom;
import se.gu.ltl.atoms.True;

public class CTL2NuSMV extends CTLFormulaToStringVisitor{
	
	
	@Override
	public String visit(CTLDisjunction formula) {
		return "( " + formula.getLeftChild().accept(this) + ") || (" + formula.getRightChild().accept(this) + " )";
	}

	@Override
	public String visit(True formula) {
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
		return "[ ( " + formula.getLeftChild().accept(this) + ") U (" + formula.getRightChild().accept(this) + " ) ]";
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
	public String visit(PropositionalAtom formula) {
		return formula.getAtomName();
	}

	@Override
	public String visit(CTLExists formula) {
		if(formula.getChild() instanceof CTLWeakUntil) {
			CTLWeakUntil weak=(CTLWeakUntil)formula.getChild();
			return new CTLNeg(
					new CTLForall(
							new CTLUntil(
									CTLFormula.getAnd(
											weak.getLeftChild(),
											new CTLNeg(weak.getRightChild())),
									CTLFormula.getAnd(
											new CTLNeg(weak.getLeftChild()),
											new CTLNeg(weak.getRightChild()))
									)
							)
					).accept(this);
		}
		return "E" + formula.getChild().accept(this) + "";
	}
	
	@Override
	public String visit(CTLForall formula) {
		if(formula.getChild() instanceof CTLWeakUntil) {
			CTLWeakUntil weak=(CTLWeakUntil)formula.getChild();
			return new CTLNeg(
					new CTLExists(
							new CTLUntil(
									CTLFormula.getAnd(
											weak.getLeftChild(),
											new CTLNeg(weak.getRightChild())),
									CTLFormula.getAnd(
											new CTLNeg(weak.getLeftChild()),
											new CTLNeg(weak.getRightChild()))
									)
							)
					).accept(this);
		}
		return "A" + formula.getChild().accept(this) + "";
	}



	@Override
	public String visit(CTLNext formula) {
		return "X (" + formula.getChild().accept(this) + ")";
	}

	@Override
	public String visit(CTLEventually formula) {
		return "F (" + formula.getChild().accept(this) + ")";
	}
	
	@Override
	public String visit(PLAtom ltlplAtom) {
		return "( state = " + ltlplAtom.getLocationName() + ")";
	}

	@Override
	public String visit(PCAtom ltlpeAtom) {
		return "("+ltlpeAtom.getCondition()+")";
		
	}

	@Override
	public String visit(PAAtom ltlpaAtom) {
		return "(" + ltlpaAtom.getActionName() + ")";
	}

	@Override
	public String visit(CTLGlobally ctlGlobally) {
		return "G (" + ctlGlobally.getChild().accept(this) + ")";
	}	
	
	@Override
	public String visit(CTLWeakUntil formula) {
		
		return null;

			
	}	


}
