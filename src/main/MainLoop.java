package main;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * A loop for the game logic; mostly copy-pasted from RenderLoop
 * @author nathan
 *
 */
public class MainLoop {

	/**
	 * The maximum framerate the game can run at
	 */
	public static final double stepsPerSecond = 30;
	
	/**
	 * time each frame starts
	 */
	static long startTime;
	
	/**
	 * The time of the last update to the GameWindow, in nanoseconds.
	 */
	static private long lastUpdate;
	/**
	 * The image of the input from the past GameLogic frame
	 */
	static private InputManager inputImage;
	/**
	 * Whether or not the game logic has run at least once
	 */
	static private volatile boolean gameCodeHasRun = false;
	
	/**
	 * the window the game is rendered on
	 */
	
	public static final GameWindow window = new GameWindow (960, 540);
	
	
	public static void main (String[] args) {
		GameCode.initialize ();
		while (true) {
			//Get the target time in nanoseconds for this iteration; should be constant if stepsPerSecond doesn't change
			long targetNanoseconds = (long)(1000000000 / stepsPerSecond);
			//Get the time before running the game logic
			startTime = System.nanoTime ();
			//doGameLogic
			inputImage = window.getInputImage ();
			GameCode.beforeGameLogic ();
			ObjectHandler.callAll ();
			window.resetInputBuffers ();
			GameCode.afterGameLogic ();
			GameCode.beforeRender ();
			ObjectHandler.renderAll ();
			GameCode.afterRender ();
			window.refresh ();
			gameCodeHasRun = true;
			//Calculate elapsed time and time to sleep for
			lastUpdate = System.nanoTime ();
			long elapsedTime = lastUpdate - startTime;
			int sleepTime = (int)((targetNanoseconds - elapsedTime) / 1000000) - 1;
			if (sleepTime < 0) {
				sleepTime = 0;
			}
			//Wait until the next step should be executed
			while (System.nanoTime () - startTime < targetNanoseconds) {
				
			}
		}
	}
	
	/**
	 * Gets the input image from the start of this game logic iteration.
	 * @return The input image from the start of this iteration
	 */
	public static InputManager getInputImage () {
		return inputImage;
	}
	
	/**
	 * returns the time the current frame started
	 */
	public static long frameStartTime () {
		return startTime;
	}
	/**
	 * Returns true if the game logic has been run at least once; false otherwise
	 */
	public static boolean hasRun () {
		return gameCodeHasRun;
	}
}