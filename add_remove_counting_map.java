static void add(TreeMap<Integer, Integer> map, Integer x) {
  map.put(x, map.getOrDefault(x, 0) + 1);
}

// How "getOrDefault" works
// The getOrDefault(Object key, V defaultValue) method does exactly what its name says:
// Search: It looks for the key x in the map.
// Found: If x exists, it returns the current count (the value associated with x).
// Not Found: If x does not exist, it returns the default you provided as the second argument in this case it 0.

static void remove(TreeMap<Integer, Integer> map, Integer x) {
  int cnt = map.get(x);
  if (cnt == 1) map.remove(x);
  else map.put(x, cnt - 1);
}
