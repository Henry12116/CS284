# TSA Search Simulator


## To Run the Simulator
Clone or download the CS284 repository and change your working directory to 'Final Project'
(I have already provided you with a sample input.dat file which you can use)

### Compile Everything
```sh
$ javac *.java
```
### Run Simulator
```sh
$ java Simulator
```

## Synopsis

Everyone that has taken a flight has had to stand in line and wait to go through a TSA security checkpoint. With the increased number of terrorist threats in airports, they have had to increase their security measures, which now also include "random" searches. You are running a simulation at an airport where all of your employees are bad people with prejudices towards certain groups of people. As such, they will tend to "randomly" pick passengers they dislike for searches, while letting the ones they like go through (unless there's a clear problem with that passenger). Your simulation will take a group of passengers that will be assigned to different lines. From these lines, the TSA agents will pick out passengers starting with whoever seems to be more dangerous. Your goal is to display what will happen in each line.
Input

When your program start, you will have to load an input file called input.dat containing all of the data to use for your simulation. The file will be formatted as follows:

T P
T*3 lines
P lines

Where P is the number of passengers you will have and T is the number of TSA agents. Note that there will be as many lines as TSA agents.

Each TSA agent line will be formatted as follows

Name LastName age gender paranoia
Like1 like2 like3 ...
dislike1 dislike2 dislike3...

Every passenger line will be formatted as follows

Name LastName age gender origin species dangerLevel isThreat

The danger level will be a number from 0 to 10 where 0 is Mother Theresa and 10 is The Great Cthulhu

isThreat will be 1 for true, 0 for false

Gender origin ethnicity and species will be taken from the following array (this array may be different on the final project, I'll be posting the final version if there are any changes to it. Either way, your program should work regardless of what the traits are):

public static final String [] traits = {"Female", "Male", "Transgendered", "Hermaphrodite", "Epicene", "USA", "Canada", "Central America", "South America", "Western Europe", "Eastern Europe", "Middle Eastern", "North African", "African", "South Asian", "South East Asian", "Asian", "Aussie", "Kiwi", "Polynesian", "Outer Space", "Antarctican", "Lowest levels of the deep sea", "human", "alien", "ancients", "monster", "mutants"};

For example your input file could be as follows

1 2
Officer Barbrady 39 1 4
4 22 25
0 5 23
Great Cthulhu 5253993 4 22 25 10 1
Maggie Simpson 3 0 5 23 0 0

This would have one TSA agent in the Male Officer Barbrady, 39 year old, paranoia level 4. Likes epicene ancients from the lowest levels of the deep sea. Dislikes US citizens, females and humans.
Then 2 passengers, the Great Cthulhu, over 5 million years old, very dangerous epicene ancient from the lowest levels of the deep sea who is most definitely a threat, and Maggie Simpson, USA 3 year old female human, completely harmless.
Simulation

The first thing your simulation should do is sort all of the TSA agents from oldest to youngest. Older agents get seniority and prefer walking the least, so they get the first available checkpoint. Lines have to be fairly even, so if there are t TSA agents and p passengers, there should be a maximum of p/t passengers in each line (rounded up)

To pseudo-randomize where each passenger goes, you will use the following formula:

index = (age - gender + origin + species) % t  (where t is the number of lines, or TSA agents)

In the previous example, there was only 1 agent, so both passengers would end up at line 0.

If a line is "full", passengers will go to the next available line.

Each line will be a priority queue based on the passengers perceived danger level. Passengers with higher danger level will be called forward by the TSA agents for inspection. Upon inspection, the TSA agent will decide whether the passenger should be sent for interrogation with airport police, or if they can go through. To decide this, add +2 to the passenger's danger level per each trait the passenger has that the agent dislikes, and -2 for each trait the passenger has and the agent likes. If the result is greater or equal to (10 - paranoia level) then the passenger will be sent for interrogation.

With our previous example, Cthulhu with DL 10 would be picked up first, but since he has 3 traits Barbrady likes, the new danger level will become 4 (10-2*3). Since the officer has a paranoia level of 4, he will let through anyone with modified danger level < 6 (= 10 - 4). In this case Cthulhu is free to go, despite being an actual threat!!!

Poor Maggie Simpson is next, and since Barbrady dislikes her 3 traits, her modified danger level is 6 (0+2*3) so just enough for Barbrady to send her for interrogation.
Output

Your program should simply display what happens at each line in the order it happens. Something like this:

Officer Barbrady was assigned to line 0

Officer Barbrady checks Great Cthulhu and was charmed... Free to go... Missed a threat!

Officer Barbrady checks Maggie Simpson and found there was something fishy... To the interrogation room! Unnecessary screening!


In cases where a person is free to go and wasn't a threat, or when a person is sent to the interrogation room and was a threat, you can print "Good job!"