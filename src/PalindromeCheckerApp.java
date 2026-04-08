import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String str) {
        String normalized = str.replaceAll("\\s+", "").toLowerCase();
        int start = 0;
        int end = normalized.length() - 1;

        while (start < end) {
            if (normalized.charAt(start) != normalized.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Palindrome Checker App");
        System.out.println("UC10: Case-Insensitive & Space-Ignored Palindrome");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        if (isPalindrome(input))
            System.out.println("The given string is a palindrome.");
        else
            System.out.println("The given string is not a palindrome.");
        scanner.close();
    }
}