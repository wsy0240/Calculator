package wsy0240;
public class pi{
	public static void main(String args[]){
		float i=0f;
		long c=1;//cΪԲ����ȵ�һ��
		long d=10000;
		long r=d/2;
		 for(float a=0f;a<=r;a=a+0.1f){
			for(float b=0f;b<=r;b=b+0.1f){//��������ϵ
				if(a*a+b*b<=(r+c)*(r+c)){
					if(a*a+b*b>=(r-c)*(r-c)){//����뾶Ϊr-c��r+c��Բ��Ϊ��r��r��������Բ
						i++;//�������������ΪԲ�������
					}
				}
			}
		}
		System.out.println(i/(c*r));
	}
}