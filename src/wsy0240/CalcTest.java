package wsy0240;


public class CalcTest {
	private final static String equations[]={"320-210¡Â7","-1+1.5","1.2+1","1.2+1.2","(-3)+0"
			,"0+2","(-4)+3.6","400+203","(-3.4)+3"};
	private final static double results[]={290,0.5,2.2,2.4,-3
			,2,-0.4,603,-0.4};


	public static void main(String[] args) {
		int counter=0;
		for(int i=0;i<results.length;i++){
			String equation=equations[i];
			double Calcresult=Calc.calculatefull(equation);
			if(Calcresult==results[i]){
				counter++;
				if((i+1)%10==0){
					System.out.println(".");
				}
				else{
					System.out.print(".");
				}
			}
			else{
				if((i+1)%10==0){
					System.out.println("x");
				}
				else{
					System.out.print("x");
				}
			}
		};
		System.out.println();
		System.out.println();
		System.out.println("Test passed: ("+counter+"/"+results.length+")");



	}

}
