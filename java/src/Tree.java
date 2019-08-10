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
			//���ڽ�
			if(this.left==null && this.right == null)
				if(this.parent.left.data == a)
					this.parent.left = null;
				else this.parent.right = null;
			//�������ڽ� ���� ���
			else if(this.left==null)
				if(this.parent.left.data==a)
					this.parent.left=this.right;
				else
					this.parent.right=this.right;
			//�����ڽ�
			else if(this.right==null)
				if(this.parent.left.data==a)
					this.parent.left=this.left;
				else
					this.parent.right=this.left;	
			//�ڽ� �� 
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
	/* Binary Search Tree

	 * BTree() ��Ʈ��� 0�� Tree����
	 * BTree(int) ��Ʈ��� �ʱ�ȭ�ϴ� ������
	 * 
	 * void remove(int)
	 * boolean has(int)
	 * void insert(int)
	 * 
	 * void inorder() ������ȸ ���
	 * void preorder() ������ȸ ��� 
	 
	*/
}

