package SingletonClass;

class SingletonClass {

	private static SingletonClass ref=null;
	
	private int num=0;
	
	private SingletonClass() {
		System.out.println("SingletonClass Constructor");
	}
	
	public static SingletonClass getInstance() {
		if (ref==null) {
			ref=new SingletonClass();
		}
		
		return ref;
	}
	
	public void setNum(int num) {
		this.num=num;
	}
	
	public int getNum() {
		return num;
	}
}


public class Singleton{
	
	public static void main(String[] args) {
		
		SingletonClass s1= SingletonClass.getInstance();
		SingletonClass s2=SingletonClass.getInstance();
		
		System.out.println("s1: "+s1.getNum());
		s1.setNum(20);
		
		System.out.println("s2: "+ s2.getNum());
		
		s2.setNum(10);
		
		System.out.println("s1: "+s1.getNum());
		
		
		
		
	}
}