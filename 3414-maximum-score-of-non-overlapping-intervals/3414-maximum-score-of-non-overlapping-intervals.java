class Solution {

    static class Node {
        long score;
        ArrayList<Integer> indices;

        Node(long score, ArrayList<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // Store: start, end, weight, original index
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        Node[][] dp = new Node[n + 1][5];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                dp[i][k] = new Node(0, new ArrayList<>());
            }
        }

        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {

                // Option 1: Don't select current interval
                Node skip = dp[i + 1][k];

                // Option 2: Select current interval
                int end = arr[i][1];

                // Find first interval whose start > current end
                int next = findNext(arr, i + 1, end);

                Node takeNext = dp[next][k - 1];

                long takeScore = arr[i][2] + takeNext.score;

                ArrayList<Integer> takeIndices =
                    new ArrayList<>(takeNext.indices);

                takeIndices.add(arr[i][3]);

                Collections.sort(takeIndices);

                Node take = new Node(takeScore, takeIndices);

                dp[i][k] = better(skip, take);
            }
        }

        ArrayList<Integer> answer = dp[0][4].indices;

        int[] result = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }

        return result;
    }

    // First interval whose start > end
    private int findNext(int[][] arr, int left, int end) {

        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid][0] > end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Return better result
    private Node better(Node a, Node b) {

        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        // Same score → lexicographically smaller
        return compare(a.indices, b.indices) <= 0 ? a : b;
    }

    private int compare(ArrayList<Integer> a, ArrayList<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
}