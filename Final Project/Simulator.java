/**
* This class implements my simulator class. The simulation first reads from an input file containing all the travlers and TSA agents
* to be used in the simulation. From there it assigns each TSA agent to a line based on their age, and each travler to a line based on a 
* psuedo random hash function. From there, travlers with the highest initial danger level get moved to the front of their respective priority
* queues. Next, TSA agents screen their travlers buy comparing the travlers traits to their own likes and dislikes. The more likes that match, 
* the lower the travlers percieved danger level is and vice versa. From there the simulation will evaluate and return the various outcomes of 
* the simulation. 
* 
*  I pledge my honor that I have abided by the Stevens Honor System.
* 
*  @author Henry Thomas 
*/

import java.io.*;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Math;

public class Simulator{
	private int p, t, pPerLine; //the number of passengers, tsa agents, and the amount of passengers per line.
	private TSAagent[] tLines; //Array of TSA agents with respective lines
	private MyPriorityQueue[] pLines; //Array of priority queues containing passengers in each line
	
	public static void main(String[] args){
		/**
		* Main
		*/
		Simulator sim = new Simulator();
	}

	public Simulator(){
		/**
		* The main simulation method.
		*
		*/
			BufferedReader br = null;
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("--------------------------TSA-SEARCH-SIMULATOR-------------------------");
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("");
	 		System.out.println("Searching for input.dat...");
			try {
				br = new BufferedReader(new FileReader("input.dat"));
				String ln = null;
				ln = br.readLine().trim();

				//Check if the file isn't empty or if the data doesnt start on the first line
				while (ln != null && ln.equals(""))
					ln = br.readLine().trim();
				if (ln == null){
					System.out.println("Input.dat contains no data. :(");
					return;
				}
				String[] lnContent = ln.split("\\s+");
				t = Integer.parseInt(lnContent[0]); //sets capacity for the number of agents
				p = Integer.parseInt(lnContent[1]); //sets capacity for number of passengers
				pPerLine = (int) Math.ceil((double) p/t); //maximum of p/t passengers per line
				if((p > 0) && (t > 0)){
					//Show the number of agents and passengers
					System.out.print("Input.dat found!"); //This string contains the su
					System.out.println("");
					System.out.println("Number of Passengers: "+ p + " | Number of TSA Agents: " + t);
					System.out.println("Maximum number of passengers per line: " + pPerLine);
					System.out.println("");
					System.out.println("Starting TSA Agent Activety...");
					System.out.println("-----------------------------------------------------------------------");
					//Create new lines for passengers and assign positions for TSA agents
					tLines = new TSAagent[t];
					pLines = new MyPriorityQueue[t];
					String[] tInfo; // Contains name, lname, age, and paranoia for tsa agent (helpful for debugging)
					String[] pInfo; // Contains name, lname, age, gender, origin, species, danger level, and is threat for passengers. (helpful for debugging)
					int[] likes, dislikes; // Stores tsa agent likes and dislikes into their own arrays of integers
					
					//This loop will take data from the input file and attribute the likes, dislikes, and basic info
					for(int i = 0; i < t; i++){
						tInfo = br.readLine().split("\\s+"); //using space as delimiter
						likes = convertToIntArr(br.readLine().split("\\s+"));
						dislikes = convertToIntArr(br.readLine().split("\\s+"));
						tLines[i] = new TSAagent(tInfo[0], tInfo[1], Integer.parseInt(tInfo[2]), Integer.parseInt(tInfo[3]), likes, dislikes, Integer.parseInt(tInfo[4]));
						pLines[i] = new MyPriorityQueue(pPerLine);
					}

					MySorts.select(tLines, t); //Sorts the TSA agents into their lines by age
					//Show the lines the agents are stationed
					for(int l = 0; l < t; l++){
						tLines[l].getName();
						System.out.println(tLines[l].getName() + ", age " + tLines[l].getAge() +", went to line "+ (l + 1) + ".");
					}

					//Begin passenger portion of simulation
					System.out.println("");
					System.out.println("Starting Passenger Activety...");
					System.out.println("-----------------------------------------------------------------------");

					Passenger tmp;
					for(int j = 0; j < p; j++){
						pInfo = br.readLine().split("\\s+");
						tmp = new Passenger(pInfo[0], pInfo[1], Integer.parseInt(pInfo[2]), Integer.parseInt(pInfo[3]), Integer.parseInt(pInfo[4]), Integer.parseInt(pInfo[5]), Integer.parseInt(pInfo[6]), (Integer.parseInt(pInfo[7]) == 1));
						putInLine(tmp,(tmp.hashCode()%t), t);
						//System.out.println("");
					}

					System.out.println("");
					System.out.println("TSA Agents and Passengers are stationed as follows:");
					System.out.println("-----------------------------------------------------------------------");

					//Displays Each TSA agents line with the passengers in that line
					for(int l = 0; l < t; l++)
						System.out.println("\n" + tLines[l].getName() + " is stationed at line " + (l + 1) + " with these passengers: " + pLines[l].toString() + ".");
						System.out.println("");

					//Start screening passengers
					System.out.println("");
					System.out.println("Starting passenger screening...");
					System.out.println("-----------------------------------------------------------------------");

					Passenger nextPass;
					//cycle through all the passengers per line
					for(int m = 0; m < pPerLine; m++){
						//cycle through each line
						for(int q = 0; q < t; q++){
							nextPass = pLines[q].dequeue();
							if (nextPass == null) //the line is empty
								break;
							if (tLines[q].checkPassenger(nextPass)){ //Passenger is selected for a "random search"
								System.out.println(nextPass.getName() + " was selected for a random search by "+ tLines[q].getName() + ".");
								if (nextPass.getisThreat()){
									System.out.println("Threat detected, nice job " + tLines[q].getName() + "!");
									System.out.println("");
								}
								else{
									System.out.println("Not a threat, you suck " + tLines[q].getName() + "!");
									System.out.println("");
								}
							}
							else{ // Passenger is not selected for a random search
								System.out.println(nextPass.getName() + " was cleared to board by "+ tLines[q].getName() + ".");
								if (nextPass.getisThreat()){
									System.out.println("The plane blew up! "+ tLines[q].getName() + " missed a threat.");
									System.out.println("");
								}
								else{
									System.out.println("Passenger isn't a terrorist! Yay!");
									System.out.println("");
								}
							}
						}
					}
				}

				else{
					if (p == 0){
						System.out.println("No Passengers! There's nothing to do today! ☺");
						return;
					}
					else if (t == 0){
						System.out.println("No TSA agents! Sorry passengers! ☻");
						return;
					}
					else
						return;
				}

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null)br.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}

	private int[] convertToIntArr(String[] items){
		/**
		* Converts and array of strings to an array of ints.
		*
		*@param items, the array of strings to be converted
		*@return an array of integers
		*/
		int[] intArr = new int[items.length];
		for (int i = 0; i < items.length; i++) {
		    try {
		        intArr[i] = Integer.parseInt(items[i]);
		    } 
		    catch (NumberFormatException nfe) {};
		}
		return intArr;
	}

	private boolean putInLine(Passenger p, int desiredIndex, int maxIndex){
		/**
		* Places each passenger into a line.
		*
		*@param p, The current passenger
		*@param desiredIndex, The index in our hashtable which the passenger is being sent to
		*@param maxIndex, The maximum possible index 
		*@return boolean value indicating whether or not the passenger was successfully placed into a line.
		*/
		if(desiredIndex >= pLines.length || desiredIndex < 0)
			return false;
		if(pLines[desiredIndex].enqueue(p)){
			System.out.println(p.getName() + " went to line " + (desiredIndex + 1) + ".");
			return true;
		}
		return putInLine(p,((desiredIndex + 1) % maxIndex), maxIndex);
	}
}