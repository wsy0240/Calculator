package wsy0240;
import java.text.DecimalFormat;
public class DecimalFormatDemo {

	static public void SimpleFormat(String pattern,double value){
		DecimalFormat myFormat=new DecimalFormat(pattern);
		String output=myFormat.format(value);
		System.out.println(value+" "+pattern+" "+output);
	}
	
	static public void UseApply(String pattern,double value){
		DecimalFormat myFormat=new DecimalFormat();
		myFormat.applyPattern(pattern);
		System.out.println(value+" "+pattern+" "+myFormat.format(value));
	}

}
