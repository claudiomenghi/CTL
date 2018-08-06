package se.gu.ctl;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import se.gu.ctl.visitors.CTLVisitor;

public class CTLExists extends CTLPathFormula implements UnaryFormula<CTLFormula> {

	private final CTLPathFormula subformula;

	public CTLExists(CTLPathFormula subformula) {
		super();
		Preconditions.checkNotNull(subformula, "The subFormula cannot be null");
		this.subformula = subformula;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "E (" + this.getChild() + ")";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public CTLPathFormula getChild() {
		return this.subformula;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CTLFormula> getChildren() {
		Set<CTLFormula> formulae = new HashSet<>();
		formulae.add(subformula);
		return formulae;
	}

	@Override
	public <T> T accept(CTLVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
