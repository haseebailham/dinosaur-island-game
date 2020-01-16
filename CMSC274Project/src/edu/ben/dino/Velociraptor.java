package edu.ben.dino;

import edu.ben.model.Bubble;

/**
 * A sub class of Dino used for level 2
 * 
 * @author abdul
 *
 */
public class Velociraptor extends Dino {
	/**
	 * sets the variables for the velociraptor
	 */
	public Velociraptor() {
		setDinoDmg(30);
		setMovement(2);
		setDinoName("Velociraptor");
		setCharName('V');
		setBubble(new Bubble(2));
		setDinoX(getDinoX());
		setDinoY(getDinoY());
		setPrevLocation(getPrevLocation());
	}

}
