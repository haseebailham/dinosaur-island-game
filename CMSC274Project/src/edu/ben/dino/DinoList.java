package edu.ben.dino;

import java.util.ArrayList;

/**
 * This class is a way to store the dinos per lvl also preforms task on the
 * dinosaurs such as calling the movemethod and setting its new and old
 * locations *
 * 
 * @author abdul
 * @version 1.0
 */
public class DinoList {
	/**
	 * a Arraylist of dinosaur objects
	 */
	private ArrayList<Dino> dinoList = new ArrayList<Dino>();
	/**
	 * the size of the list
	 */
	private int size = 0;

	public DinoList() {
		// empty
	}

	/**
	 * calls the move dinosaur method in the dino class and takes it return value
	 * and sets its new locations in the backEnd array
	 * 
	 * @param board
	 *            char[][] the board
	 * @param humanX
	 *            the X of the human
	 * @param humanY
	 *            the Y of the human
	 * @param index
	 *            the index of the dinosaur to move
	 */
	public void moveDinosaurs(char[][] board, int humanX, int humanY, int index) {
		checkForHuman(index);
		dinoList.get(index).setNearHuman(false);
		ArrayList<int[]> path = new ArrayList<int[]>();
		int x = 0;
		if (!dinoList.get(index).isFoundHuman()) {
			path = dinoList.get(index).moveDinosaur(board, humanX, humanY);
			setDinoCurrentPostion(index, path.get(x)[0], path.get(x)[1]);

		} else {
			x = 0;
			path = dinoList.get(index).moveDinosaur(board, humanX, humanY);
			if (path.size() > 1) {
				x = path.size() - dinoList.get(index).getMovement();

			}
			if (dinoList.get(index).getLevel() > 2) {
				if (path.size() == 2) {
					x = 1;
				}
			}
			setDinoCurrentPostion(index, path.get(x)[0], path.get(x)[1]);

			// setDinoCurrentPostion(i, path.get(0)[0], path.get(0)[1]);
		}

	}

	/**
	 * uses the humans list of indexs which contain a dinosaur, then adds those
	 * dinos to a temp list
	 * 
	 * @param rangeList
	 *            the humans list of index with dinosaurs in his bubble
	 * @return a list of dinosaurs who are in the human bubble
	 */
	public ArrayList<Dino> checkNearHuman(ArrayList<int[]> rangeList) {
		ArrayList<Dino> tempList = new ArrayList<Dino>();
		if (rangeList != null) {

			for (int i = 0; i < dinoList.size(); i++) {
				int x = dinoList.get(i).getDinoX();
				int y = dinoList.get(i).getDinoY();
				for (int j = 0; j < rangeList.size(); j++) {

					int[] temp = rangeList.get(j);
					if (x == temp[0] && y == temp[1]) {
						tempList.add(dinoList.get(i));
						// dinoList.get(i).setNearHuman(true);

					}
				}
			}
			return tempList;
		} else {
			return tempList;
		}
	}

	/**
	 * makes the bubbles for the dinosaurs in the list
	 * 
	 * @param board
	 *            char[][] the game board
	 */
	public void makeBubbles(char[][] board) {
		for (int i = 0; i < dinoList.size(); i++) {
			dinoList.get(i).makeBubble(board);
		}
	}

	/**
	 * calls the dino check for human method
	 * 
	 * @param index
	 *            the index of list to look at
	 * @return a boolean if the human is found
	 */
	public boolean checkForHuman(int index) {

		if (dinoList.get(index).checkForHuman()) {
			dinoList.get(index).setFoundHuman(true);
			return true;
		} else {
			return false;
		}

	}

	/**
	 * takes in a dino type and then adds its respected dino type to the list
	 * 
	 * @param temp
	 *            the dino type
	 */
	public void addDino(Dino temp) {

		if (temp.getDinoName().equalsIgnoreCase("Ankylosaurus")
				|| temp.getDinoName().equalsIgnoreCase("Brachiosaurus")) {
			addHerbivore(temp.getDinoName(), temp);
		} else if (temp.getDinoName().equals("Velociraptor")) {
			addVelociraptor(temp);
		} else if (temp.getDinoName().equals("Trex")) {
			addTrex(temp);
		}
	}

	/**
	 * stores and creates herbivore(s)
	 * 
	 * @param dinoName
	 *            String of which herbivore to add
	 */
	public void addHerbivore(String dinoName, Dino temp) {
		Dino herb = new Herbivore(dinoName);
		herb = temp;
		dinoList.add(herb);
		size++;
	}

	/**
	 * adds velociraptor to list
	 * 
	 */
	public void addVelociraptor(Dino temp) {
		dinoList.add(temp);
		size++;

	}

	/**
	 * adds just one trex
	 */
	public void addTrex(Dino temp) {
		dinoList.add(temp);
		size++;
	}

	/**
	 * used to get a index from the list
	 * 
	 * @param index
	 *            interger of the index you want
	 */
	public Dino getIndex(int index) {

		return (dinoList.get(index));
	}

	public Dino remove(int index) {
		return dinoList.remove(index);
	}

	/**
	 * clear the list and reset size
	 */
	public void clear() {
		dinoList.removeAll(dinoList);
		size = 0;
	}

	/**
	 * sets the given dinosaur`s location
	 * 
	 * @param index
	 *            index of dinosuar to update
	 * @param x
	 *            rows
	 * @param y
	 *            columns
	 */
	public void setDinoCurrentPostion(int index, int x, int y) {
		setPrevDinosaurLocation(index, getIndex(index).getDinoX(), getIndex(index).getDinoY()); // sets prev location //
																								// location
		getIndex(index).setDinoX(x); // sets new one
		getIndex(index).setDinoY(y);
	}

	/**
	 * gets the dinosaurs previous location
	 * 
	 * @param index
	 *            index for the dinoList
	 * @return int[] where dinoX = 0 dinoY = 1
	 */
	public int[] getPrevDinosaurLoctaion(int index) {
		int[] dinosaurLoctaion = getIndex(index).getPrevLocation();
		return dinosaurLoctaion;
	}

	/**
	 * gets the dinosaurs new location
	 * 
	 * @param index
	 *            index for the dinoList
	 * @return int[] where dinoX = 0 dinoY = 1
	 */
	public int[] getCurrentDinosaurLoctaion(int index) {
		int[] dinosaurLoctaion = { getIndex(index).getDinoX(), getIndex(index).getDinoY() };
		return dinosaurLoctaion;
	}

	public void setPrevDinosaurLocation(int index, int i, int j) {
		getIndex(index).setPrevLocation(i, j);
	}

	/**
	 * @return the dinoList
	 */
	public ArrayList<Dino> getDinoList() {
		return dinoList;
	}

	/**
	 * @param dinoList
	 *            the dinoList to set
	 */
	public void setDinoList(ArrayList<Dino> dinoList) {
		this.dinoList = dinoList;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

}
