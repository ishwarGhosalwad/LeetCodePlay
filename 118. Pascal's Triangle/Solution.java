public class solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        // First row is always [1]
        result.add(new ArrayList<>());
        result.get(0).add(1);
        
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                    temp.add(val);
                }
            }
            result.add(temp);
        }
    }
}
