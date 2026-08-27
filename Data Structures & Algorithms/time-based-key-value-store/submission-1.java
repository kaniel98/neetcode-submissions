class TimeMap {
    Map<String, List<TimestampValue>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new TimestampValue(value, timestamp));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        List<TimestampValue> keyValues = map.get(key);
        int left = 0;
        int right = keyValues.size() - 1;

        int leftMost = -1;
        String res = "";

        while (left <= right) {
            int middle = left + (right - left) / 2;
            TimestampValue curr = keyValues.get(middle);
            if (curr.timestamp() == timestamp) {
                return curr.value();
            }

            // Else we will just keep moving towards the closest left;
            if (curr.timestamp() > timestamp) {
                right = middle - 1;
            } else {
                if (middle > leftMost) {
                    leftMost = middle;
                    res = curr.value();
                }
                left = middle + 1;
            }
        }

        return res;
    }

    private record TimestampValue(String value, Integer timestamp) {}
}
