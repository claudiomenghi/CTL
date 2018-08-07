package se.gu.ctl;

import java.util.Set;

public interface CTLPathFormula extends CTLFormula {


	
	public abstract Set<CTLFormula> getChildren();

}
