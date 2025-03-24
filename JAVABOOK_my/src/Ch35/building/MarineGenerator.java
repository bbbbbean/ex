package Ch35.building;

import Ch35.unit.Marine;
import Ch35.unit.Unit;

public class MarineGenerator implements UnitGenerator{

	@Override
	public Unit gen() {
		return new Marine();
	}

}
