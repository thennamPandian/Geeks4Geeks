package stack.assign;


public class DataStructureDesign {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// elements are inserted in ascending order
		CustomDataStructure ds = new CustomDataStructure();
		for (int i = 0; i < 10; i++) {
			ds.push(i);
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.print(ds.getMin()+" , ");
			ds.pop();
		}
		
		ds.pop();
		System.out.print(ds.getMin()+" , ");
		
	}
	
}
