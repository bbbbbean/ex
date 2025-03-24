package Ch35.unit;

public abstract class Unit {
	int hp;
	int amor;
	public String type;
	
	public abstract void move();
	public abstract void UnderAttack(int damage);
	
}

