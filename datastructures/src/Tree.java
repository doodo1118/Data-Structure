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
		//���� ���� �Է� �ȹ޴´ٴ� ���� ��
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
			//if the node you want to be removed has no child.
			if(this.left==null && this.right == null)
				if(this.parent.left.data == a)
					this.parent.left = null;
				else this.parent.right = null;
			//if the node has a child on the right side.
			else if(this.left==null)
				if(this.parent.left.data==a)
					this.parent.left=this.right;
				else
					this.parent.right=this.right;
			//if the node has a child on the left side.
			else if(this.right==null)
				if(this.parent.left.data==a)
					this.parent.left=this.left;
				else
					this.parent.right=this.left;	
			//if the node has children on both sides.
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
			
			//call function recursively
		}else if(a<this.data)
			this.left.remove(a);
		else this.right.remove(a);
	}

	void inorder() { //������ȸ �Ű������� �Լ��޾Ƽ� . has/print/... has�ϰ�� break����?
		if(this.left!=null)
			this.left.inorder();
		
		//�Ű������� ���� �Լ� ����Ʈ�ϰ�쿣 �Ʒ�ó��.  
		System.out.print(this.data+" ");
		
		if(this.right!=null)
			this.right.inorder();
	}
	
	//���� ��ȸ
	void preorder() { 
		System.out.print(this.data+" ");

		if(this.left!=null)
			this.left.preorder();
		
		if(this.right!=null)
			this.right.preorder();
		
	}
}

