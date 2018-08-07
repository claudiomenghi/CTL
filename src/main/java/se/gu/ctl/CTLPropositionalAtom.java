package se.gu.ctl;

import java.util.HashSet;
import java.util.Set;

import se.gu.ctl.visitors.CTLVisitor;
import se.gu.ltl.LTLFormula;
import se.gu.ltl.atoms.PropositionalAtom;

public class CTLPropositionalAtom extends PropositionalAtom implements CTLStateFormula {

	public CTLPropositionalAtom(String atom) {
		super(atom);
	}



	@Override
	public Set<CTLFormula> getChildren() {
		Set<CTLFormula> formulae=new HashSet<>();
		return formulae;
	}



	@Override
	public <T> T accept(CTLVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
