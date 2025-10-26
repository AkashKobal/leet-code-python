class Bank {
    private final long[] bal;
    private final int n;

    public Bank(long[] bal) {
        this.bal = bal;
        this.n = bal.length;
    }

    public boolean transfer(int from, int to, long amt) {
        if (!valid(from) || !valid(to) || bal[from - 1] < amt) return false;
        bal[from - 1] -= amt;
        bal[to - 1] += amt;
        return true;
    }

    public boolean deposit(int acc, long amt) {
        if (!valid(acc)) return false;
        bal[acc - 1] += amt;
        return true;
    }

    public boolean withdraw(int acc, long amt) {
        if (!valid(acc) || bal[acc - 1] < amt) return false;
        bal[acc - 1] -= amt;
        return true;
    }

    private boolean valid(int acc) {
        return acc > 0 && acc <= n;
    }
}