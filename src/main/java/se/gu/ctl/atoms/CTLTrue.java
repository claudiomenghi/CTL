package se.gu.ctl.atoms;

import java.util.HashSet;
import java.util.Set;

import se.gu.ctl.CTLFormula;
import se.gu.ctl.CTLStateFormula;
import se.gu.ctl.visitors.CTLVisitor;

public class CTLTrue extends CTLAtom {

	private final String atomName;
	private final int hash;

	public CTLTrue() {
		this.atomName = new String("TRUE");
		this.hash = this.generateHash();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(CTLVisitor<T> visitor) {
		return visitor.visit(this);
	}

	private int generateHash() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atomName == null) ? 0 : atomName.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return hash;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CTLTrue other = (CTLTrue) obj;
		if (atomName == null) {
			if (other.atomName != null)
				return false;
		} else if (!atomName.equals(other.atomName))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return "("+this.atomName+")";
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<CTLFormula> getChildren() {
		Set<CTLFormula> formulae=new HashSet<>();
		return formulae;
	}
}
