import java.util.*;
import java.util.stream.Collectors;

public class ikraamWay {

    static ArrayList<String> names = new ArrayList<String>();
    static ArrayList<Integer> count = new ArrayList<Integer>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("Enter the name you want to vote for!");
            String name = input.next();
            if (!names.contains(name)) {
                count.add(name);
            } else {

            }
            System.out.println("Do you want to vote again? ");
            String again = input.next();

            List<String> finalCH = names.stream().distinct().collect(Collectors.toList());

            if (again.startsWith("n")) {
                for (int i = 0; i < finalCH.size(); i++) {
                    System.out.println(finalCH.get(i) + count.get(finalCH.get(i)));
                }
                break;
            } else {
                continue;
            }
        }

    }
}
