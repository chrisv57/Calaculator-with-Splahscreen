/*/****************************************************************************************************
 * File name: CalculatorSplashScreen.java
 * Author: Kevin Lai, 040812704
 * Course: CST8221 - JAP, Lab Section: 302
 * Assignment: 1 part 2
 * Date: 2018 November 06
 * Professor: Daniel Cormier
 * Purpose: Creates a splash screen for our Calculator GUI application.
 ****************************************************************************************************/

import java.awt.*;
import javax.swing.*;

/**
 * Creates a splash screen for our Calculator GUI application.
 * 
 * @author Kevin Lai
 * @version 1.0
 * @see CalculatorSplashScreen
 * @since 1.8.0_181
 */
/*public class CalculatorSplashScreen {

  /*JFrame frame;
  JLabel label = new JLabel(new ImageIcon(getClass().getResource("coding.gif")));
  JLabel text = new JLabel("TUTORIALS FIELD");
  JLabel studentId = new JLabel("Parth Arora, 040949704", JLabel.LEFT);
  JProgressBar progressBar = new JProgressBar();
  JLabel message = new JLabel();// Creating a JLabel for displaying the message

  /**
   * Default Constructor for CalculatorSplashScreen, all of the Splash screen is created in here by
   * calling methods.
   * 
   */
  /*public CalculatorSplashScreen() {
    createGUI();
    addImage();
    addText();
    addProgressBar();
    addMessage();
    runningPBar();
  }

  /**
   * Creating the JFrame and setting the sizes and visibility.
   * 
   */
  /*public void createGUI() {
    frame = new JFrame();
    frame.getContentPane().setLayout(null);
    frame.setUndecorated(true);
    frame.setSize(600, 400);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().setBackground(Color.BLACK);
    frame.setVisible(true);

  }

  /**
   * Setting size for the image and add label to the JFrame.
   * 
   */
  /*public void addImage() {
    label.setSize(600, 310);
    frame.add(label);
  }

  /**
   * Setting text in the lower left corner of the JFrame for my name and student id
   * 
   */
  /*public void addText() {
    studentId.setFont(new Font("georgia", Font.BOLD, 17));
    studentId.setBounds(10, 360, 400, 40);
    studentId.setForeground(Color.WHITE);
    frame.add(text);
    frame.add(studentId);
  }

  /**
   * Creating message for the progress bar and setting location for it.
   * 
   */
  /*public void addMessage() {
    message.setBounds(250, 350, 200, 40);// Setting the size and location of
                                         // the label
    message.setForeground(Color.WHITE);// Setting foreground Color
    message.setFont(new Font("georgia", Font.BOLD, 12));// Setting font
                                                        // properties
    frame.add(message);// adding label to the frame
  }

  /**
   * Create progress bar for splash screen.
   * 
   */
  /*public void addProgressBar() {
    progressBar.setBounds(150, 320, 300, 20);
    progressBar.setBorderPainted(true);
    progressBar.setStringPainted(true);
    progressBar.setBackground(Color.WHITE);
    progressBar.setForeground(Color.BLACK);
    progressBar.setValue(0);
    frame.add(progressBar);
  }*/

  /**
   * Running the progress bar, depending on how much has loaded there is a different message
   * displayed.
   * 
   */
  /*public void runningPBar() {
    int i = 0;// Creating an integer variable and intializing it to 0

    while (i <= 100) {
      try {
        Thread.sleep(50);// Pausing execution for 50 milliseconds
        progressBar.setValue(i);// Setting value of Progress Bar
        message.setText("LOADING " + Integer.toString(i) + "%");
        i++;
        if (i >= 25)
          message.setText("LOADING... 25" + Integer.toString(i) + "%");
        if (i > 25 || i <= 50)
            message.setText("LOADING... 50" + Integer.toString(i) + "%");
        if (i > 50 || i <= 75)
            message.setText("LOADING... 75" + Integer.toString(i) + "%");
        if (i > 75 || i <= 99)
            message.setText("LOADING... 99" + Integer.toString(i) + "%");
        if (i == 100)
          frame.dispose();
      } catch (Exception e) {
        e.printStackTrace();
      }

    }
  }
}*/

/*************************************************************************************************************************
 * File name: CalculatorSplashScreen.java
 * Author: Parth Arora, 040949705, Shubam Verma, 040955165
 * Course: CST8221 - JAP, Lab Section: 302, 301
 * Assignment: Assign 1 P 1
 * Date: 2020 June 26
 * Professor: Sv Ranev, Daniel Cormier
 * Purpose: Creating a Splash Screen that is displayed before displaying the main application, Calculator GUI.
 * Class list: CalculatorSplashScreen
 ************************************************************************************************************************/

/**
 * Creating a Splash Screen before displaying the Calculator GUI.
 *
 * @author Parth Arora, Shubam Verma
 * @version 1.0
 * @see CalculatorSplashScreen
 * @since 1.8.0_211
 */

import java.awt.*;
import java.net.URL;
import javax.swing.*;

/**
 * A simple class demonstrating how to create a splash screen for an application
 * using JWindow as a container. The splash screen will appear on the screen for
 * the duration given to the constructor. The class includes a main() method for
 * testing purposes. Normally, this class should be used by the main() of an
 * application. Note: Since JWindow uses a default frame when made visible it
 * does not receives events. If you want to process events using JWindow, you
 * must create an undecorated frame and attach JWindow to this frame using an
 * appropriate JWindow constructor.
 *
 * @version 1.20.3
 * @author Shubam Verma
 * @since 1.8.0_211
 */
public class CalculatorSplashScreen extends JWindow {
  /** Swing components are serializable and require serialVersionUID */
  private static final long serialVersionUID = 6248477390124803341L;
  /** Splash screen duration */
  private  int duration = 5000;

  JFrame frame;
  JProgressBar progressBar = new JProgressBar();

  public CalculatorSplashScreen()
  {
    addProgressBar();
  }

  /**
   * Default constructor. Sets the show time of the splash screen.
   */
  public CalculatorSplashScreen(int duration) {
    //addProgressBar();
    this.duration = duration;
  }

  public void createGUI() {
    frame = new JFrame();
    frame.getContentPane().setLayout(null);
    frame.setUndecorated(true);
    frame.setSize(600, 400);
    frame.setLocationRelativeTo(null);
    frame.getContentPane().setBackground(Color.BLACK);
    frame.setVisible(true);

  }

  public void addProgressBar() {
    progressBar.setBounds(150, 320, 300, 20);
    progressBar.setBorderPainted(true);
    progressBar.setStringPainted(true);
    progressBar.setBackground(Color.WHITE);
    progressBar.setForeground(Color.BLACK);
    progressBar.setValue(0);
    frame.add(progressBar);
  }

  /**
   * Shows a splash screen in the center of the desktop for the amount of time
   * given in the constructor.
   */
  public void showSplashWindow() {

    // create content pane

    JPanel content = new JPanel(new BorderLayout());


    // or use the window content pane
    content.setBackground(Color.BLACK);

    Color customColor = new Color(0, 174, 0);

    // Set the window's bounds, position the window in the center of the screen
    int width = 543 + 5;
    int height = 305 + 5;
    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (screen.width - width) / 2;
    int y = (screen.height - height) / 2;

    // set the location and the size of the window
    setBounds(x, y, width, height);

    JLabel label = new JLabel(new ImageIcon(getClass().getResource("coding.gif")));

    JLabel message = new JLabel("Shubam Verma ", JLabel.CENTER);
    message.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
    message.setForeground(Color.WHITE);
    content.add(label, BorderLayout.CENTER);
    content.add(message, BorderLayout.SOUTH);

		/*progressBar.setBounds(150, 320, 300, 20);
	    progressBar.setBorderPainted(true);
	    progressBar.setStringPainted(true);
	    progressBar.setBackground(Color.WHITE);
	    progressBar.setForeground(Color.BLACK);
	    progressBar.setValue(0);
	    frame.add(progressBar);*/

    // create custom RGB color
    content.setBorder(BorderFactory.createLineBorder(customColor, 5));

    // replace the window content pane with the content JPanel
    setContentPane(content);

    // make the splash window visible
    setVisible(true);

    // Wait a little while doing nothing, while the application is loading
    try {

      Thread.sleep(duration);
    } catch (InterruptedException e) {
      System.out.println("Error");
    }

    // destroy the window and release all resources
    dispose();
  }
}// end CalculatorSplashScreen class
