class UnionFind { // A simple version for UnionFind class
    vector<int> root;
public:
    UnionFind(int n):root(n) {
        iota(root.begin(), root.end(), 0);
    }

    int Find(int x) { //Path compression
        return (x==root[x]) ? x : root[x] = Find(root[x]);
    }

    void Union(int x, int y) {// the smaller one as the common root
        x= Find(x), y= Find(y);
        if (x == y) return;
        else if (x<y) root[y]=x;  
        else root[x]=y;  
    }
};