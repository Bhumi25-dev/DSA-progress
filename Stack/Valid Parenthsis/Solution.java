
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n==0) return true;
        int[] stack = new int[n];
        int ptr = -1;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{')
            {
                stack[ptr+1] = s.charAt(i);
                ptr++;
            }
            else
            {
                if(ptr == -1) return false;
                if(s.charAt(i)==')' && stack[ptr]!='(') return false;
                else if(s.charAt(i)==']' && stack[ptr]!='[') return false;
                else if(s.charAt(i)=='}' && stack[ptr]!='{') return false;
                ptr--;
            }
        }
        return ptr == -1;
    }
}