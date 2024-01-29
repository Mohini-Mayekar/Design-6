/* Time Complexity : 
 * constructor - O(n)
 * get, check, release - each O(1) */
/* Space Complexity : 
 * constructor - O(n)
 * get, check, release - each O(1) */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

public class PhoneDirectory {
    
    private LinkedList<Integer> q;
    private HashSet<Integer> set;
    
    public PhoneDirectory(int maxNumbers){
        this.q = new LinkedList<>();
        this.set = new HashSet<>();
        for(int i = 0; i < maxNumbers; i++){
            q.add(i);
            set.add(i);
        }
    }
    
    public int get(){
        if(q.isEmpty()) return -1;
        int res = q.poll();
        set.remove(res);
        return res;        
    }
    
    public boolean check(int num){
        return set.contains(num);
    }
    
    public void release(int num){
        if(!check(num)){
            q.add(num);
            set.add(num);
        }
    }
    
	public static void main(String[] args) {
        // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
        PhoneDirectory directory = new PhoneDirectory(3);

        // It can return any available phone number. Here we assume it returns 0.
           System.out.println(directory.get());

        // Assume it returns 1.
           System.out.println(directory.get());

        // The number 2 is available, so return true.
           System.out.println(directory.check(2));

        // It returns 2, the only number that is left.
           System.out.println(directory.get());

        // The number 2 is no longer available, so return false.
           System.out.println(directory.check(2));

        // Release number 2 back to the pool.
           directory.release(2);

        // Number 2 is available again, return true.
           System.out.println(directory.check(2));
    }
}