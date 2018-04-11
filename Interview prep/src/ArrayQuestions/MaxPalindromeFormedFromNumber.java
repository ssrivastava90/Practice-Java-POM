package ArrayQuestions;

import java.util.Arrays;
import java.util.HashMap;

//https://www.geeksforgeeks.org/largest-palindromic-number-permuting-digits/

public class MaxPalindromeFormedFromNumber {

    HashMap<Integer,Integer> hm;

    public static void main(String[] args) {
        String inp = "9999313566651";
        MaxPalindromeFormedFromNumber maxPalindromeFormedFromNumber = new MaxPalindromeFormedFromNumber();
        Results results = maxPalindromeFormedFromNumber.checkPalindromePossible(inp);

        if (results.equals(Results.NotPossible)){
            System.out.println("Palindrome cannot be formed");
        }else{
            System.out.println(maxPalindromeFormedFromNumber.createMaxPalindrome(inp,results));
        }

    }

    public enum Results {
        PossibleE,
        PossibleO,
        NotPossible;
    }

    private Results checkPalindromePossible(String inp){

        hm = new HashMap<Integer, Integer>();
        for (char c:inp.toCharArray()){
            Integer ke = Character.getNumericValue(c);
            if (!hm.containsKey(ke)) {
//                System.out.println(c + " not found");
                hm.put(ke, 1);
            }else{
                hm.put(ke,(hm.get(ke)+1));
//                System.out.println(hm.get((int)c) + "  found");
            }
        }

        int o=0;
        for(int i:hm.values()){
            if(i%2!=0){
                o++;
            }
        }

        //
        if(o==0){
            return Results.PossibleE;
        }else if(o==1){
            return  Results.PossibleO;
        }else{
            return Results.NotPossible;
        }
    }



    private String createMaxPalindrome(String num, Results res){
        int arr[] = new int[num.length()];
        int start = 0;
        int end = num.length()-1;



        if (res.equals(Results.PossibleE)){
            System.out.println("IN POSSIBLE E");
            for (int i=9;i>=0;i--){
//                System.out.println(hm.containsKey(i) + " not found");
                if (hm.containsKey(i)){
                    for(int k= hm.get(i);k>0;k--) {
//                        System.out.println("i");
                        arr[start] = i;
                        arr[end] = i;
                        start++;
                        end--;
                        k--;
                    }
                }
            }
        }else{
            for (int i=9;i>=0;i--){
//                System.out.println(hm.containsKey(i) + " not found");
                if (hm.containsKey(i)){
                    int count = hm.get(i);
                    //1234567
                    if(hm.get(i)%2!=0){
                        arr[arr.length/2] = i;
                        count--;
                    }
                    for(int k= count;k>0;k--) {
//                        System.out.println("i");
                        arr[start] = i;
                        arr[end] = i;
                        start++;
                        end--;
                        k--;
                    }
                }
            }

        }

        num = "";

        for(int k: arr){
            num = num + String.valueOf(k);
        }
        return num;
    }

}
