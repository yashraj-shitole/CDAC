package Assignment02_Question02;


//2. Write a function to sort employees by their salary


public class Assignment02_Question02 {

	public static void main(String[] args) {
		
		
		Employee[] employeeArray=new Employee[6];
		employeeArray[0]=new Employee(6,"Aishwarya",1000000);
		employeeArray[1]=new Employee(5,"Indrajeet",10000);
		employeeArray[2]=new Employee(4,"Prathamesh",50000);
		employeeArray[3]=new Employee(3, "Yashraj",30000);
		employeeArray[4]=new Employee(2, "Rushi",80000);
		employeeArray[5]=new Employee(1, "Pratik",20000);
		
		System.out.println(employeeArray.toString());
		
		
		
		iterateArray(employeeArray);
		
		System.out.println();
		
		insertionSort(employeeArray);
		
		iterateArray(employeeArray);
		
	
	}
	
	
	public static void iterateArray(Employee[] e) {
		
		for(int i=0;i<e.length;i++) {
			System.out.println(e[i].toString());
		}
		
	}

	
	
	public static void insertionSort(Employee[] eArr) {
		
		for(int i=1;i< eArr.length;i++) {
			Employee temp= eArr[i];
			int j;
			
			for(j=i-1; j>=0 && eArr[j].getSalary() > temp.getSalary();j--) {
				
				eArr[j+1]=eArr[j];
				
			}
			
			eArr[j+1]=temp;
		}
		
	}
	
	
	
	
}


