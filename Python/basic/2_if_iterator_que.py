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

'''
//문자
주민등록번호의 뒷 자리 7자리 중 두번째와 세번째는 지역코드를 의미한다. 주민 등록 번호를 입력 받은 후 출생지가 서울인지 아닌지 판단하는 코드를 작성하라.

00~08 : 서울
09~12 : 부산

//입력
주민등록번호: 821010-1635210
//출력
서울이 아닙니다.

//입력
주민등록번호: 861010-1015210
//출력
서울 입니다.

registrationNum = int(input("주민등록번호: ")[-6:-4])
if(registrationNum>=0 and registrationNum<=8):
    print("서울 입니다.")
else:
    print("서울이 아닙니다.")

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
'''
//문제
문자열 4개를 입력받고 사용자에게 숫자 하나를 추가로 입력받아,
해당 숫자보다 길이가 짧은 문자열만 출력하는 프로그램을 작성하시오.

//입력
dog duck rabbit quokka
5
//출력
dog duck

animal = input().split()
length = int(input())
for a in animal: 
    if(length>len(a)): print(a, end=" ")
'''

'''
//문제
공백을 두고 입력된 숫자들을 거꾸로 출력하는 프로그램을 작성하시오.

//입력
5 3 1 6 7 8 
//출력
8 7 6 1 3 5

li = list(map(int, input().split()))
li.reverse()
for i in li: print(i, end=" ")

#또는

li = list(map(int, input().split()))
for i in li[::-1]: print(i, end=" ")

'''

'''
//문제
문자를 입력받아 대문자, 소문자를 따로 화면에 출력하시오.

//입력
A b C d
//출력
대문자: A C
소문자: b d

word = input().split()
up = []; lo = []

for w in word:
    if(w.isupper()): up.append(w)
    else: lo.append(w)
print("대문자: ",end="") 
for u in up: print(u, end=" ") 
print("\n소문자: ",end="")
for l in lo: print(l, end=" ")
'''


'''
//문제
파일 이름이 순서대로 입력되면 확장자를 확인해 확장자가 .py나 .c인 파일 이름만 출력하는 프로그램을 작성하시오.

//입력
hello.py ex.h coding.py world.c
//출력
hello coding world

'''


'''
//문제
총 4개의 정수를 입력받아 음수를 출력하는 프로그램을 작성하시오.

//입력
3 -20 -3 44
//출력
-20
-3


num = list(map(int, input().split()))
for i in num:
    if(i<0): print(i)

'''


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
이름 여러개를 입력받아 이름의 길이를 반환하는 프로그램을 작성하시오.
단 리스트 내포를 사용하시오.

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
문자열이 공백을 두고 순서대로 3개가 입력되면 문자의 첫 글자를 대문자로 바꾸는 프로그램을 작성하시오

//입력
ulsan coding academy
//출력
Ulsan Coding Academy


word = input().split()

newWord = [i[0].upper()+i[1:] for i in word]
for w in newWord: print(w, end=" ")

'''



############# 심화 ###################
'''
 
//문제
주민등록번호는 13자리로 구성되는데 마지막 자리수는 유효성을 체크하는데 사용된다. 먼저 앞에서부터 12자리의 숫자에 2,3,4,5,6,7,8,9,2,3,4,5를 차례로 곱한 뒤 그 값을 전부 더한다.
연산 결과 값을 11로 나누면 나머지가 나오는데 11에서 나머지를 뺀 값이 주민등록 번호의 마지막 번호가 된다.

   8 2 1 0 1 0 - 1 6 3 5 2 1 0
X 2 3 4 5 6 7   8 9 2 3 4 5 
—————————————-
1차 계산: (8*2 + 2*3 + 1*4 + 0*5 + ... + 1*5) = (128 % 11) = 7
2차 계산: 11-7 = 4

821010-1635210에 대해 계산을 해보면 마지막 번호는 4가 되어야하므로 해당 주민등록번호는 유효하지않은 주민등록번호임을 알 수 있다.

사용자에게 주민등록번호를 입력받은 후 유효한지 검사하는 프로그램을 작성하시오.

//입력
주민등록번호: 821010-1635214
//출력
유효하지않은 주민등록번호입니다.

regNum = input("주민등록번호: ")
i=0; sum=0
li = [2,3,4,5,6,7,8,9,2,3,4,5]

for n in regNum[:len(regNum)-1]:

    if(n=='-'): continue
    sum += li[i] * int(n)
    i+=1
result = 11-(sum%11)

if(result==int(regNum[-1:])): print("유효한 주민등록번호입니다.")
else: print("유효하지않은 주민등록번호입니다.")
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
