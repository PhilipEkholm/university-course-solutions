package collections;

/**
 *	Entry
 *	
 *	A container class for storing a value together with a
 *	unique key for any hash table an instance of this class
 *	be passed in. Since it is written by Rolf this class
 *	will not be described in detail.
 *
 *	@author Rolf Axelsson
 */

class Entry<K,V> {
    K key;
    V value;
    
    public Entry( K key, V value ) {
        this.key = key;
        this.value = value;
    }
    
    // jämför två nycklar, returnerar true om lika
    public boolean equals( Object obj ) {
        if( !(obj instanceof Entry) )
            return false;
        Entry<K,V> entry = ( Entry<K,V> )obj;
        return key.equals( entry.key );
    }
}
