package codility;

import java.util.*;


// Class name should be "Source",
// otherwise solution won't be accepted
public class ReducedFormPeter {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        // Declare the variable
        int a=0;
        
        // Read the variable from STDIN
        a = in.nextInt();
        
        // Output the variable to STDOUT
        //System.out.println(a);

        //int testCases = in.nextInt();
        //System.out.println("Number of test cases " + a);

        int testCaseCount = 0;
        int size = 0;
        while (testCaseCount <= a) {
            //in = new Scanner(System.in);
            try{
                size = in.nextInt();
            //System.out.println("Array size " + size);
            int count = 0;
            Map<Integer,Integer> map = new TreeMap<>();
            
            while (in.hasNextInt() && count < size) {
                int input = in.nextInt();
                map.put(input, count);
                //System.out.println("Input " + input + " count = " + count);
                count++;
            }
            map.values().forEach(i -> {
                System.out.print(i + " ");
            });
            System.out.println(" ");
            //System.out.println("============= " + testCaseCount + " ================");
            }catch(Exception e){

            }
            
            testCaseCount++;
        }
        in.close();
   }

}
