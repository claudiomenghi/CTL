package se.gu.ctl.atoms;

import java.util.HashSet;
import java.util.Set;

import se.gu.ctl.CTLFormula;
import se.gu.ctl.CTLStateFormula;
import se.gu.ctl.visitors.CTLVisitor;
import se.gu.ltl.atoms.PAAtom;

public class CTLPAAtom extends PAAtom implements CTLStateFormula {

	public CTLPAAtom(PAAtom atom) {
		super(atom.getRobotName(), atom.getActionName());

	}

	public CTLPAAtom(String robotName, String actionName) {
		super(robotName, actionName);
	}

	@Override
	public Set<CTLFormula> getChildren() {

		Set<CTLFormula> formulae = new HashSet<>();
		formulae.add(this);
		return formulae;
	}

	@Override
	public <T> T accept(CTLVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
