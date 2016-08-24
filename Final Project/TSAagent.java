/**
* This class implements all of the qualities possessed by my TSA agents. It extends person because TSA agents are people too. 
* TSA agents have a list of likes and dislikes, and a paranoia level that changes based on the current passenger they are observing.
* 
*  I pledge my honor that I have abided by the Stevens Honor System.
* 
*  @author Henry Thomas 
*/

import java.util.Arrays;

public class TSAagent extends Person implements Comparable<TSAagent>{
	private int[] likes, dislikes;
	private int paranoia;

	public TSAagent(String n, String l,int a, int g, int[] li, int[] d, int p){
		/**
		* Constructor for our TSA agents.
		*
		*@param n, The agents first name
		*@param l, The agents last name
		*@param a, The agents age
		*@param g, The agents gender
		*@param li, The array of agents likes
		*@param d, The array of agents dislikes
		*@param p, The agents paranoia level
		*/
		super(n, l, a, g);
		
		if (p < 0 || p > 10)
			p = 0;
		likes = li;
		dislikes = d;
		paranoia = p;
	}

	public int[] getLikes(){
		/**
		* Returns an array of integers pertaining to the traits an agent likes.
		*@return An array of integers.
		*/
		return likes;
	}

	public int[] getDislikes(){
		/**
		* Returns an array of integers pertaining to the traits an agent dislikes.
		*@return An array of integers.
		*/
		return dislikes;
	}

	public int getParanoia(){
		/**
		* Returns the paranoia level of the agent.
		*@return A value between 0-10 indicating paranoia.
		*/
		return paranoia;
	}

	public boolean checkLikes(int like, int[] likes){
		/**
		* Checks if a trait is contained within the likes array.
		*
		*@param like, the individual trait being checked for
		*@param likes, the array of likes
		*@return true or false depending on whether or not the trait was found within the array.
		*/
		for(int i = 0; i < likes.length; i++)
			if (like == likes[i])
				return true;
		return false;
	}

	public boolean checkDislikes(int dislike, int[] dislikes){
		/**
		* Checks if a trait is contained within the dislikes array.
		*
		*@param dislike, the individual trait being checked for
		*@param dislikes, the array of likes
		*@return true or false depending on whether or not the trait was found within the array.
		*/
		for(int i = 0; i < dislikes.length; i++)
			if (dislike == dislikes[i])
				return true;
		return false;
	}

	public boolean checkPassenger(Passenger p){
		/**
		* Returns an array of integers pertaining to the traits array.
		*@param p, The current passenger being checked.
		*@return a boolean value. True = threat, false = not threat.
		*/
		if(p == null)
			return false;
		int dLevel = p.getDangerLevel();
		if (checkLikes(p.getOrigin(), likes) && p.getOrigin() != -1)
			dLevel -= 2;
		if (checkLikes(p.getSpecies(), likes) && p.getSpecies() != -1)
			dLevel -= 2;
		if (checkLikes(p.getGender(), likes) && p.getGender() != -1)
			dLevel -= 2;
		if (checkDislikes(p.getOrigin(), dislikes) && p.getOrigin() != -1)
			dLevel += 2;
		if (checkDislikes(p.getSpecies(), dislikes) && p.getSpecies() != -1)
			dLevel += 2;
		if (checkDislikes(p.getGender(), dislikes) && p.getGender() != -1)
			dLevel += 2;
		return (dLevel >= (10 - this.getParanoia()));

	}

	public int compareTo(TSAagent compareableAgent) {
		/**
		* Compares the ages of TSA agents so they can be sorted by descending order.
		*
		*@param compareableAgent, the agent to be compared
		*@return Difference between the ages of our two TSA agents
		*/
		return ((TSAagent) compareableAgent).getAge() - this.getAge();
	}	
}