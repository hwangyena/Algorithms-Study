function solution(x, n) {
    
    //My answer
    for(let i=1; i<n; i++){
        answer.push(x*i);
    }

    //Other answer
    var answer = Array(n);
    answer.fill(x).map((v, i)=>(i+1)*v);

    //Other answer 2
    var answer2= [...Array(n).keys()].map(v => (v+1)*x);
    return answer;
}