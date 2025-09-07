public class FirePokemon extends Pokemon {
	private int burnDamage;
	
	public FirePokemon(String nameIn, double powerIn, int hpIn, int defenseIn) {
		super(nameIn, powerIn, hpIn, defenseIn);
		burnDamage = 5;
	}
	public void ember() {
		//This is the sample for what ember() can do. Feel free to override this
		//method in subclasses!
	}	
	public void fireBreath() {
		//This is the sample for what fireBreath() can do. Feel free to override this
		//method in subclasses!
	}
}
