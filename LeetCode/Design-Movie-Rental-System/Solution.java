
class MovieRentingSystem {
    private Map<Integer, TreeSet<int[]>> available;
    private TreeSet<int[]> rented;
    private Map<String, Integer> priceMap;

    public MovieRentingSystem(int n, int[][] entries) {
        available = new HashMap<>();
        rented = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });
        priceMap = new HashMap<>();
        for (int[] e : entries) {
            int shop = e[0], movie = e[1], price = e[2];
            available.putIfAbsent(movie, new TreeSet<>((a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            }));
            available.get(movie).add(new int[]{price, shop});
            priceMap.put(shop + "#" + movie, price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (available.containsKey(movie)) {
            for (int[] p : available.get(movie)) {
                res.add(p[1]);
                if (res.size() == 5) break;
            }
        }
        return res;
    }

    public void rent(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        available.get(movie).remove(new int[]{price, shop});
        rented.add(new int[]{price, shop, movie});
    }

    public void drop(int shop, int movie) {
        int price = priceMap.get(shop + "#" + movie);
        rented.remove(new int[]{price, shop, movie});
        available.get(movie).add(new int[]{price, shop});
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (int[] t : rented) {
            res.add(Arrays.asList(t[1], t[2]));
            count++;
            if (count == 5) break;
        }
        return res;
    }
}
