import java.util.Scanner;
import java.util.InputMismatchException;

/** Reverse Polish notation calculator.
*/
public final class Calc {

    /** Constructor for Calc.
    */
    private Calc() {}
    /** Main class.
        @param args argument vector
    */
    public static void main(String[] args) {
        Stack<Integer> s = new ArrayStack<Integer>();

        Scanner kb = new Scanner(System.in);
        System.out.print("> ");
        int num;
        String operator;

        while (kb.hasNext()) {
            try {
                num = kb.nextInt();
                s.push(num);
            } catch (InputMismatchException i) {
                operator = kb.next();
                if ("+-/*?!.".indexOf(operator) == -1) {
                    System.out.println("?Invalid Input");
                } else if (((ArrayStack<Integer>) s).size() < 2
                    && !("?!.".indexOf(operator) != -1)) {
                    System.out.println("?There are not enough operands");
                } else {
                    doOperation(operator, s);
                }
            }
            System.out.print("> ");
        }
    }

    /** Does the operation on the stack given the operator.
        @param operator what to do with the two operands.
        @param s the stack with the values.
    */
    private static void doOperation(String operator, Stack<Integer> s) {

        int operand1 = 0;
        int operand2 = 0;

        if ("+-/*".indexOf(operator) != -1) {
            operand1 = s.top();
            s.pop();
            operand2 = s.top();
            s.pop();
        }
        if (operator.equals("+")) {
            int result = 0;
            result = operand1 + operand2;
            s.push(result);
        }
        if (operator.equals("-")) {
            int result = 0;
            result = operand2 - operand1;
            s.push(result);
        }
        if (operator.equals("/")) {
            int result = 0;
            result = operand2 / operand1;
            s.push(result);
        }
        if (operator.equals("*")) {
            int result = 0;
            result = operand1 * operand2;
            s.push(result);
        }
        if (operator.equals("?")) {
            System.out.println(s.toString());
        }
        if (operator.equals(".")) {
            processPopOperation(s);
        }
        if (operator.equals("!")) {
            if (!s.empty()) {
                System.out.println(s.toString());
            }
            System.exit(0);
        }
    }
    /** Method to process the pop operation.
        @param s the stack with the values
        @throws EmptyStackException the exception if trying
                                    to pop an empty stack.
    */
    private static void processPopOperation(Stack<Integer> s)
        throws EmptyStackException {
        try {
            System.out.println(s.top());
            s.pop();
        } catch (EmptyStackException empty) {
            System.out.println(
                "?There is nothing in the stack to pop"
            );
        }
    }
}
