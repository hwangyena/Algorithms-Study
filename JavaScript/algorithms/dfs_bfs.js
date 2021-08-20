function dfs_recur(graph, start, visited){
    visited[start] = true;

    for(let i=0; i<graph.length; i++){
        if(!visited[i])
            dfs_recur(graph, i, visited);
    }
}

function dfs_stack(graph, start){
    let visited = []; //방문 노드
    let stack = []; 
    stack.push(start); //시작 노드 넣기

    while(stack.length !== 0){
        let node = stack.pop();

        if(!visited[node]){
            //노드 방문
            visited[node] = true;
            
            stack.push(graph[node]);
        }
    }

}