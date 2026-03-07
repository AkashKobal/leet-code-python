int minOperations(auto& s) {
    int op[2] = {0, 0};
    for (int i = 0; i < s.length(); i++)
        op[(s[i] ^ i) & 1]++;
    return min(op[0], op[1]);
}