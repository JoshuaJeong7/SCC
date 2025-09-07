public class FirePokemon extends Pokemon {
	protected int burnDamage;
	protected int burnDuration; //This is just for generic burn duration
	
	public FirePokemon(String nameIn, double powerIn, int hpIn, int defenseIn) {
		super(nameIn, powerIn, hpIn, defenseIn);
		burnDamage = 5;
	}
	public void ember(Pokemon other) {
		//This is the sample for what ember() can do. Feel free to override this
		//method in subclasses!
		
		//Deals low initial damage to the other Pokemon, but has a chance
        //to inflict burn on them, dealing constant damage for a random
        //duration of time between 1-5 turns. 
		System.out.println(name + " used Ember!");
        other.getHit((int)(4 * power));
        
        //Randomly generated integer between 0 and 5
        burnDuration = (int)(Math.random() * 5); 
        
        System.out.println(name + " inflicted burn on " + other.name +
                            " for " + burnDuration + " turns!");
	}	
	public void fireBreath(Pokemon other) {
		//This is the sample for what fireBreath() can do. Feel free to override this
		//method in subclasses!
		
		//Deals a solid amount of damage upfront, with a low amount of burn damage
		//attached later for 2 turns.
		
	}
	
	public void updateTurn() {
		//Given the sample for ember() and fireBreath(), this is what your
		//updateTurn method should roughly look like.
		
	}
}
