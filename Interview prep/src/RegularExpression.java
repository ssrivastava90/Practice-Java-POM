public class RegularExpression {

    public static void main(String args[]){

        String inp = "aaaaaaaaabbbbbbbbbbbbbb";

        char a=inp.charAt(0);
        char e = inp.charAt(inp.length()-1);
        int m=0,n=0;
        for(char c:inp.toCharArray()){
            if (c==a){
                m++;
            }else if(c==e){
                n++;
            }else{
                System.out.print(" Not Matching");
                break;
            }
        }
        System.out.print(m + " " + n);
    }
}
