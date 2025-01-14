
package edu.ben.human;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class for the human object does movement and holds all the information needed
 * about human
 * 
 * @author akhan
 * @author mraheem
 * @author haseebailham
 * @version 1.0
 */
public class Human {

	/**
	 * Maximum number of moves human can take
	 */
	private final int MAX_MOVES = 6;

	/**
	 * Amount of moves
	 */
	private int moves = 6;

	/**
	 * Human x location (x, y) (from game board)
	 */
	private int humanX = 0;

	/**
	 * Human y location (x, y) (from game board)
	 */
	private int humanY = 0;

	/**
	 * Target X location (x, y) (from game board)
	 */
	private int targetX = 0;

	/**
	 * Target Y location (x, y) (from game board)
	 */
	private int targetY = 0;

	/**
	 * Health Bar object, handles human health points, and updates health when in
	 * contact with obstacle.
	 */
	private HealthBar health = new HealthBar();

	/**
	 * Human character value
	 */
	private char humanChar = 'H';

	/**
	 * Level number
	 */
	private int level = 1;

	/**
	 * Stores player's previous position on game board
	 */
	private Queue<int[]> prevPosition = new LinkedList<int[]>();

	/**
	 * Character 2-D board which holds game characters Used for movement
	 */
	private char[][] board;

	/**
	 * Has the boolean values of possible locations to move to
	 */
	private boolean[][] booleanBubble;

	/**
	 * Human bubble object
	 */
	private HumanBubble bubble = new HumanBubble(level);

	/**
	 * Points object
	 */
	private Points points = new Points();

	/**
	 * Current points
	 */
	private int currentPoints = 2;

	/**
	 * Boolean if human is stuck
	 */
	private boolean stuck = false;

	/**
	 * Human near dinosaur boolean
	 */
	private boolean nearDinosaur = false; // is true when dinosaur are near human

	/**
	 * 
	 * @param level
	 *            the level the human is on
	 * @param board
	 *            the level board the board the human starts with is the one used
	 *            when the level is first made
	 */
	public Human(int level, char[][] board) {
		this.level = level;
		this.board = board;
	}

	/**
	 * calls pathing to find if the a path to the set target is within 6 moves
	 * 
	 * @return boolean if a valid path is found return true
	 */
	public boolean moveHuman() {
		makeBubble();
		int endX = 0;
		int endY = 0;
		// need to convert index from board to the sub array the human uses for human
		// because in sub array human is always in the center which is 6,6 so target
		// need to be converted to fit into the human bubble
		if (humanX > targetX) {
			endX = humanX - targetX;
			endX = MAX_MOVES - endX;
		} else if (humanX < targetX) {
			endX = targetX - humanX;
			endX = MAX_MOVES + endX;
		} else if (humanX == targetX) {
			endX = MAX_MOVES;
		}

		if (humanY > targetY) {
			endY = humanY - targetY;
			endY = MAX_MOVES - endY;
		} else if (humanY < targetY) {
			endY = targetY - humanY;
			endY = endY + MAX_MOVES;
		} else if (humanY == targetY) {
			endY = MAX_MOVES;
		}

		if (endX < 0 || endX >= bubble.getBubble().length || endY < 0 || endY >= bubble.getBubble()[0].length) {
			// checks for out of bounds
			return false;
		}
		// human start is always 6,6
		Pathing path = new Pathing(bubble.getBubble(), MAX_MOVES, MAX_MOVES, endX, endY);
		boolean validMove = path.findPath();
		if (path.isStuck()) {
			stuck = path.isStuck();
			return stuck;
		}
		return validMove;
	}

	/**
	 * makes the boolean bubble array
	 * 
	 * @return boolean 2-d array
	 */
	public boolean[][] makeBooleanBubble() {
		char[][] tempBubble = bubble.makeBubble(board, humanX, humanY);
		booleanBubble = bubble.changeTypeBoard(tempBubble);
		return booleanBubble;
	}

	/**
	 * makes the human bubble array
	 * 
	 * @return boolean 2-d array
	 */
	public char[][] makeBubble() {

		return bubble.makeBubble(board, humanX, humanY);

	}

	/**
	 * uses the Human bubble to look for dinosaur
	 * 
	 * @return ArrayList<int[]> if a dinosaur(s) is near return the index of their
	 *         location
	 */
	public ArrayList<int[]> lookForDinosaur() {
		ArrayList<int[]> rangeList = bubble.getRangeIndex();

		if (rangeList.size() != 0) {
			nearDinosaur = true;
			return rangeList;
		} else {
			nearDinosaur = false;
			return null;
		}

	}

	/**
	 * Instantiates new MovementLevel1 object every time,
	 *
	 * @param targetX
	 *            target X player position.
	 * @param targetY
	 *            target Y player position.
	 */
	public void setTarget(int targetX, int targetY) {
		this.targetX = targetX;
		this.targetY = targetY;
	}

	/**
	 * Adds new clicked position to queue
	 * 
	 * @param x
	 *            row in grid
	 * @param y
	 *            column in grid.
	 */
	public void addNewPosition(int x, int y) {
		int[] newPos = { x, y };
		humanX = x;
		humanY = y;
		prevPosition.add(newPos);
	}

	/**
	 * Removes position from queue.
	 * 
	 * @return int[] of 2 values.
	 */
	public int[] removePrevPosition() {
		return prevPosition.remove();
	}

	/**
	 * Checks if human died based on health.
	 * 
	 * @param health
	 *            int value
	 * @return true if human is dead, false if not
	 */
	public boolean isDead() {
		return health.getHealthBar() == 0;
	}


	/**
	 * @return the turns
	 */
	public int getTurns() {
		return moves;
	}

	/**
	 * @param turns
	 *            the turns to set
	 */
	public void setTurns(int turns) {
		this.moves = turns;
	}

	/**
	 * @return the humanChar
	 */
	public char getHumanChar() {
		return humanChar;
	}

	/**
	 * @param humanChar
	 *            the humanChar to set
	 */
	public void setHumanChar(char humanChar) {
		this.humanChar = humanChar;
	}

	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @return the humanX
	 */
	public int getHumanX() {
		return humanX;
	}

	/**
	 * @param humanX
	 *            the humanX to set
	 */
	public void setHumanX(int humanX) {
		this.humanX = humanX;
	}

	/**
	 * @return the humanY
	 */
	public int getHumanY() {
		return humanY;
	}

	/**
	 * @param humanY
	 *            the humanY to set
	 */
	public void setHumanY(int humanY) {
		this.humanY = humanY;
	}

	/**
	 * @return the prevPosition
	 */
	public Queue<int[]> getPrevPosition() {
		return prevPosition;
	}

	/**
	 * @param prevPosition
	 *            the prevPosition to set
	 */
	public void setPrevPosition(Queue<int[]> prevPosition) {
		this.prevPosition = prevPosition;
	}

	/**
	 * @return the targetX
	 */
	public int getTargetX() {
		return targetX;
	}

	/**
	 * @param targetX
	 *            the targetX to set
	 */
	public void setTargetX(int targetX) {
		this.targetX = targetX;
	}

	/**
	 * @return the targetY
	 */
	public int getTargetY() {
		return targetY;
	}

	/**
	 * @param targetY
	 *            the targetY to set
	 */
	public void setTargetY(int targetY) {
		this.targetY = targetY;
	}

	/**
	 * @return the board
	 */
	public char[][] getBoard() {
		return board;
	}

	/**
	 * @param board
	 *            the board to set
	 */
	public void setBoard(char[][] board) {
		this.board = board;
	}

	/**
	 * @return the health
	 */
	public HealthBar getHealth() {
		return health;
	}

	/**
	 * @param health
	 *            the health to set
	 */
	public void setHealth(HealthBar health) {
		this.health = health;
	}

	/**
	 * @return the booleanBubble
	 */
	public boolean[][] getBooleanBubble() {
		return booleanBubble;
	}

	/**
	 * @param booleanBubble
	 *            the booleanBubble to set
	 */
	public void setBooleanBubble(boolean[][] booleanBubble) {
		this.booleanBubble = booleanBubble;
	}

	/**
	 * @return the bubble
	 */
	public HumanBubble getBubble() {
		return bubble;
	}

	/**
	 * @param bubble
	 *            the bubble to set
	 */
	public void setBubble(char[][] bubble) {
		this.bubble.setBubble(bubble);
	}

	/**
	 * @return the stuck
	 */
	public boolean isStuck() {
		return stuck;
	}

	/**
	 * @param stuck
	 *            the stuck to set
	 */
	public void setStuck(boolean stuck) {
		this.stuck = stuck;
	}

	/**
	 * @return the points
	 */
	public Points getPoints() {
		return points;
	}

	/**
	 * @param points
	 *            the points to set
	 */
	public void setPoints(Points points) {
		this.points = points;
	}

	/**
	 * @return the currentPoints
	 */
	public int getCurrentPoints() {
		return currentPoints;
	}

	/**
	 * @param currentPoints
	 *            the currentPoints to set
	 */
	public void setCurrentPoints(int currentPoints) {
		this.currentPoints = currentPoints;
	}

	/**
	 * @return the nearDinosaur
	 */
	public boolean isNearDinosaur() {
		return nearDinosaur;
	}

	/**
	 * @param nearDinosaur
	 *            the nearDinosaur to set
	 */
	public void setNearDinosaur(boolean nearDinosaur) {
		this.nearDinosaur = nearDinosaur;
	}

}
