## 미로 탈출 - BFS
from collections import deque

n, m = map(int, input().split())

maze = []
for i in range(n):
    maze.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(graph, x, y):
    queue = deque()
    queue.append((x,y))

    while queue: #큐가 빌때까지 반복
        x, y = queue.popleft()
        
        for i in range(4): #상하좌우 
            nx = x+dx[i]
            ny = y+dy[i]

            if(nx<0 or nx>=n or ny<0 or ny>=m): #공간을 벗어남
                continue
            
            if graph[nx][ny] == 0: #벽
                continue
            
            if graph[nx][ny] == 1:
                queue.append((nx,ny))
                graph[nx][ny] = graph[x][y] + 1
    return graph[n-1][m-1]

print(bfs(maze, 0, 0))