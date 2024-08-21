# Java Swing Calculator

This is a simple calculator application built using Java Swing for the graphical user interface (GUI). The calculator performs basic arithmetic operations like addition, subtraction, multiplication, and division.

## Features

- **Basic Arithmetic Operations**: Supports addition, subtraction, multiplication, and division.
- **Clear Function**: Allows the user to clear the input field.
- **Responsive Input Field**: Automatically updates the input field based on button clicks.
- **Order of Operations**: Evaluates expressions according to the precedence of operators.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Pranay-Diddi/Java-Swing-Calculator.git
2. Navigate to the project directory:
    cd Java-Swing-Calculator
3. Compile the program:
    javac Calculator.java
4. Run the program:
    java Calculator

Usage:

1. Start the calculator by running the Calculator class.
2. Use the number buttons (0-9) to enter numbers.
3. Use the operator buttons (+, -, *, /) to perform operations.
4. Press '=' to evaluate the expression.
5. Press 'C' to clear the input field.

Code Overview:

The calculator functionality is implemented in the Calculator class, which contains the following methods:

1. createGui(): Sets up the GUI components using Java Swing.
2. actionPerformed(ActionEvent e): Handles button click events and updates the display or performs calculations.
3. evaluate(String eqn): Evaluates the arithmetic expression entered by the user.
4. precedence(char op): Determines the precedence of arithmetic operators.
5. eval(int a, int b, char op): Performs the calculation based on the operator.

   

Output:

![Screenshot 2024-08-21 182935](https://github.com/user-attachments/assets/eb9901b8-0508-4a87-9087-d484cbbc2539)
![Screenshot 2024-08-21 182952](https://github.com/user-attachments/assets/e9bacd16-ad77-40c0-b59c-705db98a65cf)
![Screenshot 2024-08-21 183019](https://github.com/user-attachments/assets/d2de3587-ca26-4ed9-8368-5e13e84f0b11)
![Screenshot 2024-08-21 183033](https://github.com/user-attachments/assets/c713da85-4815-48cd-8368-6f721baa5239)
![Screenshot 2024-08-21 183316](https://github.com/user-attachments/assets/2626560f-0ca7-4d98-bdcb-b187f0d260dd)
![Screenshot 2024-08-21 183339](https://github.com/user-attachments/assets/981790bd-d6f5-4294-871f-7e1bee1c9a76)






