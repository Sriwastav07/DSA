// class Solution {
//     public int countPrimes(int n) {
//         int cnt = 0;

//         for(int i=2;i<n;i++){
//             if(isPrime(i)){
//                 cnt++;
//             }
//         }

//         return cnt;
//     }

//     public boolean isPrime(int n){
//         for(int i=2;i*i<=n;i++){
//             if(n%i==0){
//                 return false;
//             }
//         }

//         return true;
//     }
// }

class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n+1];
        for(int i=2;i<=n;i++){
            isPrime[i] = true;
        }

        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i){
                    isPrime[j] = false;
                }
            }
        }

        int cnt = 0;
        for(int i=2;i<n;i++){
            if(isPrime[i]){
                cnt++;
            }
        }

        return cnt;
    }
}