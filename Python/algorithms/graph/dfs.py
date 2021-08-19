def dfs(graph, v, visited): #v: 시작노드
    visited[v] = True #방문 처리
    print(v, end=" ")

    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)

def dfs_stack(graph, v): #v: 시작노드
    visited = []
    stack = []
    stack.append(v) #시작 노드 넣기!

    while stack:
        n = stack.pop()
        if n not in visited: #노드 방문 X
            visited.append(n) 
            stack.extend(graph[n]) #graph가 리스트기 때문에 extend!
    return visited