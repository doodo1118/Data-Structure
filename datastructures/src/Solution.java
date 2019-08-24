import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
		

		/* Main
		 * Binary Search Tree 
		 * 
		 */
		BTree tree = new BTree(15);
		
		tree.inorder(); System.out.println();
		
		tree.insert(7);
		tree.insert(9);
		tree.insert(3);
		tree.insert(1);
		tree.insert(2);
		tree.insert(4);
		tree.insert(16);
		
		tree.inorder(); System.out.println();
		
		tree.remove(4);
		tree.inorder(); System.out.println();
		
		tree.remove(15);
		tree.inorder(); System.out.println();
		
		tree.insert(5);
		tree.insert(6);
		tree.insert(10);
		tree.insert(13);
		tree.insert(4);
		tree.insert(19);
		tree.inorder(); System.out.println();
		
		tree.preorder(); System.out.println();

		System.out.println(tree.has(1));
		System.out.println(tree.has(13));
		System.out.println(tree.has(8));
		System.out.println(tree.has(5));
		
		/*
		getData 노드에 저장된 데이터를 반환
		makeBTreeNode 노드에 저장된 데이터를 반환
		SetData 노드에 데이터를 저장
		
		makeLeftSubTree
		makeRightSubTree
		getLeftSubTree
		getRightSubTree
		InorderTraverse()
		*/
	}
}

