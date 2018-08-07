package se.gu.ctl;

import java.util.Set;

import com.google.common.base.Preconditions;

import se.gu.ltl.Formula;
import se.gu.ltl.atoms.PropositionalAtom;

public interface CTLStateFormula extends CTLFormula {




	public static CTLStateFormula getAnd(CTLStateFormula f1, CTLStateFormula f2) {
		Preconditions.checkNotNull(f1, "The first subformula cannot be null");
		Preconditions.checkNotNull(f2, "The second subformula cannot be null");

		if (f1.equals(Formula.TRUE)) {
			return f2;
		}
		if (f2.equals(Formula.TRUE)) {
			return f1;
		}
		return new CTLConjunction(f1, f2);
	}

	public static CTLStateFormula getAnd(CTLStateFormula... formulae) {

		CTLStateFormula f = formulae[0];
		for (int i = 1; i < formulae.length; i++) {
			f = new CTLConjunction(f, formulae[i]);
		}
		return f;
	}

	public abstract Set<CTLFormula> getChildren();



	// Producers method to build CLTL formulae of the argument formula

	public static CTLStateFormula atom(String s) {
		return new CTLPropositionalAtom(s);
	}

	public static CTLStateFormula not(CTLStateFormula f) {
		if (f instanceof CTLNeg) {
			return ((CTLNeg) f).getChild();
		}

		return new CTLNeg(f);
	}

	// Producers method to build derived boolean CLTL formulae
	public static CTLStateFormula or(CTLStateFormula... formulae) {
		CTLStateFormula f = formulae[0];
		for (int i = 1; i < formulae.length; i++) {
			f = new CTLDisjunction(f, formulae[i]);
		}
		return f;
	}

	public static CTLStateFormula implies(CTLStateFormula f1, CTLStateFormula f2) {
		Preconditions.checkNotNull(f1, "The first subformula cannot be null");
		Preconditions.checkNotNull(f2, "The second subformula cannot be null");

		return new CTLImplies(f1, f2);
	}

	public static CTLStateFormula iff(CTLStateFormula f1, CTLStateFormula f2) {
		return new CTLIff(f1, f2);
	}

}
