class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if (k < 0 || k > n) {
            return -1;
        }
        if(k==0) return 0;
        if(k==n)
        {
            int score = 0;
            for(int value: cardPoints) score+=value;
            return score;
        }
        int currentScore = 0;
        for (int i=0;i<k;i++)
        {
            currentScore+=cardPoints[i];
        }
        int maxScore = currentScore;
        int rightIndex = n-1;
        int leftIndex = k-1;
        int ctr = 0;
        while(ctr<k)
        {
            if(leftIndex>=0)
            currentScore = currentScore - cardPoints[leftIndex] + cardPoints[rightIndex];
            else currentScore += cardPoints[rightIndex];
            leftIndex--;
            rightIndex--;
            maxScore = Math.max(currentScore,maxScore);
            ctr++;
        }
        return maxScore;
    }
}