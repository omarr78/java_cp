
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public record Pair(int first, int second) implements Comparable<Pair> {
        @Override
        public int compareTo (Pair o){
            if (this.first != o.first)
                return Integer.compare(this.first, o.first);
            return Integer.compare(this.second, o.second);
        }
    }

    public static class FastReader { // Fast input reader
        BufferedReader buffer;
        StringTokenizer tokenizer;

        public FastReader() {
            buffer = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String s = buffer.readLine();
                    if (s == null)
                        return null;
                    tokenizer = new StringTokenizer(s);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    static void add(TreeMap<Pair, Integer> map, Pair p) {
        map.put(p, map.getOrDefault(p, 0) + 1);
    }

    static void remove(TreeMap<Pair, Integer> map, Pair p) {
        int cnt = map.get(p);
        if (cnt == 1) map.remove(p);
        else map.put(p, cnt - 1);
    }

    public static void main(String[] args) {
        FastReader in = new FastReader();
        Comparator<Pair> comparator = Comparator.comparingInt(Pair::first).thenComparingInt(Pair::second).reversed();

        TreeMap<Pair, Integer> ms1 = new TreeMap<>(comparator); // (h,w) holds maximum high
        TreeMap<Pair, Integer> ms2 = new TreeMap<>(comparator); // (w,h) holds maximum weight

        Map<Pair, List<Pair>> map = new TreeMap<>();
        List<Pair> list = new ArrayList<>();
        int H = in.nextInt(), W = in.nextInt();
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int h = in.nextInt();
            int w = in.nextInt();
            list.add(new Pair(h, w));
            map.put(new Pair(h, w), new ArrayList<>());
            add(ms1, new Pair(h, w));
            add(ms2, new Pair(w, h));
        }

        int idxx = 1, idxy = 1;
        while (!ms1.isEmpty()) {
            Pair firstPair = ms1.firstKey();
            Pair secondPair = ms2.firstKey();

            int h1 = firstPair.first;
            int w1 = firstPair.second;
            int w2 = secondPair.first;
            int h2 = secondPair.second;
            if (h1 == H) {
                map.computeIfAbsent(new Pair(h1, h2), k -> new ArrayList<>());
                map.get(firstPair).addLast(new Pair(idxx, idxy));
                idxy += w1;
                W -= w1;
                remove(ms1, firstPair);
                remove(ms2, new Pair(w1, h1));
            } else {
                map.computeIfAbsent(new Pair(h2, w2), k -> new ArrayList<>());
                map.get(new Pair(h2, w2)).addLast(new Pair(idxx, idxy));
                idxx += h2;
                H -= h2;
                remove(ms1, new Pair(h2, w2));
                remove(ms2, secondPair);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            Pair p = map.get(list.get(i)).getLast();
            System.out.println(p.first + " " + p.second);
            map.get(list.get(i)).removeLast();
        }

    }
}
