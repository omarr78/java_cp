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
