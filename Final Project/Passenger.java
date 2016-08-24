/**
* This class implements all the qualities for a Passenger. Passengers have an origin, species, and danger level as well as all the traits
* possessed by a person. 
* 
*  I pledge my honor that I have abided by the Stevens Honor System.
* 
*  @author Henry Thomas 
*/

public class Passenger extends Person implements Comparable<Passenger>{
	private int origin, species, dangerLevel;
	private boolean isThreat;

	public Passenger(String n, String l,int a, int g, int o,int s, int dL, boolean iT){
	/**
	* The Passenger constructor.
	*/
		super(n,l,a,g);
		if (o < 5 || o > 22)
			o = 5;
		if (s < 23 || s > 27)
			s = 23;
		if (dL < 0 || dL > 10)
			dL = 0;
		origin = o;
		species = s;
		dangerLevel = dL;
		isThreat = iT;
	}

	public int getOrigin(){
	/**
	* Used for returning the Origin
	* 
	*@return Returns an index within the traits array indicating an origin.
	*/
		return origin;
	}

	public int getSpecies(){
	/**
	* Used for returning the species.
	*
	*@return Returns an index within the traits array indicating a species.
	*/
		return species;
	}

	public boolean getisThreat(){
	/**
	* Indicates whether a Passenger is a threat or not.
	*
	*@return Returns a boolean. True = Threat, False = Not Threat.
	*/
		return isThreat;
	}

	public int getDangerLevel(){
	/**
	* Used for returning the danger level.
	*
	*@return Returns a value between 0-10 indicating the level of danger.
	*/	
		return dangerLevel;
	}

	public int hashCode(){
	/**
	* Computes the value to be modded by the number of TSA agents. Helps to determine the line each Passenger will go to.
	*
	*@return Returns the number to be modded by the number of TSA agents.
	*/
		return (this.getAge() - this.getGender() + this.getOrigin() + this.getSpecies());
	}

	public String printName(){
	/**
	* Provides a string containing the origin species danger level and threat value for a Passenger.
	*
	*@return Returns the Passenger information as a string.
	*/
		return this.getName();
	}

	public void printInfo(){
	/**
	* Provides a string containing the origin species danger level and threat value for a Passenger.
	*
	*@return Returns the Passenger information as a string.
	*/
		System.out.println(this.toString());
	}

	public String toString(){
	/**
	* Provides a string containing the origin species danger level and threat value for a Passenger.
	*
	*@return Returns the Passenger information as a string.
	*/
		String result = "\n" + super.toString() + " from " + getTrait(this.getOrigin()) + ", of the species " + getTrait(this.getSpecies()) + ", with danger level " + this.getDangerLevel() + ", ";
		if (this.getisThreat()){
			result += "is a threat, and";
		}
		else{
			result +="is not a threat, and";
		}
		result += " has a hash code of " + this.hashCode();
		return result;
	}

	public int compareTo(Passenger comparePass) {
	/**
	* Provides a string containing the origin species danger level and threat value for a Passenger.
	*
	*@return Returns the Passenger information as a string.
	*/
		return this.getDangerLevel() - ((Passenger) comparePass).getDangerLevel();
	}	
}