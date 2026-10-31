class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int student : students) {
            queue.offer(student);
        }

        int result = 0;
        int i = 0;

        while(!queue.isEmpty() && result != queue.size()) {
            if(queue.peek() == sandwiches[i]) {
                queue.poll();
                i++;
                result = 0;
            }
            else {
                queue.offer(queue.poll());
                result++;
            }
        }

        return result;
    }
}