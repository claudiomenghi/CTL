package se.gu.ctl;

import java.util.HashSet;
import java.util.Set;

import se.gu.ctl.visitors.CTLVisitor;
import se.gu.ltl.LTLFormula;
import se.gu.ltl.atoms.True;

public class CTLTrue extends True implements CTLStateFormula{

	@Override
	public <T> T accept(CTLVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Set<CTLFormula> getChildren() {
		Set<CTLFormula> formulae=new HashSet<>();
		return formulae;
	}

}
