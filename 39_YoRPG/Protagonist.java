public class Protagonist {
	private String name;
	private boolean isAlive = true;
	public int health = 100;
	private int attack = 7;
	
	public Protagonist (String name ) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isAlive() {
		if (health > 0) {
			isAlive = true;
		} else {
			isAlive = false;
		}
		return isAlive;
	}
	
	public void normalize() {
		attack = 7;
	}
	
	public void specialize() {
		attack = 15;
	}
	
	public int attack(Monster m) {
		m.health -= attack;
		return attack;
	}
}
