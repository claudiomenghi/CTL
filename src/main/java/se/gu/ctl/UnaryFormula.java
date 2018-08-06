package se.gu.ctl;

/**
 * Contains a unary formula
 * 
 * @author Claudio Menghi
 *
 * @param <T>
 *            the type of the sub-formulae
 */
@FunctionalInterface
public interface UnaryFormula<T extends CTLFormula> extends java.io.Serializable {

	/**
	 * returns the child of the formula
	 * 
	 * @return the child of the formula
	 */
	public T getChild();
}
