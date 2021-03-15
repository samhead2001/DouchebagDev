package weapons;

import players.NerdSlayer69;

public class Fists extends Weapon {
	
	public Fists (NerdSlayer69 user) {
		super(user);
	}
	
	
	@Override
	public void useNutralAttack() {
		System.out.println("blu");
	}
	
	@Override
	public void useDownAttack () {
		System.out.println("bug");
	}
	
	@Override
	public void useUpAttack () {
		System.out.println("debug");
	}
	
	@Override
	public void useNutralSpecial () {
		System.out.println("nbr");
	}
	
	@Override
	public void useSideSpecial () {
		System.out.println("guh");
	}
	
	@Override
	public void useDownSpecial () {
		System.out.println("huh");
	}
	
	@Override
	public void useUpSpecial () {
		System.out.println(">");
	}
	

	@Override
	public int [] getEndLags () {
		int [] returnArray = new int []{0,0,0,0,0,0,0,0};
		return returnArray;
	}

}
