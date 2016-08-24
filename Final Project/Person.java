/**
* This class contains all the methods and variables necessairy for creating a general person. 
* It contains data such such as the full name, age, and gender pertaining to each person.
* 
*  I pledge my honor that I have abided by the Stevens Honor System.
* 
*  @author Henry Thomas 
*/

public class Person{ //                        0         1             2              3              4        5       6              7               8                  9                10              11                  12             13           14             15              16        17      18          19            20             21                   22                      23       24         25        26          27 
	public static final String [] traits = {"Female", "Male", "Transgendered", "Hermaphrodite", "Epicene", "USA", "Canada", "Central America", "South America", "Western Europe", "Eastern Europe", "Middle Eastern", "North African", "African", "South Asian", "South East Asian", "Asian", "Aussie", "Kiwi", "Polynesian", "Outer Space", "Antarctican", "Lowest levels of the deep sea", "human", "alien", "ancients", "monster", "mutants"};
	private String name, lname;
	private int age, gender;

	protected Person(String n, String l, int a, int g){
	/**
	* Person constructor.
	*/
		if (a < 0)
			a = 0;
		if (n == null)
			n = "Undefined";
		if (l == null)
			l = "Undefined";
		if (g > 4 || g < 0)
			g = 0;
		name = n;
		lname = l;
		age = a;
		gender = g;
	}

	public String getName(){
	/**
	* Gives the full name of the person.
	*
	*@return Returns first name + space + last name.
	*/
		return name + " " + lname;
	}
	
	public int getAge(){
	/**
	* Gives the age of the person.
	*
	*@return Returns the age so long as it's greater than or equal to 0.
	*/
		return age;
	}

	public int getGender(){
	/**
	* Gives the gender of the person.
	*
	*@return Returns the gender of the person so long as it's withing the range of acceptable genders in our traits array.
	*/
		return gender;
	}

	public String getTrait(int index){
		/**
		* Retrieves a specific trait from our array of traits.
		*
		*@param index, the index in the traits array
		*@return the string located at the given index.
		*/
		if ((index >= 0) && (index < traits.length))
			return traits[index];
		else
			return "Not a valid trait.";
	}

	public String toString(){
	/**
	* Converts the information of the person into a sentence.
	*
	*@return Returns first and last name + age + gender of person.
	*/
		return this.getName() + " a "+ this.getAge() + " year old " + getTrait(this.getGender());
	}

	public void printInfo(){
	/**
	* Prints toString.
	*
	*/
		System.out.println(this.toString());
	}
}
