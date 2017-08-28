#!/bin/python3

import sys

def bfsRL(nodes, n, m, lib, path):
    cost = 0
    visited = []
    for idx, node in enumerate(nodes):
        if idx+1 not in visited:
            cost += 1
            for node in nodes[idx]:
                if node not in visited:
                    visited.append(node)
        visited.append(idx+1)

    print("C",cost)
    print((cost * lib) + (n - cost) * path)


def dfs(nodes, city, visited):
    visited[city - 1] = 1
    for node in nodes[city-1]:
        if visited[node-1] == 0:
            dfs(nodes, node, visited)


def getCostBFS():
    with open('roads_libs.txt') as f:
        q = int(f.readline().strip())
        for a0 in range(q):
            n, m, x, y = f.readline().strip().split(' ')
            n, m, x, y = [int(n), int(m), int(x), int(y)]
            # Nodes list
            nodes = [[] for i in range(n)]
            for a1 in range(m):
                city_1, city_2 = f.readline().strip().split(' ')
                city_1, city_2 = [int(city_1), int(city_2)]
                nodes[city_1-1].append(city_2)
                nodes[city_2-1].append(city_1)
            if y >= x:
                print(n*x)
            else:
                # Get min budget
                bfsRL(nodes, n, m, x, y)

def getCostDFS():
    with open('roads_libs.txt') as f:
        q = int(f.readline().strip())
        for a0 in range(q):
            n, m, x, y = f.readline().strip().split(' ')
            n, m, x, y = [int(n), int(m), int(x), int(y)]
            if y >= x:
                print(n*x)
                for a1 in range(m):
                    f.readline()
            else:
                # Nodes list
                nodes = [[] for i in range(n)]
                visited = [0 for i in range(n)]
                connected = 0
                for a1 in range(m):
                    city_1, city_2 = f.readline().strip().split(' ')
                    city_1, city_2 = [int(city_1), int(city_2)]
                    nodes[city_1-1].append(city_2)
                    nodes[city_2-1].append(city_1)
                for idx, c in enumerate(nodes):
                    if visited[idx] == 0:
                        dfs(nodes, idx+1, visited)
                        connected+=1

                print("C",connected)
                print(y * (n - connected) + x * connected)



if __name__ == "__main__":
    getCostDFS()
    print("")
    getCostBFS()
