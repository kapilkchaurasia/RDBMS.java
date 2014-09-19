package com.kapil.BPlusTree;

public class BTree<TKey extends Comparable<TKey>, TValue> {
	protected BTreeNode<TKey> root;
	
	
	public BTree() {
		this.root = new BTreeLeafNode<TKey, TValue>();
	}

	/**
	 * Insert a new key 
	 */
	public void insert(TKey key, TValue value) {
		BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
		leaf.insertKey(key, value);
		System.out.print(" " +value);
		if (leaf.isOverflow()) {
			BTreeNode<TKey> n = leaf.dealOverflow();
			if (n != null)
				this.root = n; 
		}
	}
	
	public void insert1(TKey key, TValue value) {
		BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
		leaf.insertKey(key, value);
		
		System.out.print(" "+value);
		System.out.println();
		if (leaf.isOverflow()) {
			BTreeNode<TKey> n = leaf.dealOverflow();
			if (n != null)
				this.root = n; 
		}
	}
	
	@SuppressWarnings("rawtypes")
	public  BTreeLeafNode foriegn(TKey key) {
		BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
		int index = leaf.search(key);
		if(index==-1){System.out.println("cant be a foriegn key");return null;}
		else{leaf.hasforiegnkey=true;
		return leaf;}
		
	}
	@SuppressWarnings("unchecked")
	public void foriegnkeyadd(BTreeLeafNode v,TKey key) {
		BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
		leaf.foriegn=v;
		leaf.hasforiegnkey=true;
	}
	
	@SuppressWarnings("unchecked")
	public void  searchforiegn(TKey key){
      BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
		
		int index = leaf.search(key);
		
		if ((index == -1)) System.out.println("not present");
		else{ System.out.println(leaf.getValue(index)+"  "+((BTreeLeafNode<TKey, TValue>) leaf.foriegn).getValue(leaf.foriegn.search(key)));}
	}
	
	
	/**
	 * Search a key value on the tree 
	 */
	public TValue search(TKey key) {
		BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
		
		int index = leaf.search(key);
		return (index == -1) ? null :leaf.getValue(index);
	}
	
	
	
	/**
	 * Delete a key 
	 */
	public void delete(TKey key) {
		BTreeLeafNode<TKey, TValue> leaf = this.findLeafNodeShouldContainKey(key);
		
		if(leaf.delete(key)){
			
			System.out.print("deleted");}
		else System.out.println("key not present");
		
		if (leaf.delete(key) && leaf.isUnderflow()) {
			BTreeNode<TKey> n = leaf.dealUnderflow();
			if (n != null)
				this.root = n; 
		}
		
	}
	
	
	
	
	
	/**
	 * Search the leaf node  contain the specified key
	 */
	@SuppressWarnings("unchecked")
	private BTreeLeafNode<TKey, TValue> findLeafNodeShouldContainKey(TKey key) {
		BTreeNode<TKey> node = this.root;
		while (node.getNodeType() == TreeNodeType.InnerNode) {
			node = ((BTreeInnerNode<TKey>)node).getChild( node.search(key) );
		}
		
		return (BTreeLeafNode<TKey, TValue>)node;
	}

	
}
