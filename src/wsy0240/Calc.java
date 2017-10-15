package wsy0240;

import java.util.Scanner;
import java.math.BigDecimal;
import java.util.Arrays;
public class Calc implements CalcInterface{

	public static double parseOperand(String operand){
		double sum=0;
		int f=operand.indexOf(".");
		if(f==-1){
			for(int j=0;j<operand.length();j++){
				char n=operand.charAt(j);
				sum=n-'0'+sum*10;
			}
		}
		else{
			String a=operand.substring(0, f);
			String b=operand.substring(f+1);
			for(int i=0;i<f;i++){
				char k=a.charAt(i);
				sum=k-'0'+sum*10;

			}
			for(int j=0;j<b.length();j++){
				char n=b.charAt(j);
				sum=(n-'0')/(Math.pow(10, j+1))+sum;

			}
		}
		return sum;
	}
	public static String debracket(String input){
		int counter=0;
		for(int i=0;i<input.length();i++){
			char r=input.charAt(i);
			if(r=='('|r==')'){
				counter++;
			}
		}
		int bracketposition[]=new int[counter];
		counter=0;
		for(int i=0;i<input.length();i++){
			char r=input.charAt(i);
			if(r=='('|r==')'){
				bracketposition[counter]=i;
				counter++;
			}
		}
		int counter2=0;
		int deltalength=0;
		for(int i=0;i<counter;i++){
			if(i<counter-1){
				if(input.charAt(bracketposition[i]+deltalength-2*counter2)=='('&input.charAt(bracketposition[i+1]+deltalength-2*counter2)==')'){
					String inside=input.substring(bracketposition[i]+deltalength-2*counter2+1,bracketposition[i+1]+deltalength-2*counter2);
					double insideresult=calculaterun(inside);
					String newinside=String.format("%s",insideresult);
					input=insert(newinside,input,inside,bracketposition[i]+deltalength-2*counter2);
					counter2++;
					deltalength=newinside.length()-inside.length();
				}
			}
		}
		return input;
	}

	public static String debracketfull(String input){
		int counter=0;
		for(int i=0;i<input.length();i++){
			char r=input.charAt(i);
			if(r=='('|r==')'){
				counter++;
			}
		}
		for(int i=0;i<counter;i++){
			input=debracket(input);
			if(input.indexOf('(')==-1){
				break;
			}
		}
		return input;
	}
	public static int[] replicate(int arr[]){
		int arr2[]=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			arr2[i]=arr[i];
		}
		return arr2;
	}
	public static String insert(String object,String target,String inside,int position){
		String target1=new String(target.substring(0,position));
		String target2=new String(target.substring(position+inside.length()+2,target.length()));
		String result=target1+object+target2;
		target=result;
		return target;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		Calc myCalc =new Calc();
		double result=myCalc.calculate(input);
		System.out.println(result);
	}

	public double calculate(String input){
		double calcresult=changeform(input);
		return calcresult;
	}

	public static String insert2(String object,String target,int inside,int position){
		String target1=new String(target.substring(0,position));

		String target2=new String(target.substring(position+inside,target.length()));
		String result=target1+object+target2;
		target=result;
		return target;
	}

	public static String deminus(String input){
		for(int i=0;i<input.length()-1;i++){
			char r=input.charAt(i);
			char x=input.charAt(i+1);
			if(r=='+'&x=='-'){
				input=insert2("-",input,2,i);
			}
			if(r=='-'&x=='-'){
				input=insert2("+",input,2,i);
			}
			if(r=='*'&x=='-'){
				String input1=input.substring(0, i);
				int counter=0;
				for(int j=0;j<input1.length();j++){
					char r1=input1.charAt(j);
					if(r1=='+'|r1=='-'){
						counter++;
					}
				}
				int addandminus[]=new int[counter];
				counter=0;
				for(int j=0;j<input1.length();j++){
					char r2=input1.charAt(j);
					if(r2=='+'|r2=='-'){
						addandminus[counter]=j;

						for(int k=j+1;k<input1.length();k++){
							char r3=input1.charAt(k);
							if(r3!='-'&r3!='+'){

							}
							else{
								if(r3=='+'|r3=='-'){
									counter++;
									break;
								}
							}
						}

					}
				}
				input=insert2("*",input,2,i);
				input1=input.substring(0,i);
				if(input1.indexOf("-")==-1){
					input=insert2("-",input,0,0);
				}
				else{
					if(input.charAt(addandminus[counter])=='-'){
						input=insert2("+",input,1,addandminus[counter]);
					}
					else{
						if(input.charAt(addandminus[counter])=='+'){
							input=insert2("-",input,1,addandminus[counter]);
						}
					}
				}
			}
			if(r=='/'&x=='-'){
				String input1=input.substring(0, i);
				int counter=0;
				for(int j=0;j<input1.length();j++){
					char r1=input1.charAt(j);
					if(r1=='+'|r1=='-'){
						counter++;
					}
				}
				int addandminus[]=new int[counter];
				counter=0;
				for(int j=0;j<input1.length();j++){
					char r2=input1.charAt(j);
					if(r2=='+'|r2=='-'){
						addandminus[counter]=j;

						for(int k=j+1;k<input1.length();k++){
							char r3=input1.charAt(k);
							if(r3!='-'&r3!='+'){

							}
							else{
								if(r3=='+'|r3=='-'){
									counter++;
									break;
								}
							}
						}

					}
				}
				input=insert2("/",input,2,i);
				input1=input.substring(0,i);
				if(input1.indexOf("-")==-1){
					input=insert2("-",input,0,0);
				}
				else{
					if(input.charAt(addandminus[counter])=='-'){
						input=insert2("+",input,1,addandminus[counter]);
					}
					else{
						if(input.charAt(addandminus[counter])=='+'){
							input=insert2("-",input,1,addandminus[counter]);
						}
					}
				}
			}
		}
		return input;

	}

	public static double changeform(String input){
		for(int x=0;x<input.length();x++){
			char r=input.charAt(x);
			if(r=='x'){
				input=insert2("*",input,1,x);
			}
			if(r=='¡Â'){
				input=insert2("/",input,1,x);
			}
			if(r==' '){
				input=insert2("",input,1,x);
			}
			if(r=='['|r=='{'){
				input=insert2("(",input,1,x);
			}
			if(r==']'|r=='}'){
				input=insert2(")",input,1,x);
			}
		}
		String line1=debracketfull(input);
		String line=deminus(line1);
		double result=calculaterun(line);
		return result;
	}

	public static double calculaterun(String line) {
		int arr[]=new int[line.length()];
		int addlength=0;
		int minuslength=0;
		int multiplelength=0;
		int dividelength=0;
		int i=0;
		for(int o=0;o<line.length();o++){
			char u=line.charAt(o);
			if(u=='+'){
				Arrays.fill(arr,i,i+1,o);
				addlength++;
				i++;
			}
			if(u=='-'){
				Arrays.fill(arr,i,i+1,o);
				minuslength++;
				i++;
			}
			if(u=='*'){
				Arrays.fill(arr,i,i+1,o);
				multiplelength++;
				i++;
			}
			if(u=='/'){
				Arrays.fill(arr,i,i+1,o);
				dividelength++;
				i++;
			}
		}
		Arrays.sort(arr);
		int prearradd[]=new int[addlength+1];
		int prearrminus[]=new int[minuslength+1];
		int prearrmultiple[]=new int[multiplelength+1];
		int prearrdivide[]=new int[dividelength+1];
		int placedicider=0;
		for(int j=0;j<line.length();j++){
			char u=line.charAt(j);

			if(u=='+'){
				Arrays.fill(prearradd,placedicider,placedicider+1,j);
				placedicider++;
			}
		}
		placedicider=0;
		for(int j=0;j<line.length();j++){
			char u=line.charAt(j);
			if(u=='-'){
				Arrays.fill(prearrminus,placedicider,placedicider+1,j);
				placedicider++;
			}
		}
		placedicider=0;
		for(int j=0;j<line.length();j++){
			char u=line.charAt(j);
			if(u=='*'){
				Arrays.fill(prearrmultiple,placedicider,placedicider+1,j);
				placedicider++;
			}
		}
		placedicider=0;
		for(int j=0;j<line.length();j++){
			char u=line.charAt(j);
			if(u=='/'){
				Arrays.fill(prearrdivide,placedicider,placedicider+1,j);
				placedicider++;
			}
		}
		int arradd[]=Arrays.copyOfRange(prearradd, 0, prearradd.length-1);
		int arrminus[]=Arrays.copyOfRange(prearrminus, 0,prearrminus.length-1);
		int arraddandminus[]=new int[arradd.length+arrminus.length];
		for(int j=0;j<arraddandminus.length;j++){
			if(j<arradd.length){
				arraddandminus[j]=arradd[j];
			}
			else{
				arraddandminus[j]=arrminus[j-arradd.length];
			}
		}
		Arrays.sort(arraddandminus);
		String arrprocess1[]=new String[arraddandminus.length+1];
		double arrprocess2[]=new double[arrprocess1.length];
		for(int j=0;j<arraddandminus.length+1;j++){
			if(j==0){
				if(arraddandminus.length==0){
					arrprocess1[j]=line;
				}
				else{
					arrprocess1[j]=line.substring(0,arraddandminus[j]);
				}
			}
			else{
				if(j==arraddandminus.length){
					arrprocess1[j]=line.substring(arraddandminus[j-1]+1);
				}

				else{
					arrprocess1[j]=line.substring(arraddandminus[j-1]+1,arraddandminus[j]);
				}
			}
		}
		for(int j=0;j<arrprocess1.length;j++){
			int prearrmultipleanddivide[]=new int[arrprocess1[j].length()+1];
			int counter=0;
			double result=0;
			for(int f=0;f<arrprocess1[j].length();f++){
				char u=arrprocess1[j].charAt(f);

				if(u=='*'|u=='/'){
					counter++;
					Arrays.fill(prearrmultipleanddivide,counter,counter+1,f);
				}
			}
			Arrays.sort(prearrmultipleanddivide);
			int arrmultipleanddivide[]=new int[counter];
			int l1=arrprocess1[j].indexOf("*");
			int l2=arrprocess1[j].indexOf("/");
			if(l1==-1&l2==-1){
				arrprocess2[j]=parseOperand(arrprocess1[j]);
			}
			else{
				for(int m=0;m<prearrmultipleanddivide.length;m++){
					int n=prearrmultipleanddivide[m];
					if(n!=0){
						arrmultipleanddivide=Arrays.copyOfRange(prearrmultipleanddivide, m,prearrmultipleanddivide.length);
						double arrnumber1[]=new double[arrmultipleanddivide.length+1];
						for(int o=0;o<arrmultipleanddivide.length+1;o++){

							if(o==0){
								arrnumber1[o]=parseOperand(arrprocess1[j].substring(0, arrmultipleanddivide[o]));
							}
							else{
								if(o==arrmultipleanddivide.length){
									arrnumber1[o]=parseOperand(arrprocess1[j].substring(arrmultipleanddivide[o-1]+1));
								}
								else{
									arrnumber1[o]=parseOperand(arrprocess1[j].substring(arrmultipleanddivide[o-1]+1, arrmultipleanddivide[o]));

								}
							}
						}
						result=arrnumber1[0];
						for(int p=1;p<arrnumber1.length;p++){
							char t=arrprocess1[j].charAt(arrmultipleanddivide[p-1]);
							if(t=='*'){
								result=result*arrnumber1[p];
							}
							else{
								result=result/arrnumber1[p];
							}
						}
						arrprocess2[j]=result;
						break;
					}
				}
			}

		}
		double sum=arrprocess2[0];
		BigDecimal sumnew=BigDecimal.valueOf(sum);
		for(int q=1;q<arrprocess2.length;q++){
			char t=line.charAt(arraddandminus[q-1]);
			if(t=='+'){
				sumnew=sumnew.add(BigDecimal.valueOf(arrprocess2[q]));
			}
			else{
				sumnew=sumnew.subtract(BigDecimal.valueOf(arrprocess2[q]));
			}
		}
		return sumnew.doubleValue();
	}
}