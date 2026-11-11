class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long o1 = (long)cost1*need1;
        long o2 = (long)cost2*need2;
        long needed = Math.max(need1,need2);
        long overall = needed*costBoth;
        // i missed the buy a combination case lets code it
        long common = Math.min(need1,need2);
        long mix = common*costBoth+((need1-common)*cost1)+((need2-common)*cost2);
        return Math.min(o1+o2,Math.min(overall,mix));
    }
}