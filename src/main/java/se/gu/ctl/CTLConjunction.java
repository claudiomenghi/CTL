package se.gu.ctl;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import se.gu.ctl.visitors.CTLVisitor;



public class CTLConjunction extends CTLStateFormula implements BinaryFormula<CTLStateFormula> {

	private final CTLStateFormula leftChild;
	private final CTLStateFormula rightChild;

	private final String operator = "AND";

	protected CTLConjunction(CTLStateFormula leftChild, CTLStateFormula rightChild) {

		super();
		Preconditions.checkNotNull(leftChild, "The first subformula cannot be null");
		Preconditions.checkNotNull(rightChild, "The second subformula cannot be null");
		this.leftChild = leftChild;
		this.rightChild = rightChild;

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
	public CTLStateFormula getLeftChild() {
		return this.leftChild;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CTLStateFormula getRightChild() {
		return this.rightChild;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((leftChild == null) ? 0 : leftChild.hashCode());
		result = prime * result + ((rightChild == null) ? 0 : rightChild.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CTLConjunction other = (CTLConjunction) obj;
		if (leftChild == null) {
			if (other.leftChild != null)
				return false;
		} else if (!leftChild.equals(other.leftChild))
			return false;
		if (rightChild == null) {
			if (other.rightChild != null)
				return false;
		} else if (!rightChild.equals(other.rightChild))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "(" + this.leftChild + ") " + operator + " (" + this.rightChild + ")";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CTLFormula> getChildren() {
		Set<CTLFormula> formulae=new HashSet<>();
		formulae.add(leftChild);
		formulae.add(rightChild);
		return formulae;
	}
}
