/****************************************************************************************************
 * File name: CalculatorViewController.java
 * Author: Parth Arora, 040949705, Shubam Verma, 040955165
 * Course: CST8221 - JAP, Lab Section: 302, 301
 * Assignment: Assign 1 P 1
 * Date: 2020 June 26
 * Professor: Sv Ranev, Daniel Cormier
 * Purpose: Build a relatively simple GUI for a Calculator Application
 * Class list: CalculatorViewController.java , Controller(private inner class)
 ****************************************************************************************************/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Building a relatively simple and pretty GUI for a Calculator Application
 * using Swing
 *
 * @author  Shubam Verma
 * @version 1.0
 * @see CalculatorViewController
 * @since 1.8.0_211
 *
 */
public class CalculatorViewController extends JPanel {

  /**
   * Swing components are serializable and require serialVersionUID
   */
  private static final long serialVersionUID = 6248477390124803341L;

  // field reference of display 1
  private JTextField display1;

  // field reference of display 2
  private JTextField display2;

  // error label that is used to indicate if an error has occurred in the GUI
  private JLabel error;

  private JPanel errorPanel;
  private JCheckBox checkBox;
  private JRadioButton radButtonDouble;

  // decleration of the dot button that used for decimal calculations in the
  // Calculator
  private JButton dotButton;

  // an array of type String to hold all the keys of the Calculator
  private final String keypad[];

  /**
   * Default Constructor: CalculatorViewController The GUI is built inside this
   * constructor
   *
   */
  public CalculatorViewController() {

    Controller controller = new Controller(); // create action listener object (Controller class)

    /**
     * {@value} string array to hold all button text labels
     */
    keypad = new String[] { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", ".", "0", "\u00B1", "+" };

    // Display1 & Display2 text field
    display1 = new JTextField(14);
    display1.setPreferredSize(new Dimension(display1.getPreferredSize().width, 30));
    display1.setBorder(BorderFactory.createEmptyBorder());
    display1.setHorizontalAlignment(JTextField.RIGHT);
    display1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
    display1.setBackground(Color.WHITE);
    display1.setEditable(false);
    display2 = new JTextField(14);
    display2.setPreferredSize(new Dimension(display2.getPreferredSize().width, 30));
    display2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 3));
    display2.setHorizontalAlignment(JTextField.RIGHT);
    display2.setText("0.0");

    // error label
    error = new JLabel("F");
    error.setPreferredSize(new Dimension(52, 55));
    error.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 5, Color.black));
    error.setFont(new Font(error.getFont().getName(), error.getFont().getStyle(), 20));
    error.setHorizontalAlignment(JLabel.CENTER);
    error.setVerticalAlignment(JLabel.CENTER);


    // backspace button
    JButton backSpace = new JButton("\u21DA");
    backSpace.setBackground(Color.YELLOW);
    backSpace.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 1, Color.BLACK));
    backSpace.addActionListener(controller);
    backSpace.setOpaque(false);
    backSpace.setContentAreaFilled(false);
    backSpace.setToolTipText("Backspace (Alt+B)");
    backSpace.setMnemonic('B');
    backSpace.setPreferredSize(new Dimension(52, 55));
    backSpace.setFont(new Font(backSpace.getFont().getName(), backSpace.getFont().getStyle(), 20));
    backSpace.setActionCommand("\u21DA");

    // equal buttons and clear buttons
    JButton clear1 = createButton("C", "C", Color.BLACK, Color.RED, controller);
    JButton equalButton1 = createButton("=", "=", Color.BLACK, Color.YELLOW, controller);
    JButton clear2 = createButton("C", "C", Color.BLACK, Color.RED, controller);
    JButton equalButton2 = createButton("=", "=", Color.BLACK, Color.YELLOW, controller);
    clear1.setPreferredSize(new Dimension(52, 43));
    clear1.setBorder(BorderFactory.createMatteBorder(4, 1, 0, 5, Color.BLACK));
    clear1.addActionListener(controller);
    equalButton1.setPreferredSize(new Dimension(52, 41));
    equalButton1.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 5, Color.BLACK));
    equalButton1.addActionListener(controller);
    clear2.setPreferredSize(new Dimension(52, 43));
    clear2.setBorder(BorderFactory.createMatteBorder(0, 5, 4, 1, Color.BLACK));
    clear2.addActionListener(controller);
    equalButton2.setPreferredSize(new Dimension(52, 41));
    equalButton2.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 1, Color.BLACK));
    equalButton2.addActionListener(controller);

    // checkBox
    checkBox = new JCheckBox("Int", false);
    checkBox.setBackground(Color.GREEN);
    checkBox.setActionCommand("Int");
    checkBox.addActionListener(controller);
    checkBox.setPreferredSize(new Dimension(47, 0));

    // Radio Buttons (.0, .00, Sci)
    JRadioButton radButtonSingle = new JRadioButton(".0", false);
    radButtonSingle.addActionListener(controller);
    radButtonSingle.setActionCommand("0.");
    JRadioButton radButtonDouble = new JRadioButton(".00", true);
    radButtonDouble.addActionListener(controller);
    radButtonDouble.setActionCommand("00.");
    JRadioButton radButtonSci = new JRadioButton("Sci", false);
    radButtonSci.addActionListener(controller);
    radButtonSci.setActionCommand("Sci");
    radButtonSingle.setBackground(Color.YELLOW);
    radButtonDouble.setBackground(Color.YELLOW);
    radButtonSci.setBackground(Color.YELLOW);

    // button group: add check box and radio buttons in order to establish a mutual
    // relationship between the two types
    ButtonGroup buttonGroup = new ButtonGroup();
    buttonGroup.add(checkBox);
    buttonGroup.add(radButtonSingle);
    buttonGroup.add(radButtonDouble);
    buttonGroup.add(radButtonSci);

    // Decimal and Standard Button
    JButton decimal = createButton("Decimal", "Decimal", Color.BLACK, Color.WHITE, controller);
    JButton standard = createButton("Standard", "Standard", Color.BLACK, Color.WHITE, controller);
    decimal.setPreferredSize(new Dimension(0, 45));
    decimal.setEnabled(false);
    decimal.setOpaque(false);
    standard.setPreferredSize(new Dimension(0, 45));
    standard.setEnabled(false);
    standard.setOpaque(false);

    // Display Panel
    JPanel displayPanel = new JPanel();
    displayPanel.setLayout(new BorderLayout());
    displayPanel.add(display1, BorderLayout.NORTH);
    displayPanel.add(display2, BorderLayout.SOUTH);

    // Error Panel
    errorPanel = new JPanel();
    errorPanel.setLayout(new BorderLayout());
    errorPanel.setBackground(Color.YELLOW);
    errorPanel.add(error);

    // Check Panel
    JPanel checkPanel = new JPanel();
    checkPanel.setLayout(new GridLayout(1, 1));
    checkPanel.setBorder(BorderFactory.createMatteBorder(8, 0, 8, 0, Color.BLACK));
    checkPanel.add(checkBox, BorderLayout.CENTER);

    // Radio Panel
    JPanel radioPanel = new JPanel();
    radioPanel.setLayout(new GridLayout(1, 3));
    radioPanel.setBorder(BorderFactory.createMatteBorder(8, 0, 8, 0, Color.BLACK));
    radioPanel.setBackground(Color.YELLOW);
    radioPanel.setBounds(222, 8, 140, 23);
    radioPanel.add(radButtonSingle);
    radioPanel.add(radButtonDouble);
    radioPanel.add(radButtonSci);

    // Mode Panel
    JPanel modePanel = new JPanel();
    modePanel.setLayout(new BorderLayout());
    modePanel.setPreferredSize(new Dimension(80, 40));
    modePanel.setBackground(Color.BLACK);
    modePanel.add(checkPanel, BorderLayout.WEST);
    modePanel.add(radioPanel, BorderLayout.EAST);

    // Keypad Panel
    JPanel keypadPanel = new JPanel();
    keypadPanel.setLayout(new GridLayout(4, 3));
    keypadPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));

    // Middle Panel
    JPanel middlePanel = new JPanel();
    middlePanel.setLayout(new BorderLayout());
    middlePanel.add(keypadPanel, BorderLayout.CENTER);
    middlePanel.add(decimal, BorderLayout.NORTH);
    middlePanel.add(standard, BorderLayout.SOUTH);

    // Top Panel
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new BorderLayout());
    topPanel.setBackground(Color.YELLOW);
    topPanel.add(errorPanel, BorderLayout.WEST);
    topPanel.add(displayPanel, BorderLayout.CENTER);
    topPanel.add(modePanel, BorderLayout.SOUTH);
    topPanel.add(backSpace, BorderLayout.EAST);

    // Side Panels
    JPanel sidePanel1 = new JPanel();
    sidePanel1.setLayout(new GridLayout(2, 1));
    sidePanel1.setBackground(Color.BLACK);
    sidePanel1.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
    sidePanel1.add(equalButton1, BorderLayout.NORTH);
    sidePanel1.add(clear1);

    JPanel sidePanel2 = new JPanel();
    sidePanel2.setLayout(new GridLayout(2, 1));
    sidePanel2.setBackground(Color.BLACK);
    sidePanel2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
    sidePanel2.add(clear2, BorderLayout.NORTH);
    sidePanel2.add(equalButton2, BorderLayout.SOUTH);

    // Class Panel
    setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
    setLayout(new BorderLayout());
    setBackground(Color.YELLOW);
    add(middlePanel, BorderLayout.CENTER);
    add(topPanel, BorderLayout.NORTH);
    add(sidePanel1, BorderLayout.WEST);
    add(sidePanel2, BorderLayout.EAST);


    // a variable to hold all the buttons created for the number pad using the
    // createButton function
    JButton key = null;

    // a loop for creating a group of related buttons with the same basic
    // properties but different function
    for (int i = 0; i < keypad.length; i++) {

      if (i == 3) {
        key = createButton(keypad[i], keypad[i], Color.BLACK, Color.CYAN, controller);
      } else if (i == 7) {
        key = createButton(keypad[i], keypad[i], Color.BLACK, Color.CYAN, controller);
      } else if (i == 11) {
        key = createButton(keypad[i], keypad[i], Color.BLACK, Color.CYAN, controller);
      } else if (i == 12) {
        key = dotButton =
              createButton(keypad[i], keypad[i], Color.BLACK, Color.MAGENTA, controller);
      } else if (i == 14) {
        key = createButton(keypad[i], keypad[i], Color.BLACK, Color.MAGENTA, controller);
      } else if (i == 15) {
        key = createButton(keypad[i], keypad[i], Color.BLACK, Color.CYAN, controller);
      } else {
        key = createButton(keypad[i], keypad[i], Color.BLACK, Color.BLUE, controller);
      }

      key.setBorder(BorderFactory.createLineBorder(Color.WHITE));

      keypadPanel.add(key);
    }
  }

  /**
   * To create of group of related buttons with the same basic properties
   * mentioned in the parameters
   *
   * @param text:    text on the button
   * @param ac:      action command string of the button
   * @param fg:      button's foreground color
   * @param bg:      button's background color
   * @param handler: reference to an instance of the event handler private inner
   *                 class(Controller)
   * @return an instance of JButton
   */
  private JButton createButton(String text, String ac, Color fg, Color bg, ActionListener handler) {
    JButton newButton = new JButton(text);
    newButton.setBackground(bg);
    newButton.setForeground(fg);
    newButton.setFont(new Font(newButton.getFont().getName(), newButton.getFont().getStyle(), 20));
    if (ac != null)
      newButton.setActionCommand(ac);
    newButton.addActionListener(handler);
    return newButton;
  }

  /**
   * This class is responsible for handling all the events generated by the GUI.
   * 
   * @author Kevin Lai
   * @version 1.0
   * @see Controller
   * @since 1.8.0_181
   */
  private class Controller implements ActionListener {

    CalculatorModel cModel = new CalculatorModel();
    boolean operand1 = false;
    boolean operand2 = false;
    boolean arithmetic = false;
    boolean aritmetic2 = false;
    boolean backSpace = false;
    boolean checkBoxSelected = false; // used for the bonus to uncheck int check box
    boolean end = false;
    String tempDisplay1 = new String("");
    String op1 = new String("");
    String op2 = new String("");

    @Override
    public void actionPerformed(ActionEvent e) {

      String command = e.getActionCommand();

      // switch case that checks for operational mode int and floats(.0 .00 Sci)
      switch (command) {
        case "Int":
          error.setText("I");
          errorPanel.setBackground(Color.GREEN);
          dotButton.setBackground(new Color(178, 156, 250));
          dotButton.setEnabled(false);
          cModel.setOMode(command);
          if (checkBox.isSelected() && checkBoxSelected == true) {
            command = "00.";
            checkBoxSelected = false;
            radButtonDouble.doClick();
          }
          break;
        case "0.":
        case "00.":
        case "Sci":
          checkBoxSelected = false;
          error.setText("F");
          errorPanel.setBackground(Color.YELLOW);
          dotButton.setEnabled(true);
          cModel.setOMode("Float");
          cModel.setFloatingPrecision(command);
          break;
      }

      // clear and reset all values to default if any of these cases
      switch (command) {
        case "Int":
        	if(checkBoxSelected == true) {
        		checkBoxSelected = false;	
        	}
        	else {
        		checkBoxSelected = true;
        	}
          
        case "0.":
        case "00.":
        case "Sci":
        case "C":
          operand1 = false;
          operand2 = false;
          arithmetic = false;
          aritmetic2 = false;
          backSpace = false;
          end = false;
          cModel.setOperand1(op1 = "");
          cModel.setOperand2(op2 = "");
          cModel.setArithmetic("");
          display1.setText("");
          tempDisplay1 = "";
          cModel.setErrorState(false);

          switch (cModel.getOMode()) {
            case "Int":
              display2.setText("0");
              error.setText("I");
              errorPanel.setBackground(Color.GREEN);
              break;
            case "Float":
              display2.setText("0.0");
              error.setText("F");
              errorPanel.setBackground(Color.YELLOW);
              break;
          }
          return;
      }

      // only execute this statement if error state is false (keeps us from clicking any numbers or
      // arithmetic if there is a error)
      if (!cModel.getErrorState()) {

        switch (command) {
          case "=":
            if (arithmetic) {
              if (!operand2) {
                cModel.setOperand2(op1);
				 op1 = cModel.getResult(); 
              } else {
                cModel.setOperand1(op1);
                display1.setText("");
                display2.setText(op1);
                backSpace = true;
                end = true;
                arithmetic = false;
                tempDisplay1 = "";
              }
            } else if (!operand2 && !end) {
              display2.setText(op1);
            }
            // case if we hit equal again
            else {
              display2.setText(op1 = cModel.getResult());
              cModel.setOperand1(op1);
              end = true;
            }
                       
            if(display2.getText().length()>23) {
              display2.setText("Result is too long to display");
            }
            if(display2.getText().equals("NaN")) {
            	error.setText("E");
                errorPanel.setBackground(Color.RED);
                display2.setText("Result is undefined");
                cModel.setErrorState(true);
              }
            if(display2.getText().equals("Infinity")) {
                error.setText("E");
                errorPanel.setBackground(Color.RED);
                display2.setText("Cannot divide by zero");
                cModel.setErrorState(true);
              }
            
            break;
          case "\u21DA":

            if (!arithmetic) {
              if (!backSpace) {
                if (op1.length() > 0) {
                  // if we have a negative and 1 number e.g. -5 and we try to backspace
                  if (op1.charAt(0) == '-' && op1.length() == 2)
                    op1 = "";
                  else
                    op1 = op1.substring(0, op1.length() - 1);

                  cModel.setOperand1(op1);

                  // check operation mode so we can set display for float or integer
                  if (op1.equals("")) {
                    switch (cModel.getOMode()) {
                      case "Int":
                        display2.setText("0");
                        break;
                      case "Float":
                        display2.setText("0.0");
                        break;
                    }
                  } else
                    display2.setText(op1);
                }
              }
            } else {
              if (!backSpace) {
                if (op2.length() > 0) {
                  // if we have a negative and 1 number e.g. -5 and we try to backspace
                  if (op2.charAt(0) == '-' && op2.length() == 2)
                    op2 = "";
                  else
                    op2 = op2.substring(0, op2.length() - 1);

                  cModel.setOperand1(op2);
                  // check operation mode so we can set display for float or integer
                  if (op2.equals("")) {
                    switch (cModel.getOMode()) {
                      case "Int":
                        display2.setText("0");
                        break;
                      case "Float":
                        display2.setText("0.0");
                        break;
                    }
                  } else
                    display2.setText(op2);
                }
              }
            }
            break;
         case "+":
          case "-":
          case "*":
          case "/":
            if (!arithmetic) {
              if (operand1) {

                cModel.setOperand2(op2 = "");
                cModel.setArithmetic(command);
                tempDisplay1 += op1 + command;
                display1.setText(tempDisplay1);
                arithmetic = true;
              }
            } else {
              // case of operand 2 not being set yet
              if (!operand2) {
                cModel.setArithmetic(command);
                tempDisplay1 = tempDisplay1.substring(0, tempDisplay1.length() - 1);
                tempDisplay1 += command;
                display1.setText(tempDisplay1);
              }
              // case where we want to chain arithmetic e.g. 5*6/2
              if (!aritmetic2 && operand2) {
                tempDisplay1 = tempDisplay1 + op2 + command;
                display1.setText(tempDisplay1);

                op1 = cModel.getResult();

                // check for case of NaN and sets error state to true
                if (display2.getText().equals("NaN")) {
                  error.setText("E");
                  errorPanel.setBackground(Color.RED);
                  display2.setText("Result is undefined");
                  cModel.setErrorState(true);
                }
                // check for case of Infinity and sets error state to true
                else if (display2.getText().equals("Infinity")) {
                  error.setText("E");
                  errorPanel.setBackground(Color.RED);
                  display2.setText("Cannot divide by zero");
                  cModel.setErrorState(true);
                } else {
                  cModel.setOperand1(op1);
                  cModel.setArithmetic(command);
                  cModel.setOperand2(op2 = "");
                  operand2 = false;
                  display2.setText(op1);
                  aritmetic2 = true;
                }
              }
            }
            break;
          case "\u00B1":
            // sets negative number for operand 1 or if it is a negative then we make it positive
            if (!arithmetic) {
              if (op1.length() > 0) {

                if (op1.charAt(0) != '-')
                  display2.setText(op1 = "-" + op1);
                else
                  display2.setText(op1 = op1.substring(1, op1.length()));
              }
              cModel.setOperand1(op1);
              // sets negative number for operand 2 or if it is a negative then we make it positive
            } else {
              if (op2.length() > 0) {

                if (op2.charAt(0) != '-')
                  display2.setText(op2 = "-" + op2);
                else
                  display2.setText(op2 = op2.substring(1, op2.length()));
              }
              cModel.setOperand2(op2);
            }
            break;
          case ".":
            // sets . for operand 1
            if (!arithmetic) {
              // checks to see if operand 1 contains a . already
              if (!op1.contains("."))
                display2.setText(op1 += command);
            }
            // sets . for operand 2
            else {
              // checks to see if operand 2 contains a . already
              if (!op2.contains("."))
                display2.setText(op2 += command);
            }
            break;
          default:

            if (!arithmetic) {
              backSpace = false;
              if (end) {
                end = false;
                operand1 = true;
                cModel.setOperand1(op1 = command);
              } else {
                operand1 = true;
                cModel.setOperand1(op1 += command); // sets state for operand 1 by calling
                                                    // setOperand1 in CalculatorModel class
              }
              if(op1.length() >= 23)
               op1 = op1.substring(0, 23);
              display2.setText(op1);
            } else {
              backSpace = false;
              operand2 = true;
              cModel.setOperand2(op2 += command); // sets state for operand 2 by calling setOperand1
                                                  // in CalculatorModel class
              if(op2.length() >= 23)
                op2 = op2.substring(0, 23);
               display2.setText(op2);
              aritmetic2 = false;
              break;
            }
            break;
        }
      }
    }// end method ActionPerformed
  }
}
