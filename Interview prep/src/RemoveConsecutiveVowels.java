public class RemoveConsecutiveVowels {

    public static void main(String args[]){

        String str = "aaaaabbcdddddeaa";
        char temp='\0' ;
        for (char c:str.toCharArray()){
            if (temp!=c){
                System.out.print(c);
                temp = c;
            }
        }

    }
}
