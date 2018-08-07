package se.gu.ctl;

import java.io.Serializable;

import com.google.common.base.Preconditions;

import se.gu.ctl.visitors.CTLVisitor;
import se.gu.ltl.Formula;

/**
 * Contains a generic formula
 * 
 * @author Claudio Menghi
 */
public interface CTLFormula extends Serializable, Formula {

	public static final CTLStateFormula TRUE = new CTLTrue();

	public static CTLStateFormula getAnd(CTLStateFormula f1, CTLStateFormula f2) {
		Preconditions.checkNotNull(f1, "The first subformula cannot be null");
		Preconditions.checkNotNull(f2, "The second subformula cannot be null");

		if (f1.equals(CTLFormula.TRUE)) {
			return f2;
		}
		if (f2.equals(CTLFormula.TRUE)) {
			return f1;
		}
		return new CTLConjunction(f1, f2);
	}

	public static CTLStateFormula getAnd(CTLStateFormula... formulae) {

		CTLStateFormula f = formulae[0];
		for (int i = 1; i < formulae.length; i++) {
			if (!formulae[i].equals(CTLFormula.TRUE)) {
				f = new CTLConjunction(f, formulae[i]);
			}
		}
		return f;
	}

	public abstract <T> T accept(CTLVisitor<T> visitor);
}
