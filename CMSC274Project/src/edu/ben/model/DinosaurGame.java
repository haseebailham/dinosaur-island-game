package edu.ben.model;

import java.awt.EventQueue;

import edu.ben.visual.DinosaurFrame;
import edu.ben.visual.Lvl1Frame;
import edu.ben.visual.Lvl2GUI;
import edu.ben.visual.Lvl3GUI;
import edu.ben.visual.SplashScreenGUI;

/**
 * Main Game, starts Dinosaur Uproar game and sets GUI visible.
 * 
 * @author akhan
 * @author haseebailham
 * @author mraheem
 * @version 1.0
 */
public class DinosaurGame {

	/**
	 * board array for levels
	 */
	private BackEndBoard board;
	/**
	 * Level number starts with 0 for the splash screen, then increments to each
	 * level
	 */
	private int level = 2;
	/**
	 * the gui frame object
	 */
	private DinosaurFrame frame;

	/**
	 * Dinosaur game variable
	 */
	private static DinosaurGame game = new DinosaurGame();

	/**
	 * Public constructor for class
	 */
	public DinosaurGame() {
		// empty
	}

	/**
	 * Main method, plays game through start level method.
	 * 
	 * @param args
	 *            String[] argument
	 */
	public static void main(String[] args) {
		game.startLevel(game);

	}

	/**
	 * starts the event queue
	 */
	public void playGame() {
		// levels:
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setTitle("Dinosaur Uproar: Level " + level);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * @return the board
	 */
	public BackEndBoard getBoard() {
		return board;
	}

	/**
	 * Next level
	 */
	public void nextLevel() {
		Sounds.off();
		level++;
		startLevel(game);

	}

	/**
	 * @param board
	 *            the board to set
	 */
	public void setBoard(BackEndBoard board) {
		this.board = board;
	}

	/**
	 * Closes frame
	 */
	public void closeFrame() {
		Sounds.off();
		frame.setVisible(false);
	}

	/**
	 * exits the game from splash screen
	 */
	public void quitGame() {
		frame.dispose();
		System.exit(level);
		Sounds.off();
	}

	/**
	 * exits the current level and goes to splash screen
	 */
	public void quitLevel() {
		Sounds.off();
		closeFrame();
		level = 0;
		startLevel(game);
	}

	/**
	 * sets frame to new lvl frame sets backEnd to new lvl backEnd
	 */
	public void startLevel(DinosaurGame game) {
		if (level == 0) {
			frame = new SplashScreenGUI(game);
			playGame();
		} else if (level == 1) {
			board = new BackEndBoard(level);
			frame = new Lvl1Frame(game);
			playGame();
		} else if (level == 2) {
			board = new BackEndBoard(level);
			frame = new Lvl2GUI(game);
			playGame();
		} else if (level == 3) {
			board = new BackEndBoard(level);
			frame = new Lvl3GUI(game);
			playGame();
		}
	}

	/**
	 * @return the level the player is on
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
	 * @return the frame of the game
	 */
	public DinosaurFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame
	 *            the frame to set
	 */
	public void setFrame(DinosaurFrame frame) {
		this.frame = frame;
	}

}
