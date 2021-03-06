import java.util.*;

public class evenTree {
    public static Map<Integer, ArrayList<Integer>> tree;
	public static int count;

    public static int countChild(int node) {
		int totalChild = tree.get(node).size();
		for (int child : tree.get(node)){
			totalChild += countChild(child);
		}
		return totalChild;
	}
    
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int v=scn.nextInt();
        int e=scn.nextInt();

        tree = new HashMap<Integer, ArrayList<Integer>>();
		for (int i=1; i<=v; i++) {
			tree.put(i, new ArrayList<Integer>());
		}

        for (int i=0; i<e; i++) {
			int child = scn.nextInt();
			int parent = scn.nextInt();
			
			tree.get(parent).add(child);
		}
		
		for (int i=2; i<=tree.size(); i++) {
			if ((countChild(i) % 2) != 0) {
				count++;
			}
		}
		
		System.out.println(count);

        scn.close();
    }
}
