package edu.ben.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.dino.Dino;
import edu.ben.dino.DinoList;
import edu.ben.model.BackEndBoard;
import edu.ben.model.Bubble;

/**
 * test for dino bubble
 * 
 * @author abdul
 *
 */
public class DinoBubbleTest {

	@Test
	/**
	 * test to see if a bubble is created okay and checks a index with the board
	 * Test are based off of the lvl 1 board layout
	 */
	public void testBubbleLvl1() {
		char[][] board = new char[10][17];
		Bubble bubble = new Bubble(1);
		BackEndBoard backEnd = new BackEndBoard(1);

		board = backEnd.getBoard();

		DinoList dl = backEnd.getDl();

		Dino temp = dl.getIndex(0);
		temp.makeBubble(board);

		Bubble actual = temp.getBubble();
		char[][] r = actual.getBubble();
		char expected = 3;
		assertEquals(expected, r.length);
	}

	@Test
	/**
	 * test to see if a bubble is created okay and checks a index with the board
	 * Test are based off of the lvl 2 board layout
	 */
	public void testBubbleLvl2() {
		char[][] board = new char[10][17];
		Bubble bubble = new Bubble(2);
		BackEndBoard backEnd = new BackEndBoard(2);
		board = backEnd.getBoard();

		DinoList dl = backEnd.getDl();

		Dino temp = dl.getIndex(0); // [0][3]
		temp.makeBubble(board);

		Bubble actual = temp.getBubble();
		char[][] r = actual.getBubble();
		char expected = 'F';
		// backEnd.display(r);
		assertEquals(expected, r[0][0]);
	}

}
