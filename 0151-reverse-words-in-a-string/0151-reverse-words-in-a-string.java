class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        int start=0;
        int end=arr.length-1;
        while(start<end){
            String temp = arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;end--;
        }
        StringBuilder rs = new StringBuilder();
        for(String word:arr){
            if(!word.isEmpty()){
                if(rs.length()>0) rs.append(" ");
                rs.append(word);
            }
        }
        return rs.toString();
    }
}