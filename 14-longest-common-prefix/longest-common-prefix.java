class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pre=strs[0];
        for( int i=1;i<strs.length;i++){
            String s=strs[i];
            int temp=0;
            for(int j=0;j<Math.min(s.length(),pre.length());j++){
                if(pre.charAt(j)!=s.charAt(j)){
                    temp=1;
                    pre=s.substring(0,j);
                    break;
                }
            }
            if(temp==0){
                pre=pre.length()>s.length()?s:pre;
            }
        }
        return pre;


    }
}