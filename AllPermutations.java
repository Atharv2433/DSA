import java.util.ArrayList;
import java.util.List;

public class AllPermutations {

    // Function to generate all permutations
    public static void generate(int nums[], List<Integer> ds, List<List<Integer>> ans, boolean freq[]) {
        if (ds.size() == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {  // If the element has not been used
                freq[i] = true;
                ds.add(nums[i]);
                generate(nums, ds, ans, freq);
                ds.remove(ds.size() - 1);  // Backtrack
                freq[i] = false;  // Mark the element as not used
            }
        }
    }

    // Function to return all permutations of the array
    public static List<List<Integer>> all_permutations(int nums[]) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];  // Boolean array to track used elements
        if (nums.length == 0) {
            return ans;
        }
        generate(nums, ds, ans, freq);
        
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        List<List<Integer>> ans = all_permutations(nums);

        // Print all permutations
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
