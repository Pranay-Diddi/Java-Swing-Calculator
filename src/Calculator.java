import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Calculator implements ActionListener {
    JFrame f;
    JButton b0, b14, b15;
    JTextField tf;
    boolean isCalculated;

    Calculator() {
        createGui();
    }

    public void createGui() {
        f = new JFrame("Calculator");

        JPanel p = new JPanel();

        tf = new JTextField(30);
        f.add(tf, BorderLayout.NORTH);

        p.setLayout(new GridLayout(4, 4, 10, 10));

        b0 = new JButton("0");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");

        JButton b10 = new JButton("+");
        JButton b11 = new JButton("-");
        JButton b12 = new JButton("*");
        JButton b13 = new JButton("/");
        b14 = new JButton("=");
        b15 = new JButton("C");

        p.add(b0);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(b10);
        p.add(b11);
        p.add(b12);
        p.add(b13);
        p.add(b14);
        p.add(b15);

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);

        f.add(p, BorderLayout.CENTER);
        f.setSize(300, 400);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) throws Exception {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b14) {
            String res = evaluate(tf.getText());
            tf.setText(res);
            isCalculated = true;
        } else if (e.getSource() == b15) {
            tf.setText("");
            isCalculated = false;
        } else {
            if (isCalculated) {
                tf.setText("");
                isCalculated = false;
            }
            tf.setText(tf.getText() + ((JButton) e.getSource()).getText());

        }
    }

    public static String evaluate(String eqn) {
        Stack<Integer> nums = new Stack<>();
        Stack<Character> oprns = new Stack<>();
        int n = eqn.length();
        int curr = 0;

        for (int i = 0; i < n; i++) {
            char ch = eqn.charAt(i);

            if (Character.isDigit(ch)) {
                curr = curr * 10 + (ch - '0');
            } else {
                nums.push(curr);
                curr = 0;

                while (!oprns.isEmpty() && precedence(ch) <= precedence(oprns.peek())) {
                    int b = nums.pop();
                    int a = nums.pop();

                    char op = oprns.pop();
                    nums.push(eval(a, b, op));
                }

                oprns.push(ch);
            }
        }
        nums.push(curr);

        while (!oprns.isEmpty()) {
            int b = nums.pop();
            int a = nums.pop();
            char op = oprns.pop();
            nums.push(eval(a, b, op));
        }
        return String.valueOf(nums.pop());
    }

    public static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }

    public static int eval(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    // tf.setText("Error");
                    throw new ArithmeticException("Cant divide by zero");
                }
                return a / b;

        }
        return 0;
    }
}
