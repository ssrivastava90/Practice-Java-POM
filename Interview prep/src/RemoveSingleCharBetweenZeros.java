public class RemoveSingleCharBetweenZeros {

    //https://www.geeksforgeeks.org/removing-elements-two-zeros/

    public static void main(String args[]) {
        String str = "1010001101011";
        char[] strArray = str.toCharArray();
        String ans="";
        for (int i=0 ; i< str.length()-2;i++) {
//            if (strArray[i]==strArray[i+2]){
//                if (strArray[i]=='0'){
//                    System.out.print("In loop");
//                    ans = ans + strArray[i] + strArray[i+2];
//                    i=i+2;
//                }else{
//                    ans = ans + strArray[i];
//                }
//            }else {
//                ans = ans + strArray[i];
//            }

            if (str.charAt(i)==str.charAt(i+2)){
                if (str.charAt(i)=='0') {
                    System.out.print("In loop");
                    str = str.substring(0, i) + str.substring(i + 2);
                    i = i + 2;
                }
            }
        }


        System.out.print(str);
    }

}
