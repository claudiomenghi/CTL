package se.gu.ctl.visitors;

import se.gu.ctl.CTLConjunction;
import se.gu.ctl.CTLDisjunction;
import se.gu.ctl.CTLExists;
import se.gu.ctl.CTLIff;
import se.gu.ctl.CTLImplies;
import se.gu.ctl.CTLNeg;
import se.gu.ctl.CTLNext;
import se.gu.ctl.CTLUntil;
import se.gu.ctl.atoms.CTLPAAtom;
import se.gu.ctl.atoms.CTLPEAtom;
import se.gu.ctl.atoms.CTLPLAtom;
import se.gu.ctl.atoms.CTLPropositionalAtom;
import se.gu.ctl.atoms.CTLTrue;

public interface CTLVisitor<T> {

	public T visit(CTLDisjunction formula);

	public T visit(CTLTrue formula);

	public T visit(CTLConjunction formula);

	public T visit(CTLNeg formula);

	public T visit(CTLUntil formula);

	public T visit(CTLImplies formula);

	public T visit(CTLIff formula);


	public T visit(CTLPropositionalAtom formula);

	public T visit(CTLExists mitliEventually);

	public T visit(CTLNext ltlNext);

	public T visit(CTLPLAtom ltlplAtom);

	public T visit(CTLPEAtom ltlpeAtom);

	public T visit(CTLPAAtom ltlpaAtom);


}
