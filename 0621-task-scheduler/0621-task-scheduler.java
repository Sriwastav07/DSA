class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int total = 0;

        for(int val : map.values()){
            pq.add(val);
        }

        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cnt = n+1;
            int i=0;

            while(i<cnt && !pq.isEmpty()){
                int freq = pq.poll();

                freq--;
                if(freq > 0){
                    temp.add(freq);
                }
                i++;
                total++;
            }

            for(int num : temp){
                pq.add(num);
            }

            if(!pq.isEmpty()){
                total += (cnt-i);
            }
        }

        return total;
    }
}