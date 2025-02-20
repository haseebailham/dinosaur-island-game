package edu.ben.human;

import java.util.ArrayList;
import java.util.LinkedList;

import edu.ben.model.RandomGen;

/**
 * Riddle class, holds all the riddles for level 2needed to help the human get
 * more health points
 * 
 * @author mraheem
 * @version 1.0
 *
 */
public class Riddles2 implements Riddle {
	/**
	 * The linked list that holds all the riddles
	 */
	private LinkedList<String> riddles = new LinkedList<String>();
	/**
	 * A possible riddle that the player can be asked
	 */
	private String riddle1 = "It's shorter than the rest, but when you're happy, you raise it up like it's the best. What is it?";
	/**
	 * A possible riddle that the player can be asked
	 */
	private String riddle2 = "I am rarely touched but often held, and if you are smart you'll use me well. What am I?";
	/**
	 * A possible riddle that the player can be asked
	 */
	private String riddle3 = "When it comes to me, you go on red and stops on green. What am I?";
	/**
	 * A possible riddle that the player can be asked
	 */
	private String riddle4 = "I have cities, but no houses. I have mountains, but no trees. I have water, but no fish. What am I?";
	/**
	 * A possible riddle that the player can be asked
	 */
	private String riddle5 = "I have two arms, but fingers none. I have two feet, but cannot run. I carry well, but I have found I carry best with my feet off the ground. What am I?";
	/**
	 * A possible riddle that the player can be asked
	 */
	private String riddle6 = "First, I threw away the outside and cooked the inside. Then I ate the outside and threw away the inside. What did I eat?";
	/**
	 * A possible riddle that the player can be asked
	 */
	private String riddle7 = "What has a mouth, but cannot eat; moves, but has no legs; and has a bank, but cannot put money in it?";
	/**
	 * The array list that holds all the possible riddle numbers that are left to
	 * ask the player
	 */
	private ArrayList<Integer> possibleNums = new ArrayList<Integer>();

	/**
	 * Riddles2 constructor, which adds the possible numbers to the arraylist
	 */
	public Riddles2() {
		possibleNums.add(1);
		possibleNums.add(2);
		possibleNums.add(3);
		possibleNums.add(4);
		possibleNums.add(5);
		possibleNums.add(6);
		possibleNums.add(7);
	}

	/**
	 * Creates the riddle linked list that stores the riddles
	 * 
	 * @return riddles, the linked list holding all the riddles
	 */
	@Override
	public LinkedList<String> riddlesList() {
		riddles.add(riddle1);
		riddles.add(riddle2);
		riddles.add(riddle3);
		riddles.add(riddle4);
		riddles.add(riddle5);
		riddles.add(riddle6);
		riddles.add(riddle7);
		return riddles;
	}

	/**
	 * This method returns the possible answers for riddle 1
	 * 
	 * @return a linked list of the possible answers for riddle 1
	 */
	public LinkedList<String> riddle1Answers() {
		LinkedList<String> answers = new LinkedList<String>();
		String[] answerOptions = { "thumb", "a thumb", "your thumb", "my thumb", "the thumb" };
		for (int i = 0; i < answerOptions.length; i++) {
			answers.add(answerOptions[i]);
		}
		return answers;
	}

	/**
	 * This method returns the possible answers for riddle 2
	 * 
	 * @return a linked list of the possible answers for riddle 2
	 */
	public LinkedList<String> riddle2Answers() {
		LinkedList<String> answers = new LinkedList<String>();
		String[] answerOptions = { "a tongue", "tongue", "your tongue", "my tongue", "the tongue" };
		for (int i = 0; i < answerOptions.length; i++) {
			answers.add(answerOptions[i]);
		}
		return answers;
	}

	/**
	 * This method returns the possible answers for riddle 3
	 * 
	 * @return a linked list of the possible answers for riddle 3
	 */
	public LinkedList<String> riddle3Answers() {
		LinkedList<String> answers = new LinkedList<String>();
		String[] answerOptions = { "watermelon", "a watermelon", "a piece of watermelon", "a watermelon piece",
				"watermelon piece", "watermelon slice", "a watermelon slice" };
		for (int i = 0; i < answerOptions.length; i++) {
			answers.add(answerOptions[i]);
		}
		return answers;
	}

	/**
	 * This method returns the possible answers for riddle 4
	 * 
	 * @return a linked list of the possible answers for riddle 4
	 */
	public LinkedList<String> riddle4Answers() {
		LinkedList<String> answers = new LinkedList<String>();
		String[] answerOptions = { "map", "a map", "the map", "my map", "your map", "atlas", "an atlas", "the atlas",
				"my atlas", "your atlas" };
		for (int i = 0; i < answerOptions.length; i++) {
			answers.add(answerOptions[i]);
		}
		return answers;
	}

	/**
	 * This method returns the possible answers for riddle 5
	 * 
	 * @return a linked list of the possible answers for riddle 5
	 */
	public LinkedList<String> riddle5Answers() {
		LinkedList<String> answers = new LinkedList<String>();
		String[] answerOptions = { "wheelbarrow", "a wheelbarrow", "the wheelbarrow", "my wheelbarrow",
				"your wheelbarrow" };
		for (int i = 0; i < answerOptions.length; i++) {
			answers.add(answerOptions[i]);
		}
		return answers;
	}

	/**
	 * This method returns the possible answers for riddle 6
	 * 
	 * @return a linked list of the possible answers for riddle 6
	 */
	public LinkedList<String> riddle6Answers() {
		LinkedList<String> answers = new LinkedList<String>();
		String[] answerOptions = { "corn on the cob", "corn on cob", "corn", "a corn on a cob", "the corn on the cob",
				"a corn on the cob", "a corn on cob", "the corn on a cob" };
		for (int i = 0; i < answerOptions.length; i++) {
			answers.add(answerOptions[i]);
		}
		return answers;
	}

	/**
	 * This method returns the possible answers for riddle 7
	 * 
	 * @return a linked list of the possible answers for riddle 7
	 */
	public LinkedList<String> riddle7Answers() {
		LinkedList<String> answers = new LinkedList<String>();
		String[] answerOptions = { "a river", "river", "the river", "some river" };
		for (int i = 0; i < answerOptions.length; i++) {
			answers.add(answerOptions[i]);
		}
		return answers;
	}

	/**
	 * This method checks if the answer the player gave is correct
	 * 
	 * @param riddle
	 *            the riddle array holding both the question and answer
	 * @param playerAnswer
	 *            the answer the player gives
	 * @return true if the player's answer is correct, false if it is incorrect
	 */
	@Override
	public boolean correctRiddleAnswer(String riddle, String playerAnswer) {
		/*
		 * checks which riddle the player was asked and checks the appropriate list of
		 * correct answers to see if the player answered correctly
		 */
		if (riddle.equals(riddle1)) {
			for (int i = 0; i < riddle1Answers().size(); i++) {
				if (riddle1Answers().get(i).equalsIgnoreCase(playerAnswer)) {
					return true;
				}
			}
		} else if (riddle.equals(riddle2)) {
			for (int i = 0; i < riddle2Answers().size(); i++) {
				if (riddle2Answers().get(i).equalsIgnoreCase(playerAnswer)) {
					return true;
				}
			}
		} else if (riddle.equals(riddle3)) {
			for (int i = 0; i < riddle3Answers().size(); i++) {
				if (riddle3Answers().get(i).equalsIgnoreCase(playerAnswer)) {
					return true;
				}
			}
		} else if (riddle.equals(riddle4)) {
			for (int i = 0; i < riddle4Answers().size(); i++) {
				if (riddle4Answers().get(i).equalsIgnoreCase(playerAnswer)) {
					return true;
				}
			}
		} else if (riddle.equals(riddle5)) {
			for (int i = 0; i < riddle5Answers().size(); i++) {
				if (riddle5Answers().get(i).equalsIgnoreCase(playerAnswer)) {
					return true;
				}
			}
		} else if (riddle.equals(riddle6)) {
			for (int i = 0; i < riddle6Answers().size(); i++) {
				if (riddle6Answers().get(i).equalsIgnoreCase(playerAnswer)) {
					return true;
				}
			}
		} else if (riddle.equals(riddle7)) {
			for (int i = 0; i < riddle7Answers().size(); i++) {
				if (riddle7Answers().get(i).equalsIgnoreCase(playerAnswer)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This will give the riddle corresponding to the number being passed in
	 * 
	 * @param num
	 *            the number for the riddle
	 * @return proper riddle
	 */
	@Override
	public String giveRiddle() {
		int num = generateNum();
		possibleNums.remove(Integer.valueOf(num));
		if (num == 1) {
			return riddle1;
		} else if (num == 2) {
			return riddle2;
		} else if (num == 3) {
			return riddle3;
		} else if (num == 4) {
			return riddle4;
		} else if (num == 5) {
			return riddle5;
		} else if (num == 6) {
			return riddle6;
		} else if (num == 7) {
			return riddle7;
		}
		return null;
	}

	/**
	 * This method generates a random number so the class can output the right
	 * riddle
	 * 
	 * @return a number that will correspond to a riddle
	 */
	public int generateNum() {
		RandomGen r = new RandomGen();
		int num = r.randomNum(7);
		while (!possibleNums.contains(num)) {
			num = r.randomNum(7);
		}
		return num;
	}

	/**
	 * @return the possibleNums the array holding the riddle numbers that have not
	 *         been asked yet
	 */
	public ArrayList<Integer> getPossibleNums() {
		return possibleNums;
	}

	/**
	 * @param possibleNums
	 *            the possibleNums to set, which are the array holding the riddle
	 *            numbers that have not been asked yet
	 */
	public void setPossibleNums(ArrayList<Integer> possibleNums) {
		this.possibleNums = possibleNums;
	}
}
