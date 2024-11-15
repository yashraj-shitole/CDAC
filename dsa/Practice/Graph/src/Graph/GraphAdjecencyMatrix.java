package Graph;

import java.util.*;


public class GraphAdjecencyMatrix {
	
	
public static void main(String[] args) {
	
	
	Scanner sc=new Scanner(System.in);
	
	System.out.print("Enter number vertex: ");
	int vertexCount=sc.nextInt();
	System.out.println("Enter number of edges");
	int edgeCount=sc.nextInt();
	
	GraphAdjecencyMatrix gm=new GraphAdjecencyMatrix(vertexCount, edgeCount);
	
	gm.acceptGraph(sc);
	
	gm.displayGraph();
	
	gm.bfsTraverse(0);
}
	
	private int vertexCount, edgeCount;
	
	private boolean[][] adjmat;

	public GraphAdjecencyMatrix(int vertexCount, int edgeCount) {
	
		this.vertexCount = vertexCount;
		adjmat=new boolean[vertexCount][vertexCount];
		
		this.edgeCount=edgeCount;
	}
	
	public void acceptGraph(Scanner sc) {
		System.out.println("Enter "+ edgeCount+" edges");
		for(int i=0;i<edgeCount;i++) {
			int src=sc.nextInt();
			int dest=sc.nextInt();
			adjmat[src][dest]=true;
			adjmat[dest][src]=true;
		}
	}
	
	
	public void displayGraph() {
		
		for(int i=0;i<vertexCount;i++) {
			System.out.print(i+"|\t");
			for(int j=0;j<vertexCount;j++) {
				System.out.print(adjmat[i][j]+"\t" );
			}
			System.out.println();
		}
		
		
	}
	
	public void bfsTraverse(int start) {
		
		Queue<Integer> q=new LinkedList<>();
		boolean marked[] = new boolean[vertexCount];
		
		q.offer(start);
		marked[start]=true;
		while(!q.isEmpty()) {
			
			int u=q.poll();
			
			System.out.print(u+" ");
			
			for(int i=0;i<vertexCount;i++) {
				
				if(!marked[i] && adjmat[u][i]) {
					q.offer(i);
					marked[i]=true;
				}	
			}
		}	
	}
	

}


