class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> aggregator = new Stack<>();
        aggregator.push(new HashMap<String, Integer>());

        for (int i = 0; i < formula.length(); i++) {
            if (formula.charAt(i) == '(') {
                // create new aggregate
                aggregator.push(new HashMap<String, Integer>());
            } else if (formula.charAt(i) == ')') {
                // find if count there with last aggregate
                int count[] = findCount(i + 1, formula);

                Map<String, Integer> top = aggregator.pop();
                Map<String, Integer> secondTop = aggregator.pop();

                // apply count to top aggregate
                if (count[1] > 0) {
                    applyCount(top, count[0]);
                }

                // merge second top aggregate into top aggregate
                mergeMap(top, secondTop);

                // push the top aggregate back to aggregator
                aggregator.push(top);

                // increase current pointer by count length
                i += count[1];
            } else {
                // seek name from formula
                String name = findName(i, formula);

                // increase current pointer by name length
                i += name.length();

                // seek count and count length from formula
                int count[] = findCount(i, formula);

                // increase current pointer by count length
                i += count[1];

                // decrease current pointer by 1, later increased in loop
                i -= 1;

                Map<String, Integer> map = aggregator.pop();
                map.put(name, map.getOrDefault(name, 0) + count[0]);
                aggregator.push(map);
            }
        }

        String ans = buildString(aggregator.pop());

        return ans;
    }

    private String findName(int idx, String formula) {
        StringBuilder sb = new StringBuilder("");
        sb.append(formula.charAt(idx++));

        while (idx < formula.length() && Character.isLowerCase(formula.charAt(idx))) {
            sb.append(formula.charAt(idx));
            idx++;
        }

        return sb.toString();
    }

    private int[] findCount(int idx, String formula) {
        int ans[] = new int[] {1, 0};

        int num = 0;

        while (idx < formula.length() && Character.isDigit(formula.charAt(idx))) {
            int curDigit = (int) formula.charAt(idx) - '0';
            num = (num * 10) + curDigit;
            ans[1]++;
            idx++;
        }
        
        if (num == 0) {
            return ans;
        }

        ans[0] = num;

        return ans;
    }

    private void applyCount(Map<String, Integer> map, int multiplier) {
        for (String key: map.keySet()) {
            map.put(key, map.get(key) * multiplier);
        }
    }

    private void mergeMap(Map<String, Integer> first, Map<String, Integer> second) {
        for (String key: second.keySet()) {
            int count = second.get(key);

            first.put(key, first.getOrDefault(key, 0) + count);
        }
    }

    private String buildString(Map<String, Integer> aggregate) {
        List<String> names = new ArrayList<String>(aggregate.keySet());
        Collections.sort(names);

        StringBuilder sb = new StringBuilder("");

        for (String name: names) {
            sb.append(name);

            int count = aggregate.get(name);
            
            if (count > 1) {
                sb.append(count);
            }
        }

        return sb.toString();
    }
}