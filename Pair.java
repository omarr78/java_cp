// when sort this pair it sort depend on the first
// if there are two first are equal then sort depend on the second
public record Pair(int first, int second) implements Comparable<Pair> {
        @Override
        public int compareTo (Pair o){
            if (this.first != o.first)
                return Integer.compare(this.first, o.first);
            return Integer.compare(this.second, o.second);
        }
}
