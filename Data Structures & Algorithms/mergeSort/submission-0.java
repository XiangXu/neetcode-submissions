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

    private List<Pair> mergeSortHelper(List<Pair> pairs, int start, int end) {
        if(end - start + 1 <= 1) {
            return pairs;
        }

        int middle  = (start + end) / 2;
        mergeSortHelper(pairs, start, middle);
        mergeSortHelper(pairs, middle + 1, end);
        merge(pairs, start, middle, end);

        return pairs;
    }

    private void merge(List<Pair> arr, int s, int m, int e) {
        // Copy the sorted left & right halves to temp arrays
        List<Pair> L = new ArrayList<>(arr.subList(s, m + 1));
        List<Pair> R = new ArrayList<>(arr.subList(m + 1, e + 1));

        int i = 0; // index for L
        int j = 0; // index for R
        int k = s; // index for arr

        // Merge the two sorted halves into the original array
        while (i < L.size() && j < R.size()) {
            if (L.get(i).key <= R.get(j).key) {
                arr.set(k, L.get(i));
                i++;
            } else {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }

        // One of the halves will have elements remaining
        while (i < L.size()) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }
        while (j < R.size()) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }
}
