/****************************************************************************************************
 * File name: Calculator.java
 * Author: Parth Arora, 040949705, Shubam Verma, 040955165
 * Course: CST8221 - JAP, Lab Section: 302, 301
 * Assignment: Assign 1 P 2
 * Date: 2020 June 26
 * Professor: Sv Ranev, Daniel Cormier
 * Purpose: Main class for the application, this is the starting point of the program
 * Class list: Calculator
 ****************************************************************************************************/

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main class for the application, this is the starting point of the program
 *
 * @author Shubam Verma
 * @version 1.0
 * @see Calculator
 * @since 1.8.0_211
 */
public class Calculator {

  /**
   * Creates a Splash screen and creates JFrame(main container) and adds
   * CalculatorViewController (panel) onto the JFrame.
   *
   * @param args the time duration of the splash screen in milliseconds.
   */
  public static void main(String[] args) {

//Create the screen
    CalculatorSplashScreen splashWindow = new CalculatorSplashScreen(5000);
//Show the Splash screen
    splashWindow.showSplashWindow();
//Create and display the main application GUI
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        JFrame frame = new JFrame("Application Frame");
        JPanel newPanel = new CalculatorViewController();
        frame.add(newPanel);
        frame.setMinimumSize(new Dimension(380, 520));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
      }
    });
  }// end main

}