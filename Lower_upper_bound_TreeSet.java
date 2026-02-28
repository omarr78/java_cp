import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);

        int x = 25;
        
        // Find the first element > x
        Integer result = set.higher(x);

        if (result != null) {
            System.out.println("First element greater than " + x + " is: " + result);
        } else {
            System.out.println("No element found greater than " + x);
        }
    }
}

// higher(x)	Returns element > x --- this is upper bound
// ceiling(x)	Returns element >= x --- this is lower bound
