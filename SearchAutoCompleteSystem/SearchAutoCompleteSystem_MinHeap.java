/* Time Complexity : O(nl(log nl)) 
 *  n - size of the hashmap
 *  l - Avg length of the sentence */
/* Space Complexity : O(1) 
 * pq of size 3 */
// Did this code successfully run on Leetcode : No, as it's a premium problem 
// Any problem you faced while coding this :


//Min Heap Solution


class Solution {
    HashMap<String, Integer> map;
    StringBuilder sb;
    public AutocompleteSystem(String[] sentences, int[] times){
        this.map = new HashMap<>();
        this.sb = new StringBuilder();
        for(int i = 0; i < sentences.length; i++){
            String str = sentences[i];
            int count = times[i];
            map.put(str, map.getOrDefault(str, 0) + count);
        }
    }
    
    public List<String> input(char c){
        if(c == '#'){
            //copy input search string
            String searchStr = sb.toString();
            //add to map
            map.put(searchStr, map.getOrDefault(searchStr, 0) + 1);
            //reset input 
            this.sb = new StringBuilder();
            //return empty list
            return new ArrayList<>();
        }
        sb.append(c);
        String searchSt = sb.toString();
        //Min Heap - Priority Queue
        PriorityQueue<String> pq  = new PriorityQueue<>((a,b) -> {
            int cnta = map.get(a);
            int cntb = map.get(b);
            if(cnta == cntb){
                //lexigraphical compare
                return b.compareTo(a);
            }
            return cnta - cntb;
        });

        for(String sentence: map.keySet()){
            id(sentence.startsWith(sb)){
                pq.add(sentence);
                if(pq.size() > 3){
                    pq.poll();
                }
            }
        }
        List<String> li = new ArrayList<>();
        while(!pq.isEmpty()){
            li.add(0, pq.poll());
        }
        return li;
    }
}