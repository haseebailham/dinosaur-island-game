package edu.ben.human;

import java.util.LinkedList;

/**
 * Riddle interface that is used by the riddle classes
 * 
 * @author mraheem
 * @version 1.0
 */
public interface Riddle {
	/**
	 * This method will add the riddle class's riddles to its linked list of riddles
	 * 
	 * @return the linked list of riddles
	 */
	public LinkedList<String> riddlesList();

	/**
	 * This method will evaluate if a certain given answer is correct for its
	 * corresponding riddle
	 * 
	 * @param riddle
	 *            the riddle being answered
	 * @param playerAnswer
	 *            what the user typed in
	 * @return true if the user typed in a correct answer
	 */
	public boolean correctRiddleAnswer(String riddle, String playerAnswer);

	/**
	 * This method will return a riddle that corresponds to the number being passed
	 * in
	 * 
	 * @param num
	 *            the number that corresponds to a riddle
	 * @return the appropriate riddle
	 */
	public String giveRiddle();

	/**
	 * This method generates a random number so the class can output the right
	 * riddle
	 * 
	 * @return a number that will correspond to a riddle
	 */
	public int generateNum();
}
