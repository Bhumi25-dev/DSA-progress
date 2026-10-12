import java.util.*;

class Solution {
    int[] nsi(int[] arr)
    {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            result[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return result;
    }
    int[] psei(int[] arr)
    {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] result = new int[n];
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) st.pop();
            result[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return result;
    }
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nsi = nsi(arr);
        int[] psei = psei(arr);
        int sum = 0;
        int mod = (int)(1e9+7);
        for(int i=0;i<n;i++)
        {
            int left = i-psei[i];
            int right = nsi[i]-i;
            sum = (int)((sum+(long)left*right*arr[i])%mod);
        }
        return sum;
    }
}