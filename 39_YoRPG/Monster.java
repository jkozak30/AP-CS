public class Monster {
	private boolean isAlive = true;
	public int health = 100;
	private int attack = 10;
	
	public boolean isAlive() {
		if (health > 0) {
			isAlive = true;
		} else {
			isAlive = false;
		}
		return isAlive;
	}
	
	public int attack (Protagonist p) {
		p.health -= attack;
		return attack;
	}
}
