package wsy0240;
public class pi{
	public static void main(String args[]){
		float i=0f;
		long c=1;//c为圆环宽度的一半
		long d=10000;
		long r=d/2;
		 for(float a=0f;a<=r;a=a+0.1f){
			for(float b=0f;b<=r;b=b+0.1f){//设立坐标系
				if(a*a+b*b<=(r+c)*(r+c)){
					if(a*a+b*b>=(r-c)*(r-c)){//定义半径为r-c，r+c，圆心为（r，r）的两个圆
						i++;//求坐标个数（即为圆环面积）
					}
				}
			}
		}
		System.out.println(i/(c*r));
	}
}