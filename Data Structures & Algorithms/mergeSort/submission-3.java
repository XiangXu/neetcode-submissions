// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSortHelper(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> mergeSortHelper(List<Pair> pairs, int left, int right) {
        if(right - left + 1 <= 1) {
            return pairs;
        }

        int mid = left + (right - left) / 2;
        mergeSortHelper(pairs, left, mid);
        mergeSortHelper(pairs, mid + 1, right);
        merge(pairs, left , mid, right);

        return pairs;
    } 

 private void merge(List<Pair> arr, int start, int mid, int end) {
        List<Pair> leftList = new ArrayList<>(arr.subList(start, mid + 1));
        List<Pair> rightList = new ArrayList<>(arr.subList(mid + 1, end + 1));
        int i = 0; // index for left list
        int j = 0; // index for right list
        int k = start;

        while(i < leftList.size() && j < rightList.size()) {
            if(leftList.get(i).key <= rightList.get(j).key) {
                arr.set(k, leftList.get(i));
                i ++;
            }
            else {
                arr.set(k, rightList.get(j));
                j ++;
            }
            k ++;
        }

        while(i < leftList.size()) {
            arr.set(k, leftList.get(i));
            i ++;
            k ++;
        }

         while(j < rightList.size()) {
            arr.set(k, rightList.get(j));
            j ++;
            k ++;
        }
    }
}
