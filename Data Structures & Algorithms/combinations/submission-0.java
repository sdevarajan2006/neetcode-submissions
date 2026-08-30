class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), n, k, 1);
        return ans;
    }

    private void helper(List<List<Integer>> ans, List<Integer> current, int n, int k, int start) {
        if (current.size() == k) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            helper(ans, current, n, k, i + 1);
            current.remove(current.size() - 1);
        }
    }
}