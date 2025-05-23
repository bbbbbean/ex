package Ch35.building;

import Ch35.unit.Unit;

public abstract class Building {
	public int hp;		// 체력
	public int sheld;	// 보호막
	public int amor;	// 보호장비
	public boolean isDestroyed;
	
	// 건물 짓기
	abstract void BuildStructure();
	// 공격 당함
	void UnderAttack(int damage) {
		// amor -> hp:0 -> dead
		if(sheld-damage>0) {
			sheld-=damage;
		}
		else if(amor-(damage-sheld)>0) {
			amor=amor-(damage-sheld);
			sheld=0;
		}else if(hp-(damage-amor)>0) {
			hp=hp-(damage-amor);
			sheld=0;
		}else {
			hp=0;
			amor=0;
			isDestroyed = false;
			System.out.println("건물이 붕괴되었습니다");
		}
	}
	
}
