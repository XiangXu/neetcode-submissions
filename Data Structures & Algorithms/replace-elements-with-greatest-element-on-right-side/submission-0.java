class Solution {
    public int[] replaceElements(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int rightMax = -1;
            for(int j = i + 1; j < arr.length; j++) {
                rightMax = Math.max(arr[j], rightMax);
            }
            arr[i] = rightMax;
        }
        return arr;
    }
}