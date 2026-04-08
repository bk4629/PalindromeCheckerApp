import java.util.Scanner;

public class PalindromeCheckerApp {

    static boolean method1(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    static boolean method2(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Palindrome Checker App");
        System.out.println("UC: Performance Comparison of Two Methods");
        System.out.print("Enter a string: ");

        String input = sc.nextLine();

        long start1 = System.nanoTime();
        boolean r1 = method1(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean r2 = method2(input);
        long end2 = System.nanoTime();

        System.out.println("Input: " + input);
        System.out.println("Method1 Result: " + r1);
        System.out.println("Method1 Time (ns): " + (end1 - start1));
        System.out.println("Method2 Result: " + r2);
        System.out.println("Method2 Time (ns): " + (end2 - start2));

        sc.close();
    }
}