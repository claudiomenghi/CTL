package se.gu.ctl.atoms;

import java.util.HashSet;
import java.util.Set;

import se.gu.ctl.CTLFormula;
import se.gu.ctl.CTLStateFormula;
import se.gu.ctl.visitors.CTLVisitor;
import se.gu.ltl.LTLFormula;
import se.gu.ltl.atoms.PCAtom;
import se.gu.ltl.atoms.PLAtom;
import se.gu.ltl.visitors.LTLVisitor;

public class CTLPLAtom extends PLAtom implements CTLStateFormula {

	public CTLPLAtom(PLAtom atom) {
		super(atom.getRobotName(),atom.getLocationName());
	}
	public CTLPLAtom(String robotName, String locationName) {
		super(robotName, locationName);
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
