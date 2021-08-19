## 큰 수의 법칙

n, m, k = map(int, input().split())
data = list(map(int, input().split()))

data.sort()
fir_max = data[len(data)-1]
sec_max = data[len(data)-2]
sum = 0

while True:
    print("sum:",sum)
    for i in range(k):
        if(m==0): break
        sum += fir_max
        m-=1
    if(m==0): break
    sum += sec_max #두번째로 큰 수 한 번 더하기!
    m-=1
       
print(sum)