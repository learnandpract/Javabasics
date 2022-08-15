
public class TBD1 {
	public void except() {
	   	String str = "25T";
        try{
            int number = Integer.parseInt(str);
            System.out.println(number +" immediate");
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TBD1 tb = new TBD1();
//		tb.except();
		String str = "25.a6";
		if(str.matches("[0-9.]+")) {
			System.out.print("is number");
		}else {
			System.out.print("not number");
		}
		 	

	}

}
