// class Solution {
//     public int minAddToMakeValid(String s) {
//         // didint work becuase we need to maintain order so yeah
//         int ocount=0;
//         int ccount=0;
//         for(char ch:s.toCharArray()){
//             if(ch=='('){
//                 ocount++;
//             }else{
//                 ccount++;
//             }
//         }
//         if(ocount==ccount) return 0;
//         if(ocount<ccount) return ccount-ocount;
//         if(ccount<ocount) return ocount-ccount;
//         return -1;
//     }
// }
class Solution{
    public int minAddToMakeValid(String s){
        int ans=0;
        int open=0;
        for(char ch: s.toCharArray()){
            if(ch=='('){
                open++;
            }else{
                if(open>0){
                    open--;
                }
                else{
                    ans++;
                }
            }
        }
        return ans+open;
    }
}