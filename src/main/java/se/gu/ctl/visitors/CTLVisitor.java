package se.gu.ctl.visitors;

import se.gu.ctl.CTLConjunction;
import se.gu.ctl.CTLDisjunction;
import se.gu.ctl.CTLExists;
import se.gu.ctl.CTLEventually;
import se.gu.ctl.CTLForall;
import se.gu.ctl.CTLGlobally;
import se.gu.ctl.CTLIff;
import se.gu.ctl.CTLImplies;
import se.gu.ctl.CTLNeg;
import se.gu.ctl.CTLNext;
import se.gu.ctl.CTLUntil;
import se.gu.ctl.CTLWeakUntil;
import se.gu.ltl.atoms.PAAtom;
import se.gu.ltl.atoms.PCAtom;
import se.gu.ltl.atoms.PLAtom;
import se.gu.ltl.atoms.PropositionalAtom;
import se.gu.ltl.atoms.True;

public interface CTLVisitor<T> {

	public T visit(CTLDisjunction formula);

	public T visit(True formula);

	public T visit(CTLConjunction formula);

	public T visit(CTLNeg formula);

	public T visit(CTLUntil formula);

	public T visit(CTLImplies formula);

	public T visit(CTLIff formula);


	public T visit(PropositionalAtom formula);

	public T visit(CTLExists mitliEventually);

	public T visit(CTLNext ltlNext);

	public T visit(PLAtom ltlplAtom);

	public T visit(PCAtom ltlpeAtom);

	public T visit(PAAtom ltlpaAtom);

	public T visit(CTLEventually ctlFinally);

	public T visit(CTLForall ctlForall);

	public T visit(CTLGlobally ctlGlobally);

	public T visit(CTLWeakUntil ctlWeakUntil);


}
