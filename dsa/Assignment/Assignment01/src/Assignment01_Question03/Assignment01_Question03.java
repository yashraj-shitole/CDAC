package Assignment01_Question03;


//3. Create array of employees and search employee by
//   empid
//   name

public class Assignment01_Question03 {

	
	public static void main(String[] args) {
		
		Employee[] employeeArray=new Employee[5];
		
		employeeArray[0]=new Employee(5,"Indrajeet");
		employeeArray[1]=new Employee(1, "Pratik");
		employeeArray[2]=new Employee(3, "Yashraj");
		employeeArray[3]=new Employee(4,"Prathamesh");
		employeeArray[4]=new Employee(2, "Rushi");
		
		
		System.out.println("Employee sorted by name");
		
		 System.out.println(linearSearch(employeeArray, 5));
		
		
		
		System.out.println("Employee sorted by id");
		System.out.println(linearSearch(employeeArray, "Yashraj"));
	}

	
	
	
	private static int linearSearch(Employee[] e,int key) {

		for(int i=0;i<e.length;i++) {
			
				if(e[i].getId()==key) {
					return i;
				}	
		}
		
		return -1;
	}

	
	private static int linearSearch(Employee[] e,String key) {

		for(int i=0;i<e.length;i++) {
			
				if(e[i].getName()== key) {
					return i;
				}	
		}
		
		return -1;
	}

}
