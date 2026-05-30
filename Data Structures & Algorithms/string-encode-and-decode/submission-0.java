class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length()).append("#").append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        if(str.length() == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j ++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            j++;

            String word = str.substring(j, j + length);
            result.add(word);
            i = j + length;
        }

        return result;
    }
}
