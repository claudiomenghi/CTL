package se.gu.ctl;

import java.util.Set;

public abstract class CTLPathFormula extends CTLFormula {


	public CTLPathFormula() {
		super();

	}

	
	public abstract Set<CTLFormula> getChildren();

}
