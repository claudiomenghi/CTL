package se.gu.ctl.atoms;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import se.gu.ctl.CTLFormula;
import se.gu.ctl.CTLStateFormula;
import se.gu.ctl.visitors.CTLVisitor;

public class CTLPLAtom extends CTLAtom {


	private final String robotName;
	private final String locationName;

	public CTLPLAtom(String robotName, String locationName) {
		Preconditions.checkNotNull(robotName, "The name of the robot cannot be null");
		Preconditions.checkNotNull(locationName, "The name of the location cannot be null");

		this.robotName = robotName;
		this.locationName = locationName;
	}

	@Override
	public Set<CTLFormula> getChildren() {

		Set<CTLFormula> formulae = new HashSet<>();
		formulae.add(this);
		return formulae;
	}

	@Override
	public <T> T accept(CTLVisitor<T> visitor) {
		return visitor.visit(this);
	}

	/**
	 * @return the robotName
	 */
	public String getRobotName() {
		return robotName;
	}

	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return robotName  +" in " + locationName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((locationName == null) ? 0 : locationName.hashCode());
		result = prime * result + ((robotName == null) ? 0 : robotName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CTLPLAtom other = (CTLPLAtom) obj;
		if (locationName == null) {
			if (other.locationName != null)
				return false;
		} else if (!locationName.equals(other.locationName))
			return false;
		if (robotName == null) {
			if (other.robotName != null)
				return false;
		} else if (!robotName.equals(other.robotName))
			return false;
		return true;
	}
	
	
}
