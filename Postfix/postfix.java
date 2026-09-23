import java.util.Scanner;

class IntStack {

    private int[] stack;
    private int top;

    IntStack(int size) {
        stack = new int[size];
        top = -1;
    }

    public void push(int value) {

        if (top == stack.length - 1) {
            System.out.println("Stack overflow.");
            return;
        }

        stack[++top] = value;
    }

    public int pop() {

        if (top == -1) {
            throw new RuntimeException("Stack is empty.");
        }

        return stack[top--];
    }

    public int peek() {

        if (top == -1) {
            throw new RuntimeException("Stack is empty.");
        }

        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class Postfix {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        IntStack stack = new IntStack(100);

        System.out.print("Enter first number: ");
        int num1 = input.nextInt();

        System.out.print("Enter second number: ");
        int num2 = input.nextInt();

        stack.push(num1);
        stack.push(num2);

        System.out.println("Top value: " + stack.peek());

        int value2 = stack.pop();
        int value1 = stack.pop();

        System.out.println("First value: " + value1);
        System.out.println("Second value: " + value2);

        if (stack.isEmpty()) {
            System.out.println("Stack is empty.");
        }

        input.close();
    }
}