public class TrainCar {
	
	
	public TrainCar next; ///It is bad coding practice to make any field
	///variable public, but for the sake of simplicity (and readability)
	///this code will use all public field variables. PLEASE DON'T ABUSE THIS!
	
	public int zombies;
	public int humans;
	public int dead;
	public int immune;
	
	public int zombiePower;
	public boolean accessible; //Whether or not we are allowed to access this car
	
	//Constructors
	
	//Most general constructor (no args)
	public TrainCar() {
		this(1, 199);
	}
	
	//Alternate constructor with only starting zombie and human count
	public TrainCar(int zombiesIn, int humansIn) {
		this(zombiesIn, humansIn, 1);
	}
	
	//Alternate constructor 2 with starting zombie and human count,
	//as well as starting zombie power and starting vaccine power
	public TrainCar(int zombiesIn, int humansIn, int zpIn) {
		
		zombies = zombiesIn;
		humans = humansIn;
		dead = 0;
		immune = 0;
		
		zombiePower = zpIn;
		
		next = null;
		accessible = true;
	}
	
	/*
	 
	//Getter methods
	public int getZombies() {
		return zombies;
	}
	public int getHumans() {
		return humans;
	}
	public int getDead() {
		return dead;
	}
	public int getImmune() {
		return immune;
	}
	public int getZombiePower() {
		return zombiePower;
	}
	public int getVaccinePower() {
		return vaccinePower;
	}
	
	//Setter methods
	public void setZombies(int zombiesIn) {
		zombies = zombiesIn;
	}
	public void setHumans(int humansIn) {
		humans = humansIn;
	}
	public void setDead(int deadIn) {
		dead = deadIn;
	}
	public void setImmune(int immuneIn) {
		immune = immuneIn;
	}
	public void setZombiePower(int zpIn) {
		zombiePower = zpIn;
	}
	public void setVaccinePower(int vpIn) {
		vaccinePower = vpIn;
	}
	
	*/
}
