
/**
 * Write a description of Debug1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Debug1 {
public void findAbc(String input){
       int index = input.indexOf("abc");
       while (true){
           if (index == -1 || index >= input.length() - 3){
               break;
           }
           String found = input.substring(index+1, index+4);
           System.out.println("index " + index);
           System.out.println(found);
           index = input.indexOf("abc",index+5);
           System.out.println("index after updating " + index);
           
       }
   }

   public void test(){
       //findAbc("abcd");
       findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
       //findAbc("abcabcabcabca");
    }
}