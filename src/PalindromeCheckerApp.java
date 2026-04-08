import java.util.Scanner;

class PalindromeChecker {

    public boolean checkPalindrome(String str) {
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
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Palindrome Checker App");
        System.out.println("UC11: Object-Oriented Palindrome Service");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(input);

        if (result)
            System.out.println("The given string is a palindrome.");
        else
            System.out.println("The given string is not a palindrome.");

        scanner.close();
    }
}