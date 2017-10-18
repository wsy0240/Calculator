package wsy0240;

import java.util.Scanner;
import java.util.Stack;

public class Calc2 implements CalcInterface {

	public static double basiccalculate(String input) {
		Stack<Double> operands = new Stack<Double>();
	    Stack<Character> operators = new Stack<Character>();
		Stack<Integer> operatorspos=new Stack<Integer>();
		operators.push('+');
		operatorspos.push(-1);
		for(int i=0;i<input.length();i++){
			char j=input.charAt(i);
			if((j=='+')|(j=='-')|(j=='*')|(j=='/')){
				operators.push(j);
				operatorspos.push(i);
			}
		}
		operatorspos.push(input.length());
		for(int i=0;i<operatorspos.size()-1;i++){
			operands.push(Calc.parseOperand(input.substring(operatorspos.get(i)+1,operatorspos.get(i+1))));
		}
		double result=0;
		int timecontroller=operators.size();
		for(int i=0;i<timecontroller;i++){
			if(operators.peek()=='+'){
				result=operands.pop()+result;
			}
			else{
				if(operators.peek()=='-'){
					result=result-operands.pop();
				}
				else{
					if(operators.peek()=='*'|operators.peek()=='/'){
						int pos=Math.max(operators.lastIndexOf('+'), operators.lastIndexOf('-'));
						double fractionresult=operands.get(pos);
						operands.remove(pos);
						int timecontroller2=operators.size()-1-pos;
						for(int j=0;j<timecontroller2;j++){
							if(operators.peek()=='*'){
								fractionresult=fractionresult*operands.pop();
							}
							if(operators.peek()=='/'){
								fractionresult=fractionresult/operands.pop();
							}
							if(j==timecontroller2-1){
							}
							else{
							operators.pop();
							}
							timecontroller--;
						}
					    operands.push(fractionresult);
					    timecontroller++;
					}
				}
			}
			operators.pop();
		}
		return result;
	}
	public static String debracket(String input){
		for(int i=0;i<input.length();i++){
			char j=input.charAt(i);
			if((j=='(')){
				String bracket="[(]+[^)]*+[)]";
				for(int f=i;f<input.length();f++){
					String originalfraction=input.substring(i,f);
					if(originalfraction.matches(bracket)){
						String fraction=originalfraction.substring(1,originalfraction.length()-1);
						String result=String.format("%s",(basiccalculate(fraction)));
						input=Calc.insert(result,input,fraction,i);
					}
				}
			}
		}
		return input;
	}
	
	public double calculate(String input){
		input=debracket(input);
		double result=basiccalculate(input);
		return result;
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		Calc2 myCalc = new Calc2();
		double result = myCalc.calculate(input);
		System.out.println(result);
	}
}