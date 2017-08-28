def shortest(rows, cols, field):
    # Get trees
    data = {field[i][j]:(i,j) for i in range(0, rows) for j in range(0, cols) if field[i][j] > 1}
    sorted(data.items(), key=lambda x:x[1])

    start = (0,0)
    distance = 0
    for d in data:
        vals = bfs(field, start, d)
        distance += vals[0]
        start = vals[1]

    return distance


def bfs(field, start, data):

    queue = []
    distances = [[0 for j in range(len(field[0]))] for i in range(len(field))]
    queue.append(start)
    distances[start[0]][start[1]] = 1

    moves = [(0,1), (0,-1), (1,0), (-1,0)]


    while queue:
        c_point = queue.pop(0)
        d = distances[c_point[0]][c_point[1]]

        if field[c_point[0]][c_point[1]] == data:
            start = c_point
            return d - 1, start

        for m in moves:
            x = m[0] + c_point[0]
            y = m[1] + c_point[1]

            if x < len(field) and y < len(field[0]) and x >= 0 and y >= 0 and field[x][y] != 0 and distances[x][y] == 0:
                distances[x][y] = d + 1
                queue.append((x,y))


    return -1, start



if __name__ == "__main__":
    field = [
                [1,1,0,12,1,1],
                [1,1,1,1,1, 1],
                [0,1,0,0,0, 1],
                [0,1,1,1,14,1],
                [0,0,0,0,1, 1],
                [15,1,1,1,1,1]
            ]

    print(shortest(6, 6, field))
