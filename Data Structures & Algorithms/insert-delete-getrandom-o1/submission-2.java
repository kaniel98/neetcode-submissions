class RandomizedSet {
    Map<Integer, Integer> map; // Keeps track of the inserted elements and its position
    List<Integer> loc;
    Random rand = new Random();

    public RandomizedSet() {
        map = new HashMap<>();
        loc = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        loc.add(val);
        map.put(val, loc.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int pos = map.get(val);

            // Move the last element to pos and update the hash map;
            int last = loc.removeLast();
            if (pos < loc.size()) {
                loc.set(pos, last);
                map.put(last, pos);
            }

            map.remove(val);
            return true;
        }

        return false;
    }

    public int getRandom() {
        int random = rand.nextInt(loc.size());
        return loc.get(random);
    }
}