// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        List<List<Pair>> result = new ArrayList<>();  // list of snapshots
        int len = pairs.size();
        for (int i = 0; i < len; i++) {               // start at 0
            int j = i - 1;
            while (j >= 0 && pairs.get(j).key > pairs.get(j + 1).key) {
                Pair temp = pairs.get(j);
                pairs.set(j, pairs.get(j + 1));
                pairs.set(j + 1, temp);
                j--;
            }
            // save snapshot INSIDE the loop
            result.add(new ArrayList<>(pairs));
        }
        return result;
    }
}
