import java.util.*;

class Solution {

    public boolean isPalindrome(String s) {
		String snew = s.toLowerCase();
        ArrayList<Character> arr = new ArrayList<>();
		for(int i=0;i<snew.length();i++)
		{
			char c = snew.charAt(i);
			if(Character.isLetterOrDigit(c)) arr.add(c);
		}
		for(int i=0;i<arr.size()/2;i++)
		{
			if(!Objects.equals(arr.get(i), arr.get(arr.size()-1-i))) return false;
		}
		return true;
    }
}