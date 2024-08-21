import java.util.HashMap;
public class Long_substr{
    public static int long_substring(String s){
        HashMap<Character,Integer> mpp = new HashMap<Character,Integer>();

        int left =0;
        int right =0;
        int len =0;
        int n= s.length();

        while(n>right){
            if(mpp.containsKey(s.charAt(right))){
                left = Math.max(mpp.get(s.charAt(right))+1,left);
            }
            mpp.put(s.charAt(right),right);
            len = Math.max(len,right-left+1);
            right++;
           
        }
        return len;
    }
    public static void main(String[] args){
        String s = "bbbbb";
        System.out.println(long_substring(s));
    }
}

// create an hash map of the charater and integer

//take left = right = len = 0

// iterate from right < n

// check if the charater is present in the map 

// if it is the update the left 

// else update the mapp and put the char

// update the len by [right-left+1]

//right ++

//return the len