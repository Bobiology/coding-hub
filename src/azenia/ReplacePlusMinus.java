package azenia;

public class ReplacePlusMinus {

	public static void main (String[] args)
	  {
	    // This is a string in which a substring
	    // is to be searched.
	    String str = "minusplusminus";
	  
	    // Returns index of first occurrence of substring
	    int firstIndex = str.indexOf("plus");
	    System.out.println(firstIndex);
	    //System.out.println(str.replace(firstIndex, "-").replace("plus", "+"));
	  }
}
