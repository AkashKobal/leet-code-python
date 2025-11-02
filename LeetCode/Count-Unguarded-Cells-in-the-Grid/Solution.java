    obstacles_in_row = [[] for _ in range(m)] # i -> list of walls and guards in that row sorted by j
    obstacles_in_col = [[] for _ in range(n)] # j -> list of walls and guards in that row sorted by i
    for i, j in guards:
        obstacles_in_row[i].append((j, "G"))
        obstacles_in_col[j].append((i, "G"))
    for i, j in walls:
        obstacles_in_row[i].append((j, "W"))
        obstacles_in_col[j].append((i, "W"))
    for row in obstacles_in_row:
        row.sort()
    for col in obstacles_in_col:
        col.sort()
    
    obstacles = {(i, j) for i, j in chain(guards, walls)}
    ans = 0
    for i in range(m):
        for j in range(n):
            if (i, j) in obstacles:
                continue
            
            row = obstacles_in_row[i]
            if row:
                east = bisect_left(row, j, key=itemgetter(0))
                west = east - 1
                if (
                    (west >= 0 and row[west][1] == "G")
                    or (east < len(row) and row[east][1] == "G")
                ):
                    continue
            
            col = obstacles_in_col[j]
            if col:
                south = bisect_left(col, i, key=itemgetter(0))
                north = south - 1
                if (
                    (north >= 0 and col[north][1] == "G")
                    or (south < len(col) and col[south][1] == "G")
                ):
                    continue
            
            ans += 1
    return ans