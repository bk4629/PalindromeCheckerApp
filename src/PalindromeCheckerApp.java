import java.util.*;

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string for Queue+Stack check: ");
        String input = scanner.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }

        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome?: " + isPalindrome);
        scanner.close();
    }
}