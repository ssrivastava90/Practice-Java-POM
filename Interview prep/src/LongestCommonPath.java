import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/program-longest-common-directory-path/
//https://ide.geeksforgeeks.org/uHGajUTlEP

public class LongestCommonPath {

    public static void main(String args[]){

        String[] str = {"/home/User/Desktop/gfg/test", "/home/User/Desktop/gfg/file","/home/User/Desktop/geeks/folders"};
        findCommonPath(str,"/");
        }


     private static void findCommonPath(String[] str, String sep){
         List<String> list  = new ArrayList<>();
         int count = 0;
         int k=0;
         for(String s:str){
             String[] words = s.split(sep);
             if (count==0){
                 for (int i=1;i<words.length;i++) {
                     list.add(words[i]);
                 }
                 count++;
             }
             else{
                 k=0;
                 for (int i=1;i<words.length;i++) {
                     if(list.contains(words[i])) {
                         k++;
                     }else{
                         break;
                     }
                 }
                 if(k<list.size()){
                     list = list.subList(0,k);
                 }
             }

         }

         System.out.print(list.toString());
     }
}
