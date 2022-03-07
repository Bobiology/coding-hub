package ms;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 
public class SolutionIter implements Iterable<Integer> {
 
    public SolutionIter(Reader input) {
 
    }
 
    @Override
    public Iterator<Integer> iterator() {
 
        return null;
    }
 
    public static void main(String[] args) {
 
        List<Integer> list = new ArrayList<>();
 
        String[] arr = { " 122", "12222 ", "137", "-104", "2 58", "+0", "++3", "+1", "23.9", "2000000000", "-0", "five",
                "-1" };
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i].trim();
            /*String s = check(arr[i]);
            if (s != null) {
                if (Integer.valueOf(s.trim()) <= 1000000000 && Integer.valueOf(s.trim()) >= -1000000000) {
                    list.add(Integer.valueOf(s.trim()));
                }
            }*/
 
            try {
                if (Integer.parseInt(arr[i].trim()) <= 1000000000 && Integer.parseInt(arr[i].trim()) >= -1000000000) {
                    list.add(Integer.parseInt(arr[i].trim()));
                }
            } catch (Exception e) {
                //e.printStackTrace();
            }
 
        }
        System.out.println(list);
 
    }
 
    // {" 122","12222 ", "137", "-104", "2 58", "+0", "++3", "+1", "23.9",
    // "2000000000", "-0", "five", "-1" };
    private static String check(String s) {
        int n = s.length();
        String ss = "";
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if ((i != 0) && ch == ' ') {
                return null;
            }
            if (i == 0 && ch == '+' && s.charAt(1) == '+') {
                return null;
            }
            if (ch == '.') {
                return null;
            }
            if (ch != '+' && ch != '-' && ch != ' ' && !Character.isDigit(ch)) {
                return null;
            }
            if (ch != '+')
                ss += ch;
            // System.out.println("ss" + ss);
        }
        return ss;
    }
 
}
