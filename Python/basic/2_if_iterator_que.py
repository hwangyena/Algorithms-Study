######## if ########
'''
//문제
사용자로부터 문자 한 개를 입력받아, 소문자인경우 대문자로 대문자인 경우 소문자로 변경하여 출력하는 프로그램을 작성하시오

//입력
A
//출력
a

string = input()
if(string.islower()): print(string.upper())
else: print(string.lower())
'''


'''
//문제
사용자에게 점수를 입력받아 80점 이상이면 A, 60점 이상이면 B, 40점 이상이면 C, 나머지는 F 학점을 출력하는 프로그램을 작성하시오
//입력
66
//출력
B

score = int(input("점수를 입력하세요: "))
if(score>=80): print("A")
elif(score>=60): print("B")
elif(score>=40): print("C")
else: print("F")

'''

'''
//문제
사용자에게 달러, 엔, 유로 또는 위안 금액을 입력받은 뒤 이를 원으로 변환하는 프로그램을 작성하시오. 각 통화별 환율은 다음과 같다.
=========
달러 : 1167
엔 : 1.096
유로 : 1268
위안 : 171
=========

//입력
100 달러
//출력
116700.00원

//입력
150 엔
//출력
164.40원

money, which = input().split()
if(which=="달러"): print(f'{float(money)*1167:0.2f}원')
elif(which=="엔"): print(f'{float(money)*1.096:0.2f}원')
elif(which=="유로"): print(f'{float(money)*1268:0.2f}원')
else: print(f'{float(money)*171:0.2f}원')
'''

'''
//문제
휴대폰 번호 앞자리에 따라 통신사는 다음과 같이 구분된다.
사용자에게 핸드폰 번호를 입력받아 통신사를 출력하는 프로그램을 작성하시오.
===========
011 : SKT
016 : KT
019 : LG
010 : 알수없음
===========

//입력
휴대전화 번호: 011-345-6789
//출력
당신은 SKT 사용자입니다.

//입력
휴대전화 번호: 010-345-6789
//출력
알수없습니다.


phone= input("휴대전화 번호: ")[:3]
if phone=="010": print("알수없습니다.")
else:
    if phone=="011": phone="SKT"
    elif phone=="016": phone="KT"
    else: phone="LG"
    print(f'당신은 {phone} 사용자입니다.')
'''

######## while ########
'''
//문제
while문을 사용하여 다음과같이 별을 그리는 프로그램을 작성하시오

//입력
3
//출력
*
**
***

n = int(input())
i = 1
while n>0:
    print("*"*i)
    n-=1; i+=1
'''

'''
//문제
while문을 사용해 1부터 100까지 자연수 중 3의 배수의 합을 출력하는 프로그램을 작성하시오.

//출력
1683

i=1; sum=0
while i<=100:
    if i%3==0 : sum += i
    i+=1
print(sum)

'''


######## for ########

''''
//문제
N명의 학생의 수학 점수를 입력받아 평균을 출력하는 프로그램을 작성하시오.

//입력
70 60 75 55 98
//출력
71.6

avg = 0
student = list(map(int, input().split()))
for s in student:
    avg += s

print(avg/len(student))
'''


'''
//문제
N개의 갯수만큼 정수를 입력받아 10을 곱한뒤 출력하는 프로그램을 작성하시오.

//입력
1 2 3 4 5
//출력
10 20 30 40 50

arr= map(int, input().split())
arr = [i*10 for i in arr]
for i in arr: print(i, end=" ")

#?
for i in map(int, input().split()): print(i*10, end=' ')
'''


'''
//문제
두 개의 정수를 입력받아 작은 수부터 큰 수까지 구구단을 출력하는 프로그램을 작성하시오.

//입력
두 개의 수를 입력하세요: 5 3
//출력
3 6 9 12 15 18 21 24 27 
4 8 12 16 20 24 28 32 36
5 10 15 20 25 30 35 40 45

a, b = input("두 개의 수를 입력하세요: ").split()

for i in range(min(int(a),int(b)), max(int(a),int(b))+1):
    for j in range(1,10):
        print(i*j, end=" ")
    print()
'''

'''
//문제
이름 여러개를 입력받아 이름의 길이를 반환하는 프로그램을 작성하시오

//입력
Kathy Bob John 
//출력
5 3 4

name = input().split()
s = [len(i) for i in name]
for num in s: print(num,end=" ")
'''


'''
//문제
당신은 Cocoa 서비스를 이용하는 택시기사님입니다.
5명의 승객과 매칭 기회가 있을 때, 총 탑승 승객 수를 구하는 프로그램을 작성하시오.

조건 1) 승객별 운행 소요 시간은 5~50분의 입력으로 정해집니다.
조건 2) 당신은 소요 시간 5~15분 사이의 승객만 매칭가능합니다.

//입력
5 48 30 15 6
//출력
[O] 1번째 손님 (소요시간: 5분)
[X] 2번째 손님 (소요시간: 48분)
[X] 3번째 손님 (소요시간: 30분)
[O] 4번째 손님 (소요시간: 15분)
[O] 5번째 손님 (소요시간: 6분)

총 탑승 승객: 3분

texi = list(map(int, input().split()))
num = 0; i=1
for p in texi:
    if p>=5 and p<=15:
        print("[O] ",end="")
        num+=1
    else:
        print("[X] ",end="")
    print(f"{i}번째 손님 (소요시간: {p}분)")
    i+=1
print(f"\n총 탑승 승객: {num}분")
'''
