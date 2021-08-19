from collections import deque

def bfs(graph, start, visited):
    queue = deque([start]) #start 노드 큐에 넣기
    visited[start] = True #현재노드 방문 처리

    #queue가 빌때까지
    while queue:
        v = queue.popleft() #큐에서 원소 뽑기
        print(v, end= " ")

        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True