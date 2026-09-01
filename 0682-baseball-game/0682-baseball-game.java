class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack();

        for (String op : operations) {
            if (op.equals("+")) {
                int sum = stack.get(stack.size() - 1) + stack.get(stack.size() - 2);
                stack.push(sum);
            } else if (op.equals("D")) {
                int sum = 2 * stack.peek();
                stack.push(sum);
            } else if (op.equals("C")) {
                stack.pop();
            }else{
            stack.push(Integer.parseInt(op));
            }
        }
        int total = 0;

        for (int score : stack) {
            total += score;
        }

        return total;
    }
}