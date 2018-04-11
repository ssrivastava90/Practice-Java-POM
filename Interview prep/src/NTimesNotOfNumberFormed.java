public class NTimesNotOfNumberFormed {

//https://www.geeksforgeeks.org/thue-morse-sequence/

    public static void main(String args[]) {

        int n = 4;
        int i = 0;
        String res = "0";
        int k = 1;
        while (k < n) {
            int orgLen = res.length();
            for (int j = 0; j <= orgLen - 1; j++) {
                res = res +  complement(res.charAt(j));
            }
            k++;
        }
    System.out.print(res);
    }


    private static Character complement(char c){
        if (c=='0'){
            return '1';
        }else{
            return '0';
        }

    }
}
