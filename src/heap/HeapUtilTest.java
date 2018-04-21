package heap;

public class HeapUtilTest {

	public static void main(String[] args) {
		// Create Max Heap
		int[] elements = new int[] {15,10,11,8,9,7,6};
		Heap maxHeap = HeapUtil.createHeap(7, elements);
		HeapUtil.printHeap(maxHeap);
		System.out.println(" \n Parent : "+HeapUtil.getParent(maxHeap, 5));
		System.out.println(" \n Parent : "+HeapUtil.getParent(maxHeap, 6));
		System.out.println(" \n Parent : "+HeapUtil.getParent(maxHeap, 4));
		System.out.println(" \n Parent : "+HeapUtil.getParent(maxHeap, 3));
		System.out.println(" \n Parent : "+HeapUtil.getParent(maxHeap, 2));
		System.out.println(" \n Parent : "+HeapUtil.getParent(maxHeap, 1));
		
		// +ve Out of range for parent
		System.out.println(" \n Parent : "+HeapUtil.getParent(maxHeap, 15));
		
		// -ve Out of range for parent
		System.out.println(" \n Parent : "+HeapUtil.getParent(maxHeap, -1));
		
		// left Child
		System.out.println(" \n left Child : "+HeapUtil.leftChild(maxHeap, 0));
		System.out.println(" \n left Child : "+HeapUtil.leftChild(maxHeap, 1));
		System.out.println(" \n left Child : "+HeapUtil.leftChild(maxHeap, 2));
		
		System.out.println(" \n left Child : "+HeapUtil.leftChild(maxHeap, 3));
		System.out.println(" \n left Child : "+HeapUtil.leftChild(maxHeap, 4));
		System.out.println(" \n left Child : "+HeapUtil.leftChild(maxHeap, 5));
		System.out.println(" \n left Child : "+HeapUtil.leftChild(maxHeap, 6));
		System.out.println(" \n left Child : "+HeapUtil.leftChild(maxHeap, 7));
		System.out.println(" \n left Child : "+HeapUtil.leftChild(maxHeap, -1));
		
		// right Child
		System.out.println(" \n right Child : "+HeapUtil.rightChild(maxHeap, 0));
		System.out.println(" \n right Child : "+HeapUtil.rightChild(maxHeap, 1));
		System.out.println(" \n right Child : "+HeapUtil.rightChild(maxHeap, 2));
		
		System.out.println(" \n right Child : "+HeapUtil.rightChild(maxHeap, 3));
		System.out.println(" \n right Child : "+HeapUtil.rightChild(maxHeap, 4));
		System.out.println(" \n right Child : "+HeapUtil.rightChild(maxHeap, 5));
		System.out.println(" \n right Child : "+HeapUtil.rightChild(maxHeap, 6));
		System.out.println(" \n right Child : "+HeapUtil.rightChild(maxHeap, 7));
		System.out.println(" \n right Child : "+HeapUtil.rightChild(maxHeap, -1));
		
		// Max
		System.out.println(" \n Max : " + HeapUtil.max(maxHeap));
		
	}

}
