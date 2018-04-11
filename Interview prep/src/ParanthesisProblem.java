import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ParanthesisProblem {


    public static void main (String args[]){

        ParanthesisProblem paranthesisProblem = new ParanthesisProblem();
        System.out.print(paranthesisProblem.checkBalanced("{{{()[[()]]}}}"));

    }


    private boolean checkBalanced(String brackets){

        //Populate a HM
        HashMap<Character,Character> hm = new HashMap<>();
        hm.put('{','}');
        hm.put('[',']');
        hm.put('(',')');
        Stack<Character> queue = new Stack<>();
        for (char c: brackets.toCharArray()){
            if (hm.containsKey(c)){
                queue.push(c);
            }else{
                char last = queue.pop();
                if (hm.get(last)!=c){
                    return false;
                }

            }
        }
        return true;
    }

}
