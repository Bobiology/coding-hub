package tomtom;

public class PlanSeats {

	public static void main(String[] args) {
		
	}
	public static int maxFams(int N , String s){
        int fams = 0;

        StringBuilder sBuilder = new StringBuilder(s);
        for(int i = 1; i<=N; i++){
            boolean containsD = sBuilder.toString().contains(i + "D");
            boolean containsE = sBuilder.toString().contains(i + "E");
            if(!(sBuilder.toString().contains(i + "B") || sBuilder.toString().contains(i + "C") || containsD || containsE)){
                 fams++;
            
                 sBuilder.append(i).append("B").append(i).append("C").append(i).append("D").append(i).append("E");
              
            }
            boolean containsF = sBuilder.toString().contains(i + "F");
            //boolean containsF = sBuilder.toString().contains(i + "F");
            if(!(containsD || containsE || containsF || sBuilder.toString().contains(i + "G"))){
                fams++;
               
                sBuilder.append(i).append("D").append(i).append("E").append(i).append("F").append(i).append("G");
               
            }
            if(!(containsF || sBuilder.toString().contains(i + "G") || (sBuilder.toString().contains(i + "H") || sBuilder.toString().contains(i + "J")))){
                fams++;
             
                sBuilder.append(i).append("E").append(i).append("F").append(i).append("G").append(i).append("H");

            }
        }


        System.out.println(fams);
        return fams;
    }

}
