import java.util.Scanner;

public class Solution extends Book{

    void setTitle(String value){
        this.title = value;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        solution.setTitle(input);

        System.out.println("The title is: " + solution.getTitle());
    }
}
