package se.gu.ctl;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import se.gu.ctl.visitors.CTLVisitor;

public class CTLUntil extends CTLStateFormula implements BinaryFormula<CTLStateFormula> {

	private final CTLStateFormula subformula1;
	private final CTLStateFormula subformula2;
	
	private final String operator = "U";

	public CTLUntil(CTLStateFormula subformula1, CTLStateFormula subformula2) {
		super();
		Preconditions.checkNotNull(subformula1, "The first subformula cannot be null");
		Preconditions.checkNotNull(subformula2, "The second subformula cannot be null");
		this.subformula1 = subformula1;
		this.subformula2 = subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CTLStateFormula getLeftChild() {
		return this.subformula1;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CTLStateFormula getRightChild() {
		return this.subformula2;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(CTLVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "(" + this.subformula1 + ") " + operator + "( " + this.subformula2 + ")";
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CTLFormula> getChildren() {
		Set<CTLFormula> formulae=new HashSet<>();
		formulae.add(subformula1);
		formulae.add(subformula2);
		return formulae;
	}
}
