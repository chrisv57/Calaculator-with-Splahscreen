/****************************************************************************************************
 * File name: CalculatorModel.java
 * Author: Kevin Lai, 040812704
 * Course: CST8221 - JAP, Lab Section: 302
 * Assignment: 1 part 2
 * Date: 2018 November 06
 * Professor: Daniel Cormier
 * Purpose: Holds the state of the operands and arithmetic and deals with all the calculations
 *          of the calculator GUI
 ****************************************************************************************************/



/**
 * 
 * Holds the state of the operands and arithmetic and deals with all the calculations of the
 * calculator GUI
 * 
 * @author Kevin Lai
 * @version 1.0
 * @see CalculatorModel
 * @since 1.8.0_181
 *
 */
public class CalculatorModel {

  private String op1 = "", op2 = "", oMode = "Float", arithmetic = "", precision = "00.",
      result = "";
  private boolean errorState = false;


  /**
   * Method sets the state of operand 1
   * 
   * @param a string to assign to op1 (state of operand 1)
   */
  void setOperand1(String a) {
    op1 = new String(a);
  }

  /**
   * Method sets the state of operand 2
   * 
   * @param a string to assign to op2 (state of operand 1)
   */
  void setOperand2(String a) {
    op2 = new String(a);
  }

  /**
   * Method sets the state of operational mode(int or float)
   * 
   * @param Op string to assign to oMode (state of operational mode)
   */
  void setOMode(String Op) {
    oMode = Op;
  }

  /**
   * Method that gets the state of operational mode(int or float)
   * 
   * @return oMode gets the state of oMode
   */
  String getOMode() {
    return oMode;
  }

  /**
   * Method sets the state of arithmetic
   * 
   * @param arithmetic string to assign to arithmetic (state of arithmetic)
   */
  void setArithmetic(String arithmetic) {
    this.arithmetic = arithmetic;
  }

  /**
   * Method sets the state of precision for floating point(.0 , .00 , Sci)
   * 
   * @param precision string to assign to precision (state of precision)
   */
  void setFloatingPrecision(String precision) {
    this.precision = precision;
  }

  /**
   * Method gets result from calculation method
   * 
   * @return result gets the result that is calculated from calculation method.
   * @see #calculate()
   */
  String getResult() {
    calculate();
    return result;
  }

  /**
   * Method sets the state of errorState (true or false)
   * 
   * @param state boolean to assign to errorState(true or false)
   */
  void setErrorState(boolean state) {
    errorState = state;
  }

  /**
   * Method gets the error state (true or false)
   * 
   * @return gets the error state (true or false)
   */
  Boolean getErrorState() {
    return errorState;
  }

  /**
   * Method calculates based on operation mode int or float, parses the string depending on mode and
   * does calculations depending on the arithmetic and then stores it back into a string called
   * result. if it is a floating type number then it will set precision and format it to the correct
   * decimal places depending on the precision.
   * 
   */
  private void calculate() {
    float tempNum = 0.0f;
    switch (oMode) {
      case "Int":
        switch (arithmetic) {
          case "+":
            result = Integer.toString(Integer.parseInt(op1) + Integer.parseInt(op2));
            break;
          case "-":
            result = Integer.toString(Integer.parseInt(op1) - Integer.parseInt(op2));
            break;
          case "/":
            if (op1.equals("0") && op2.equals("0"))
              result = "NaN";
            else if (op2.equals("0"))
              result = "Infinity";
            else
              result = Integer.toString((Integer.parseInt(op1) / Integer.parseInt(op2)));
            break;
          case "*":
            result = Integer.toString(Integer.parseInt(op1) * Integer.parseInt(op2));
            break;
        }
        break;

      default:
        switch (arithmetic) {
          case "+":
            tempNum = (Float.parseFloat(op1) + Float.parseFloat(op2));
            break;
          case "-":
            tempNum = (Float.parseFloat(op1) - Float.parseFloat(op2));
            break;
          case "*":
            tempNum = (Float.parseFloat(op1) * Float.parseFloat(op2));
            break;
          case "/":
            tempNum = (Float.parseFloat(op1) / Float.parseFloat(op2));
            break;
        }

        switch (precision) {
          case "0.":
            result = String.format("%.1f", tempNum);
            break;
          case "00.":
            result = String.format("%.2f", tempNum);
            break;
          case "Sci":
            result = String.format("%.6e", tempNum);
            break;
        }
        break;
    }
  }
}