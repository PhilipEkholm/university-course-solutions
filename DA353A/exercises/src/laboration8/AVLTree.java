package laboration8;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import collections.ArrayList;
import collections.List;

public class AVLTree<K,V> implements SearchTree<K,V> {
    private Comparator<K> comparator;
    private AVLNode<K,V> tree;
    
    public AVLTree() {
        comparator = new Comp();
    }
    
    public AVLTree( Comparator<K> comp ) {
        comparator = comp;
    }
    
    public AVLNode<K,V> root() {
        return tree;
    }
    
    public V get(K key) {
    	AVLNode<K,V> node = find( key );
        if(node!=null)
            return node.value;
        return null;
    }
    
    
    public void put(K key, V value) {
        tree = put(tree,key,value);        
    } 
    
    public V remove(K key) {
        V value = get( key );
        if(value!=null) {
            tree = remove(tree,key);
        }
        return value;
    }
    
    public boolean contains( K key ) {
        return find( key ) != null;
    }
    
    public int height() {
        return height( tree );
    }
    
    private int height( AVLNode<K,V> node ) {
	    if( node == null )
	        return -1;
	    return 1 + Math.max( height( node.left ), height( node.right ));
	}

	public Iterator<V> iterator() {
        return new Iter();
    }
    
    private AVLNode<K,V> find(K key) {
        int res;
        AVLNode<K,V> node=tree;
        while( ( node != null ) && ( ( res = comparator.compare( key, node.key ) ) != 0 ) ) {
            if( res < 0 )
                node = node.left;
            else
                node = node.right;
        }
        return node;
    }
    
    private AVLNode<K,V> put(AVLNode<K,V> node, K key, V value) {
        if( node == null ) {
            node = new AVLNode<K,V>( key, value, null, null );
        } else {
            if(comparator.compare(key,node.key)<0) {
                node.left = put(node.left,key,value);
                node = this.balanceLeft(node);
            } else if(comparator.compare(key,node.key)>0) {
                node.right = put(node.right,key,value);
                node = this.balanceRight(node);
            }
        }
        return node;
    }
    
    private AVLNode<K,V> remove(AVLNode<K,V> node, K key) {
        int compare = comparator.compare(key,node.key);
        if(compare==0) {
            if(node.left==null && node.right==null)
                node = null;
            else if(node.left!=null && node.right==null)
                node = node.left;
            else if(node.left==null && node.right!=null)
                node = node.right;
            else {
                AVLNode<K,V> min = getMin(node.right);
                min.right = remove(node.right,min.key);
                min.left = node.left;
                node = min;
            }
        } else if(compare<0) {
            node.left = remove(node.left,key);
        } else {
            node.right = remove(node.right,key);
        }
        node = this.balanceNode(node);
        return node;
    }
    
    private AVLNode<K,V> getMin(AVLNode<K,V> node) {
        while(node.left!=null)
            node = node.left;
        return node;
    }
        
    // Laboration 13
    public int size() {
        return 0;
    }
    public List<K> keys(){
        return null;
    }
    public List<V> values(){
        return null;
    }
    public V first(){
        return null;
    }
    public V last(){
        return null;
    }
    
    private class Comp implements Comparator<K> {
        public int compare( K key1, K key2 ) {
            Comparable<K> k1 = ( Comparable<K> )key1;
            return k1.compareTo( key2 );
        }
    }
    
    // AVLTree methods -----------------------------------------------
    private AVLNode<K,V> balanceNode(AVLNode<K,V> node) {
    	if(node!=null) {
    	    node = balanceLeft(node);
    	    node = balanceRight(node);
    	}
    	return node;
    }
    
    private AVLNode<K,V> balanceLeft(AVLNode<K,V> node) {
    	if((this.height(node.left) - this.height(node.right) == 2)){
			if(this.height(node.left.left) - this.height(node.left.right) == -1){
				node.left = this.rotateLeft(node.left);
				node = this.rotateRight(node);
			}
			else{
				node = this.rotateRight(node);
			}
		}
		
		return node;
    }
    
    private AVLNode<K,V> balanceRight(AVLNode<K,V> node) {
    	if(this.height(node.left) - this.height(node.right) == -2){
        	if(this.height(node.right.left) - this.height(node.right.right) == 1){
        		node.right = this.rotateRight(node.right);
        		node = this.rotateLeft(node);
        	}
        	else{
        		node = this.rotateLeft(node);
        	}
        }
        
        return node;
    }
    
    private AVLNode<K,V> rotateLeft(AVLNode<K,V> node) {
    	AVLNode<K, V> newRoot = node.right;
        AVLNode<K, V> leftChild = newRoot.left;
        
        newRoot.left = node;
        node.right = leftChild;
        
        return newRoot;
    }
    
    private AVLNode<K,V> rotateRight(AVLNode<K,V> node) {
    	AVLNode<K, V> newRoot = node.left;
        AVLNode<K, V> rightChild = newRoot.right;
        newRoot.right = node;
        node.left = rightChild;
        
        return newRoot;
    }
      
    private class Iter implements Iterator<V> {
        ArrayList<V> list = new ArrayList<V>();
        int index = -1;
        
        public Iter() {
            inOrder(tree);
        }
        
        private void inOrder(AVLNode<K,V> node) {
            if(node!=null) {
                inOrder(node.left);
                list.add(node.value);
                inOrder(node.right);
            }
        }
        
        public boolean hasNext() {
            return index<list.size()-1;
        }
        
        public V next() {
            if(!hasNext())
                throw new NoSuchElementException();
            index++;
            return list.get(index);
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    public static void main(String[] args) {
        AVLTree<String,String> tree = new AVLTree<String,String>();
        tree.put("karta","map");
        tree.put("vacker","beautiful");
        tree.put("svart","black");
        tree.put("l??rare","teacher");
        tree.put("boll", "ball");
        tree.put("vit","white");
        tree.put("hus","house");
        tree.put("v??nster","left");
        tree.put("h??ger","right");
        tree.root().showAVL();
        String res = (String)tree.get("l??rare");
        System.out.println(res);
        System.out.println(tree.get("L??RARE"));
        System.out.println("---------------------");
        Iterator<String> elements = tree.iterator();
        while(elements.hasNext()) {
            System.out.println(elements.next());
        }
    }
}










