package Ch35.gun;

import Ch35.unit.Unit;

public abstract class Gun {
	public int maxBullitCnt;
	public int curBullitCnt;	// 현재 총알 수
	public int power;
	
	public abstract void fire(Unit unit);
	public abstract void reload(int bullit);
}
