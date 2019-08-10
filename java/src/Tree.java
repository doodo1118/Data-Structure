//Binary Search Tree

class BTree {
	private int data;
	private BTree parent;
	private BTree left;
	private BTree right;
	
	BTree(){
		left = null;
		right = null;
		parent = null;
		this.data = 0;
	}
	
	BTree(int data){
		this.data = data;
		left = null;
		right = null;
		parent = null;
	}
	
	void insert(int a) {
		//같은 값은 입력 안받는다는 전제 하
		if(this.data > a) {
			
			if(this.left==null) {
				this.left = new BTree(a);
				this.left.parent = this;
			}else {
				this.left.insert(a);
			}
			
		}
		else {
			
			if(this.right==null) {
				this.right = new BTree(a);
				this.right.parent = this;
			}else {
				this.right.insert(a);
			}
		}
	}
	
	boolean has(int a) {
		if(this.data==a)
			return true;
		else if(this.data<a) {
			if(this.right!=null && this.right.has(a))
				return true;
		}
		else {
			if(this.left!=null && this.left.has(a))
				return true;
		}
		return false;
	}
	
	void remove(int a) {
		if(this.data == a) {
			//무자식
			if(this.left==null && this.right == null)
				if(this.parent.left.data == a)
					this.parent.left = null;
				else this.parent.right = null;
			//오른쪽자식 있을 경우
			else if(this.left==null)
				if(this.parent.left.data==a)
					this.parent.left=this.right;
				else
					this.parent.right=this.right;
			//왼쪽자식
			else if(this.right==null)
				if(this.parent.left.data==a)
					this.parent.left=this.left;
				else
					this.parent.right=this.left;	
			//자식 둘 
			else {
				BTree newTree = this.right;
	
				while(newTree.left!=null)
					newTree = newTree.left;
				this.data = newTree.data;
				
				if(this.right.left==null) { 
					this.right = null;
				}
				
				if(newTree.right!=null)
					newTree.parent.left = newTree.right;
				else if(newTree.parent != this)
					newTree.parent.left = null;
			}
		}else if(a<this.data)
			this.left.remove(a);
		else this.right.remove(a);
	}

	void inorder() { //중위순회 매개변수로 함수받아서 . has/print/... has일경우 break포함?
		if(this.left!=null)
			this.left.inorder();
		
		//매개변수로 받은 함수 프린트일경우엔 아래처럼.  
		System.out.print(this.data+" ");
		
		if(this.right!=null)
			this.right.inorder();
	}
	
	//전위 순회
	void preorder() { 
		System.out.print(this.data+" ");

		if(this.left!=null)
			this.left.preorder();
		
		if(this.right!=null)
			this.right.preorder();
		
	}
	/* Binary Search Tree

	 * BTree() 루트노드 0인 Tree생성
	 * BTree(int) 루트노드 초기화하는 생성자
	 * 
	 * void remove(int)
	 * boolean has(int)
	 * void insert(int)
	 * 
	 * void inorder() 중위순회 출력
	 * void preorder() 전위순회 출력 
	 
	*/
}

