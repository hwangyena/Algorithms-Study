function solution(price, money, count) {
    //price : 이용 금액, count: 횟수만큼 탐
    for(let i=1; i<=count; i++){
        money -= price*i;
    }
    
    if(money < 0){
        return money*-1;
    }
    else return 0;
}