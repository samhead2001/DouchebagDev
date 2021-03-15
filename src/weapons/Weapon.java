package weapons;

import main.GameObject;
import players.NerdSlayer69;

public abstract class Weapon extends GameObject {

	NerdSlayer69 weilder;
	
	int attackInUse = 69; // indexed the same as the lags
	
	public Weapon (NerdSlayer69 user) {
		weilder = user;
	}
	
	public abstract void useNutralAttack();
	
	public abstract void useDownAttack ();
	
	public abstract void useUpAttack ();
	
	public abstract void useNutralSpecial ();
	
	public abstract void useSideSpecial ();
	
	public abstract void useDownSpecial ();
	
	public abstract void useUpSpecial ();
	

	/*
	 * amount of time that needs to go by before you can attack after using an attack
	 * ordered nutral down up nutral special side special down special up special
	 * mesured in frames
	 */
	public abstract int [] getEndLags ();
	
	public NerdSlayer69 getWeilder () {
		return weilder;
	}
	public void useAttack (int attackNum) {
		attackInUse = attackNum;
	}
	@Override
	public void frameEvent () {
		switch (attackInUse) {
			case 0: 
			this.useNutralAttack();
			break;
			
			case 1:
			this.useDownAttack();
			break;
			
			case 2:
			this.useUpAttack();
			break;
			
			case 3:
			this.useNutralSpecial();
			break;
			
			case 4:
			this.useSideSpecial();
			break;
			
			case 5:
			this.useDownSpecial();
			break;
			
			case 6:
			this.useUpSpecial();
			break;
					
		}
	}
	public void endAttack () {
		attackInUse = 69;
		weilder.endAttack();
	}
	
}
