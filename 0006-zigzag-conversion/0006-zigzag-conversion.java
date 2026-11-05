class Solution {
    public String convert(String s, int numRows) {
        if(s.length()==1)return s;
        if(numRows==1) return s;
        StringBuilder ans = new StringBuilder();
        int gap = 2*(numRows-1);
        for(int i=0;i<numRows;i++){
            int gap1 = gap-2*i;
            int gap2 = 2*i;
            int j=i;
            boolean first=true;
            while(j<s.length()){
                ans.append(s.charAt(j));
                if(i==0 || i==numRows-1){
                    j+=gap;
                }
                else{
                    if(first){
                        j+=gap1;
                    }
                    else{
                        j+=gap2;
                    }
                    first=!first;
                }
            }
        }
        return ans.toString();
    }
}