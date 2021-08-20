## 음료수 얼려먹기 (DFS)

n, m = map(int, input().split())
drink = [[0 for j in range(m)] for i in range(n)] #2차원 배열 선언 & 0으로 초기화
print(drink)

for i in range(n):
    drink[i] = list(map(int, input()))


# 0 -> 방문 처리 & dfs
# 1 -> 방문한 것!
def dfs(graph, row, col):
    if(row<0 or col<0 or row>=n or col>=m):
        return False

    #상하좌우 살피기
    if(graph[row][col] == 0):
        graph[row][col] = 1 #방문 처리
        
        dfs(graph, row-1, col)
        dfs(graph, row, col-1)
        dfs(graph, row+1, col)
        dfs(graph, row, col+1)
        return True
    
    return False
    
count = 0

for i in range(n):
    for j in range(m):
        if(dfs(drink, i, j)):
            count+=1

print(count)
    