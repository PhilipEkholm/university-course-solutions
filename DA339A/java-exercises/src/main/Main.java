package main;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import gu2.PaintWindow_GU2;
import guesstheflag.FlagController;
import guesstheflag.FlagModel;
import guesstheflag.FlagView;

public class Main
{
	public static PaintWindow_GU2 theGui;
	Icon blackjagIMG;
	Icon guessTheFlagIMG;
	Icon gissaTalIMG;
	Icon team1IMG;
	Icon quitAppIMG;
	
	public Main()
	{
		theGui.setBackground(Color.DARK_GRAY, 800, 600);
		blackjagIMG = new ImageIcon("images/blackjack_firstpic.png");
		guessTheFlagIMG = new ImageIcon("images/guesstheflag_firstpic.jpg");
		gissaTalIMG = new ImageIcon("images/Gissatal_firstpic.jpg");
		team1IMG = new ImageIcon("images/team1_firstpic.png");
		quitAppIMG = new ImageIcon("images/Quit_Button_Main.png");
		
		theGui.addIcon(blackjagIMG, 0, 0, true);
		theGui.addIcon(guessTheFlagIMG, 400, 0, true);
		theGui.addIcon(gissaTalIMG, 0, 300, true);
		theGui.addIcon(team1IMG, 400, 300, true);
		theGui.addIcon(quitAppIMG, 695, 555, true); 
		
		theGui.setIconAction(blackjagIMG, this, "startBlackJack");
		theGui.setIconAction(guessTheFlagIMG, this, "startGuessTheFlag");
		theGui.setIconAction(gissaTalIMG, this, "startGissaTal");
		theGui.setIconAction(quitAppIMG, this, "quit_App");
	}
	
	
	public void startBlackJack()
	{
		theGui.clearAll();
		theGui.setBackground(new Color(12, 66, 7), 800, 600);
		new blackjack.BlackJackGUI(theGui);
	}
	public void startGuessTheFlag()
	{
		theGui.clearAll();
		theGui.setBackground(Color.WHITE, 800, 600);
		new guesstheflag.GuessTheFlag(theGui);
	}

	public void startGissaTal()
	{
		theGui.clearAll();
		theGui.setBackground(Color.WHITE, 800, 600);
		new GissaTal.KorGissaTal(theGui);
		
	}
	public void quit_App()
	{
		System.exit(0);
	}
	
	
	public static void main(String[] args)
	{
		theGui = new PaintWindow_GU2(800, 600, "Team 1", Color.DARK_GRAY);
		new Main();
	}

}
