'''
//문제
입력으로 자연수가 홀수인지 짝수인지를 판별(반환값: bool)해주는 함수(is_odd)를 작성하시오.
정수는 계속 입력받다가 -1이 들어오면 프로그램을 종료한다.

//입력 및 출력
num? 5
odd
num? 10
even
num? -1
프로그램을 종료합니다.


def is_odd(num):
    if(num%2!=0): return True
    else: return False

while(True):
    num= int(input("num?"))
    if(num==-1): break
    
    if(is_odd(num)): print("odd")
    else: print("even")

print("프로그램을 종료합니다.")
'''

'''
//문제
두 개의 숫자를 입력받아 합, 차, 곱, 나눗셈을 출력하는 계산기 함수를 작성하여 아래와 같이 출력하시오.

//입력
3 4
//출력
7
-1
12
0.75


def calculator(a, b):
    return a+b, a-b, a*b, a/b

a, b = set(list(map(int, input().split())))
result = calculator(a, b)
for i in result: print(i)
'''


'''
//문제
가장 큰 수를 반환하는 함수를 작성해 숫자 여러개를 입력받아 결과값을 출력하시오.

//입력
1 6 7 2 50 9 60
//출력
60


def max_num(arr):
    return max(arr)

li = list(map(int, input().split()))
print(max_num(li))
'''



'''
//문제
단어 하나를 입력받아 거꾸로 "출력"하는 함수와 "반환"하는 함수를 작성하시오.
//입력
hello
//출력
1: olleh
2: olleh

def reverse_word_print(w):
    print(w[::-1])


def reverse_word(w):
    w_r = (''.join(list(reversed(w))))
    return w_r

word = input()
print("1: ", end=""); reverse_word_print(word)
print("2: " + reverse_word(word))
'''




'''
//문제
입력으로 들어오는 모든 수의 평균값을 계산해주는 함수를 작성하시오.
단, 입력으로 들어오는 수의 개수는 정해져있지 않으며, 소수점 둘째자리까지만 출력하시오.

//입력
4 2 9 6 1 3 5
//출력
4.28


def avg_fun(li):
    return sum(li)/len(li)

li = list(map(int, input().split()))
print(f"{avg_fun(li):.2f}")

'''



'''
//문제
문자열과 한줄에 출력된 글자 수를 입력받아, 한 줄에 입력된 글자 수만큼 출력하는 함수를 작성하시오. 단, 기본값을 3으로 설정하여 -1처럼 잘못된 수가 입력되는 경우 기본값으로 출력한다.

//입력
abcdefghijk
3
//출력
abc
def
ghi
jk

def str_num(word, size=3):
    for i in range(int(len(word)/3)+1):
        print(word[i*size:i*size+size])

word, size = input(), int(input())
if(size<0): str_num(word)
else: str_num(word, size)

'''



'''
//문제
문자를 입력받아 각 문자들로 구성된 리스트로 반환하는 함수를 작성하시오.

//입력
word
//출력
['w','o','r','d']


def tolist(s):
    return list(s)

s = input()
print(tolist(s))
'''



'''
//문제
사용자에게 물건 가격과 받은 금액을 각각 입력받아, 거스름돈을 반환하는 함수를 작성하시오. 물건 가격과 받은 금액은 콤마를 포함한 숫자로 들어온다.

//입력
물건 가격: 1,300
받은 금액: 2,000
//출력
거스름돈: 700원

def change(p, m):
    return m-p

price, money = int(input("물건 가격: ").replace(",","")), int(input("받은 금액: ").replace(",",""))
r = change(price, money)
if(r>0): print(f"거스름돈: {r}원")
else: print("금액이 부족합니다")
'''

