package players;

import main.GameObject;
import resources.Sprite;
import weapons.Fists;
import weapons.TeslaCoil;
import weapons.Weapon;

public class NerdSlayer69 extends GameObject{
	
	Weapon wpn;
	
	

	boolean attacking = false;
	
	int endLag = 0;
	int lagTime = 0;
	
	
	int chosenAttack = 0; // same indexing system as the indexing for the lags in weapon
	
	public NerdSlayer69 () {
		this.setSprite(new Sprite ("resources/sprites/nerdSlayer.png"));
		setWeapon(new TeslaCoil(this));
		this.getAnimationHandler().setFrameTime(1000);
		wpn.declare();
	}
	
	@Override
	public void frameEvent ()
	{
		if (!attacking) {
			if (lagTime == endLag) {
				
				if (this.setUpAttack()) {
					endLag = wpn.getEndLags()[chosenAttack];
					wpn.useAttack(chosenAttack);
					lagTime = 0;
					attacking = true;
				}
				
			} else {
				lagTime = lagTime + 1;
			}
			if (this.keyDown('D')) {
				
				this.setX(this.getX() + 1);
				this.getAnimationHandler().setFlipHorizontal(false);
				
			} else {
				if (this.keyDown('A')) {
					
					this.setX(this.getX() - 1);
					this.getAnimationHandler().setFlipHorizontal(true);
					
				}
			}
		}
		
		
	}
	
	public void endAttack () {
		attacking = false; 
		
	}
	
	/**
	 * sets up the attack
	 * @return true if the game detects an attack false otherwise
	 */
	private boolean setUpAttack () {
		
		// checks for the nutral attack
		if (this.mouseButtonClicked(0) && !this.keyDown('S') && !this.keyDown('W')) {
			
			chosenAttack = 0;
			
			return true;
		}
		
		// checks for an down attack
		if (this.keyDown('S') && this.mouseButtonClicked(0)) {
			
			chosenAttack = 1;
			
			return true;
		}
		
		// checks for a up attack
		if (this.keyDown('W') && this.mouseButtonClicked(0)) {
			
			chosenAttack = 2;
			
			return true;
		}
		
		// checks for a nutral special
		if (this.mouseButtonClicked(2) && !this.keyDown('D') && !this.keyDown('A') && !this.keyDown('S') && !this.keyDown('W')) {
			
			chosenAttack = 3;
			
			return true;
		}
		
		// checks for a side special
		if ((this.keyDown('D') || this.keyDown('A')) && this.mouseButtonClicked(2)) {
			
			chosenAttack = 4;
			
			return true;
		}
		
		// checks for a down special
		if (this.keyDown('S') && this.mouseButtonClicked(2)) {
			
			chosenAttack = 5;
			
			return true;
		}
		
		// checks for a up special
		if (this.keyDown('W') && this.mouseButtonClicked(2)) {
			
			chosenAttack = 6;
			
			return true;
		}
		
		return false;
	}
	public void setWeapon(Weapon weapon)
	{
		wpn = weapon;
	}
	
}
