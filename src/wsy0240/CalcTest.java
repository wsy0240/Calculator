package wsy0240;


public class CalcTest {
	private final static String equations[]={"1+1","-1+1.5","1.2+1","1.2+1.2","(-3)+0"
			,"0+2","(-4)+3.6","400+203","(-3.4)+3"//add
			,"2-1","2-2.3","2-1.8","2-(-2)","-2-2"
			,"-2.8+3.0","-2.8-3","-2.8-3/4","-2.8+1","-2+(-2)"//minus
			,"3*3","3x3","3.0x3.0","3x2.0","3.0x2"
			,"3x(-2)","3x(-24.0)","2x(-3/4)","-2.0*3","-2x2"
			,"(-2.0)x(-2.0)","(-2.0)x3.0","-2.0*(-3/4)","(-2)*(-3.0)","-2*(-2.0)"//multiple
		    ,"2/2","2/4","2/4.0","3.0/1.5","3.0/(-1.5)","3.0/-1.5"
		    ,"(-2)/(-2)","(-2)/(1.0)","(-2)/(-1.0)","-2.0/-2","-3/1"
		    ,"-2.0/-2","(-2.0)/(1.0)","(-2.0)/2"//divide
		    ,"(1+1)","(1+1)*2","(1+1)/2","((1+1)*2+2)/2","(1+1)x(1+1)"
		    ,"(1+1)x(1+1)x(1+1)"};//bracket
	private final static double results[]={2,0.5,2.2,2.4,-3
			,2,-0.4,603,-0.4
			,1,-0.3,0.2,4,-4
			,0.2,-5.8,-3.55,-1.8,-4
			,9,9,9,6,6
			,-6,-72,-1.5,-6,-4
			,4,-6,1.5,6,4
			,1,0.5,0.5,2,-2,-2
			,1,-2,2,1,-3
			,1,-2,-1
			,2,4,1,3,4
			,8};

	public static void test(CalcInterface myCalc){
		int counter=0;
		for(int i=0;i<results.length;i++){
			String equation=equations[i];
			double Calcresult=myCalc.calculate(equation);
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
		System.out.println("Test passed: ("+counter+"/"+results.length+")");		
	}
	public static void main(String[] args) {
		Calc myCalc =new Calc();
		test(myCalc);
	}
}