package se.gu.ctl;

import java.io.Serializable;

import se.gu.ctl.visitors.CTLVisitor;

/**
 * Contains a generic formula
 * 
 * @author Claudio Menghi
 */
public abstract class CTLFormula implements Serializable{

	public abstract <T> T accept(CTLVisitor<T> visitor);
}
