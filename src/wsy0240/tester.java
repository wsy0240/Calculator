package wsy0240;

import java.math.BigDecimal;

public class tester{



	public static void main(String[] args){
		BigDecimal premium = BigDecimal.valueOf(1586.6d);
		BigDecimal netToCompany = BigDecimal.valueOf(708.75d);
		BigDecimal commission = premium.subtract(netToCompany);
		System.out.println(commission + " = " + premium + " - " + netToCompany);
	}
}