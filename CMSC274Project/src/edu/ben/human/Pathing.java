package edu.ben.human;

import java.util.ArrayList;
import java.util.PriorityQueue;

import edu.ben.human.Node;

/**
 * Human movement algorithm used method findPath() to see if a valid path
 * 
 * @author abdul
 *
 * 
 */
public class Pathing {
	/**
	 * A 2-d array of node objects used to find a path
	 */
	private Node[][] grid; // 2-D node array
	/**
	 * the board array which is the human bubble
	 */
	private char[][] board; // human bubble
	/**
	 * a char array used to display in counsel
	 */
	char[][] test; // used for display
	/**
	 * a list that holds the final path
	 */
	private ArrayList<int[]> path = new ArrayList<int[]>(); // holds the [x][y] from the target to start
	/**
	 * starting X
	 */
	private int startX = 0;
	/**
	 * starting Y
	 */
	private int startY = 0;
	/**
	 * ending X
	 */
	private int endX = 0;
	/**
	 * ending Y
	 */
	private int endY = 0;
	/**
	 * the G cost which is a constant
	 */
	private int G = 10; // G cost
	/**
	 * amount of moves a human can make
	 */
	private int MAX_MOVES = 6;
	/**
	 * starting node
	 */
	private Node start;
	/**
	 * target end Node
	 */
	private Node end;
	/**
	 * booelean to see if human is stuck by other game objects
	 */
	private boolean stuck = false; // boolean to see if human gets stuck
	/**
	 * a list that stores nodes to check
	 */
	private ArrayList<Node> open = new ArrayList<Node>();
	/*
	 * list that stores nodes checked
	 */
	private ArrayList<Node> closed = new ArrayList<>();

	/**
	 * Pathing algorithm for the human movement side note Human starts at 6,6 in
	 * bubble always
	 * 
	 * @param board
	 *            2-d char array used the human bubble which has which indexes are
	 *            possible moves
	 * @param startX
	 *            starting X location for human
	 * @param startY
	 *            starting Y location for human
	 * @param endX
	 *            end location X
	 * @param endY
	 *            end location Y
	 */
	public Pathing(char[][] board, int startX, int startY, int endX, int endY) {
		grid = new Node[board.length][board[0].length];
		test = new char[board.length][board[0].length];
		this.board = board;
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		calcH(board, endX, endY); // find all H cost in the bubble
		// display();
		start = grid[startX][startY];
		end = grid[endX][endY];
		open.add(start); // add start to open list
	}

	/**
	 * find a path from start to end then sees if the path is less then 6 moves and
	 * return true if path is less then 6 moves
	 * 
	 * @return boolean if under 6 moves return true
	 */
	public boolean findPath() {
		if (stuck(board, startX, startY)) {

			stuck = true;
			return false;
		}
		if (isVaildMove(board, endX, endY)) { // check to see if a vaild move first
			while (true) {
				Node temp = findSmallestF();
				// -> used for display

				if (temp == end) { // node reached target
					closed.add(temp); // temp is end
					break;
				}
				if (temp == null) {
					return false;
				}
				closed.add(temp); // removes the Node with the currently smallest F value
				// left node
				try {
					if (grid[temp.getX()][temp.getY() - 1].getH() != -1.0
							&& !open.contains(grid[temp.getX()][temp.getY() - 1])
							&& !closed.contains(grid[temp.getX()][temp.getY() - 1])) {
						double tempF = temp.getF() + G;
						double compareCost = grid[temp.getX()][temp.getY() - 1].getH() + tempF;
						grid[temp.getX()][temp.getY() - 1].setG(G); // sets G
						if (grid[temp.getX()][temp.getY() - 1].getF() > compareCost
								|| !open.contains(grid[temp.getX()][temp.getY() - 1])) {

							grid[temp.getX()][temp.getY() - 1].setF(compareCost);
						}
						grid[temp.getX()][temp.getY() - 1].setParent(temp);
						open.add(grid[temp.getX()][temp.getY() - 1]);

					}
				} catch (IndexOutOfBoundsException e) {

				}
				// right node
				try {
					if (grid[temp.getX()][temp.getY() + 1].getH() != -1.0
							&& !open.contains(grid[temp.getX()][temp.getY() + 1])
							&& !closed.contains(grid[temp.getX()][temp.getY() + 1])) {
						double tempF = temp.getF() + G;
						double compareCost = grid[temp.getX()][temp.getY() + 1].getH() + tempF;
						grid[temp.getX()][temp.getY() + 1].setG(G); // sets G
						if (grid[temp.getX()][temp.getY() + 1].getF() > compareCost
								|| !open.contains(grid[temp.getX()][temp.getY() + 1])) {

							grid[temp.getX()][temp.getY() + 1].setF(compareCost);
						}
						grid[temp.getX()][temp.getY() + 1].setParent(temp);
						open.add(grid[temp.getX()][temp.getY() + 1]);

					}

				} catch (IndexOutOfBoundsException e) {

				}
				// up node
				try {
					if (grid[temp.getX() - 1][temp.getY()].getH() != -1.0
							&& !open.contains(grid[temp.getX() - 1][temp.getY()])
							&& !closed.contains(grid[temp.getX() - 1][temp.getY()])) {
						double tempF = temp.getF() + G;
						double compareCost = grid[temp.getX() - 1][temp.getY()].getH() + tempF;
						grid[temp.getX() - 1][temp.getY()].setG(G); // sets G
						if (grid[temp.getX() - 1][temp.getY()].getF() > compareCost
								|| !open.contains(grid[temp.getX() - 1][temp.getY()])) {

							grid[temp.getX() - 1][temp.getY()].setF(compareCost);
						}
						grid[temp.getX() - 1][temp.getY()].setParent(temp);
						open.add(grid[temp.getX() - 1][temp.getY()]);

					}
				} catch (IndexOutOfBoundsException e) {

				}
				// down node
				try {
					if (grid[temp.getX() + 1][temp.getY()].getH() != -1.0
							&& !open.contains(grid[temp.getX() + 1][temp.getY()])
							&& !closed.contains(grid[temp.getX() + 1][temp.getY()])) {
						double tempF = temp.getF() + G;
						double compareCost = grid[temp.getX() + 1][temp.getY()].getH() + tempF;
						grid[temp.getX() + 1][temp.getY()].setG(G); // sets G
						if (grid[temp.getX() + 1][temp.getY()].getF() > compareCost
								|| !open.contains(grid[temp.getX() + 1][temp.getY()])) {
							grid[temp.getX() + 1][temp.getY()].setF(compareCost);
						}
						grid[temp.getX() + 1][temp.getY()].setParent(temp);
						open.add(grid[temp.getX() + 1][temp.getY()]);

					}
				} catch (IndexOutOfBoundsException e) {

				}

			}

			Node targetNode = closed.get(closed.size() - 1);
			while (targetNode.getParent() != null) { // starts for endNode and follows parent nodes back
				Node currentNode = targetNode;
				int[] pathXY = { currentNode.getX(), currentNode.getY() };
				path.add(pathXY);
				targetNode = targetNode.getParent();
			}
			open.clear();
			// displayPath();
			if (path.size() > MAX_MOVES) { // went over max moves
				return false;
			} else { // under max moves
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * checks to see if end target is a valid location
	 * 
	 * @return true if a valid location
	 */
	public boolean isVaildMove(char[][] board, int endX, int endY) {
		return board[endX][endY] == 'Z' || board[endX][endY] == 'P' || board[endX][endY] == 'T';

	}

	/**
	 * method to see if player is stuck
	 * 
	 * @param board
	 *            board array
	 * @param startX
	 *            starting X
	 * @param startY
	 *            starting Y
	 * @return if the player is stuck then returns true
	 */
	public boolean stuck(char[][] board, int startX, int startY) {

		boolean north = false;
		boolean east = false;
		boolean south = false;
		boolean west = false;
		// may need to add tree to these
		if (startX - 1 >= 0 && startX - 1 < board.length) {
			if (board[startX - 1][startY] != 'Z' && board[startX - 1][startY] != 'P' && board[startX - 1][startY] != 'E'
					&& board[startX - 1][startY] != 'T') {
				north = true;
			}
		}
		if (startY - 1 >= 0 && startY - 1 < board[0].length) {
			if (board[startX][startY - 1] != 'Z' && board[startX][startY - 1] != 'P' && board[startX][startY - 1] != 'E'
					&& board[startX][startY - 1] != 'T') {
				west = true;
			}
		}
		if (startY + 1 >= 0 && startY + 1 < board[0].length) {
			if (board[startX][startY + 1] != 'Z' && board[startX][startY + 1] != 'P' && board[startX][startY + 1] != 'E'
					&& board[startX][startY + 1] != 'T') {
				east = true;
			}
		}
		if (startX + 1 >= 0 && startX + 1 < board.length) {
			if (board[startX + 1][startY] != 'Z' && board[startX + 1][startY] != 'P' && board[startX + 1][startY] != 'E'
					&& board[startX + 1][startY] != 'T') {
				south = true;
			}
		}
		if (north && east && south && west) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * calulates the H cost of whole boolean array Nodes in the grid get H set in
	 * this method when false it is H is set to -1 and it wont consider it a vaild
	 * index
	 * 
	 * @param board
	 *            human boolean bubble
	 * @param endX
	 *            end X spot
	 * @param endY
	 *            end Y spot
	 */
	public void calcH(char[][] board, int endX, int endY) {
		boolean tree = false;
		if (board[endX][endY] == 'T') {
			// target is a tree
			tree = true;
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				Node temp = new Node(i, j);

				if (board[i][j] == 'T') {
					double hTemp = -1;
					temp.setH(hTemp);
				} else if (board[i][j] == 'F') {
					double hTemp = -1;
					temp.setH(hTemp);
				} else {
					double hTemp = Math.abs((endX - i)) + Math.abs(j - endY);
					temp.setH(hTemp);
				}
				if (i == endX && j == endY) {
					if (tree) {
						double hTemp = Math.abs((endX - i)) + Math.abs(j - endY);
						temp.setH(hTemp);
					}
				}
				grid[i][j] = temp;
			}
		}

	}

	// used for testing
	// displays F vaules
	public void display() {
		System.out.println("-------------------------");
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == null) {
					System.out.print("[ X ]");
				} else {
					System.out.print("[" + grid[i][j].getH() + "]");
				}
			}
			System.out.println();
		}
	}

	// track the movment per move in teh findPath method used for testing
	public void displayMovement(int x, int y) {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX");
		test[x][y] = 'O';
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < test[i].length; j++) {
				if (test[i][j] == 0) {
					System.out.print("[S]");
				} else {
					System.out.print("[" + test[i][j] + "]");
				}
			}
			System.out.println();
		}
	}

	// displays the X,Y of the path
	public void displayPath() {
		for (int i = 0; i < path.size(); i++) {
			System.out.println("[" + path.get(i)[0] + "]" + "[" + path.get(i)[1] + "]");
		}
		System.out.println("-------------------------");
	}

	/**
	 * looks in open for the Node with the smallest F value
	 * 
	 * @return Node With smallest F value
	 */
	public Node findSmallestF() {
		if (open.isEmpty()) {
			return null;
		} else {
			Node min = open.get(0);
			int counter = 0;
			for (int i = 0; i < open.size(); i++) {
				if (min.getF() > open.get(i).getF()) {
					min = open.get(i);

				}
			}
			open.remove(min);
			return min;
		}
	}

	/**
	 * @return the path
	 */
	public ArrayList<int[]> getPath() {
		return path;
	}

	/**
	 * @return the noPath
	 */
	public boolean isStuck() {
		return stuck;
	}

	/**
	 * @param noPath
	 *            the noPath to set
	 */
	public void setStuck(boolean noPath) {
		this.stuck = noPath;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(ArrayList<int[]> path) {
		this.path = path;
	}

}
