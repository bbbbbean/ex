package Ch35.unit;

public class Medic extends Unit {

	private int healingPoint;
	
	public Medic() {
		hp=100;
		amor=100;
		healingPoint=30;
	}
	void setType(String type) {
		this.type = type;
	}
	public void Healling(Unit unit) {
		unit.hp+=healingPoint;
		System.out.println(unit.type+"을 회복시킵니다"+unit.type+"체력 : "+unit.hp);
	}
	
	@Override
	public void move() {
		
	}

	@Override
	public void UnderAttack(int damage) {
		
	}

}
