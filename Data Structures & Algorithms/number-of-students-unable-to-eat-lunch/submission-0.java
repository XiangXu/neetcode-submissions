class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int student : students) {
            queue.offer(student);
        }
        int i = 0;
        int result = 0;
        while(!queue.isEmpty() && result != queue.size()) {
            if(queue.peek() == sandwiches[i]) {
                result = 0;
                i++;
                queue.poll();
            }
            else {
                queue.offer(queue.poll());
                result ++;
            }
        }
        return result;
    }
}