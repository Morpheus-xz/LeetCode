class Solution {
    private boolean check(int j, boolean[] occupied) {
        // Check if seats j, j+1, j+2, j+3 are free; if they are free occupy them and mark them occupied that is true
        for (int start = j; start < j + 4; start++) {
            if (occupied[start]) {
                return false;
            }
        }
        // Mark those 4 seats as occupied
        for (int start = j; start < j + 4; start++) {
            occupied[start] = true;
        }
        return true;
    }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, boolean[]> rows = new HashMap<>();
        // Store reserved seats row-wise
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (!rows.containsKey(row)) {
                rows.put(row, new boolean[11]);
            }
            rows.get(row)[col] = true;
        }
        // Initially, every row can accommodate 2 families at max so we assume maximum possible number
        int ans = 2 * n;
        // Process only rows having reserved seats; rows without reservation must have 2 families
        for (Map.Entry<Integer, boolean[]> entry : rows.entrySet()) {
            boolean[] occupied = entry.getValue();
            int groups = 0;
            // Seats 2-5
            if (check(2, occupied)) {
                groups++;
            }
            // Seats 4-7
            if (check(4, occupied)) {
                groups++;
            }
            // Seats 6-9
            if (check(6, occupied)) {
                groups++;
            }
            // This row was initially counted as 2
            ans -= 2;
            // Add the actual number possible
            // We had initially counted 2 for this row.
            // Replace that with the actual number of groups.
            ans += groups;
        }
        return ans;
    }
}