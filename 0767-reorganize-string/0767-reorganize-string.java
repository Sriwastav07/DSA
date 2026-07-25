class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>( (a, b) -> b[1] - a[1]);

        for(int i=0;i<26;i++){
            if(freq[i] > 0){
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder sb = new StringBuilder();

        while(pq.size() >= 2){
            int[] first = pq.poll();
            int[] sec = pq.poll();

            sb.append((char)(first[0]+'a'));
            sb.append((char)(sec[0]+'a'));

            first[1]--;
            sec[1]--;

            if(first[1] > 0){
                pq.offer(first);
            }

            if(sec[1] > 0){
                pq.offer(sec);
            }

        }

        while(!pq.isEmpty()){
            int[] last = pq.poll();
            if(last[1] > 1){
                return "";
            }

            sb.append((char)(last[0]+'a'));
        }

        return sb.toString();
    }
}