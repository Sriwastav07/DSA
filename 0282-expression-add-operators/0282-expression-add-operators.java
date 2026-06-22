class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(result, "", num, target, 0, 0, 0);
        return result;
    }

    private void dfs(List<String> result, String path, String num,
                     int target, int index,
                     long currVal, long prevNum) {

        if (index == num.length()) {
            if (currVal == target) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {

            // Skip numbers with leading zero
            if (i != index && num.charAt(index) == '0')
                break;

            String currStr = num.substring(index, i + 1);
            long currNum = Long.parseLong(currStr);

            if (index == 0) {
                dfs(result, currStr, num, target,
                    i + 1, currNum, currNum);
            } else {

                // Addition
                dfs(result, path + "+" + currStr,
                    num, target,
                    i + 1,
                    currVal + currNum,
                    currNum);

                // Subtraction
                dfs(result, path + "-" + currStr,
                    num, target,
                    i + 1,
                    currVal - currNum,
                    -currNum);

                // Multiplication
                dfs(result, path + "*" + currStr,
                    num, target,
                    i + 1,
                    currVal - prevNum + prevNum * currNum,
                    prevNum * currNum);
            }
        }
    }
}