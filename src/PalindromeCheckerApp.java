import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

interface PalindromeStrategy {
    boolean check(String str);
}

class StackStrategy implements PalindromeStrategy {
    public boolean check(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : normalized.toCharArray())
            stack.push(c);
        for (char c : normalized.toCharArray())
            if (c != stack.pop())
                return false;
        return true;
    }
}

class DequeStrategy implements PalindromeStrategy {
    public boolean check(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : normalized.toCharArray())
            deque.add(c);
        while (deque.size() > 1)
            if (!deque.pollFirst().equals(deque.pollLast()))
                return false;
        return true;
    }
}

class PalindromeService {
    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String str) {
        return strategy.check(str);
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Palindrome Checker App");
        System.out.println("UC12: Strategy Pattern for Palindrome Algorithms (Advanced)");
        System.out.print("Choose Strategy (1-Stack, 2-Deque): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PalindromeStrategy strategy;
        if (choice == 1)
            strategy = new StackStrategy();
        else
            strategy = new DequeStrategy();

        PalindromeService service = new PalindromeService(strategy);
        boolean result = service.checkPalindrome(input);

        if (result)
            System.out.println("The given string is a palindrome.");
        else
            System.out.println("The given string is not a palindrome.");

        scanner.close();
    }
}