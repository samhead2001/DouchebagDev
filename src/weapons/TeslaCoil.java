package weapons;

import players.NerdSlayer69;
import resources.Sprite;

public class TeslaCoil extends Weapon
{
	public Sprite nutatk = new Sprite("Whip_neutatk.txt");
		
		public TeslaCoil (NerdSlayer69 user) {
			super(user);
		}
		
		
		@Override
		public void useNutralAttack() { //whip in facing direction a short distance
			
			if (!weilder.getSprite().equals(nutatk)) {
			weilder.setSprite(nutatk);
			}
		}
		
		@Override
		public void useDownAttack () { //????
			System.out.println("bug");
		}
		
		@Override
		public void useUpAttack () { //whip upwards, maybe good for ufo nerd
			System.out.println("debug");
		}
		
		@Override
		public void useNutralSpecial () { //
			System.out.println("nbr");
		}
		
		@Override
		public void useSideSpecial () { //grabs enemy if enemy is in range, pulls it toward character, character holds up person and character electrocutes character using only his hands
			System.out.println("guh");
		}
		
		@Override
		public void useDownSpecial () { //whip goes back and forth
			System.out.println("huh");
		}
		
		@Override
		public void useUpSpecial () { //shoot whip into sky and send lightning bolts in front of person
			System.out.println(">");
		}
		

		@Override
		public int [] getEndLags () {
			int [] returnArray = new int []{0,0,0,0,0,0,0,0};
			return returnArray;
		}
//survival kit, is the stick thing with the string and used to make a fire
//IDEA: make it an op item that kills anyone on screen and also makes the background on fire, but you have to like mash a button quickly in order for it to occur
	}
