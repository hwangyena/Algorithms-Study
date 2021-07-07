'''
//문제
현재 년도를 입력받아 최근 3년의 연도를 출력하는 프로그램을 작성하시오.

//입력
2021
//출력
2020
2019
2018

a = input("현재 년도를 입력하세요: ")
print(int(a)-1, int(a)-2, int(a)-3, sep="\n")
'''

'''
//문제
자동차 번호가 입력으로 주어지면 뒤의 4자리만 출력하시오.

//입력
24가 1201

//출력
1201

car = input()
print(car[-4:])

'''

s = "홀짝홀짝홀짝"
print(s[::2])

'''
//문제
문자열을 하나 입력받아 소문자인 경우 영어 대문자로 거꾸로 출력하는 프로그램을 작성하시오.

//입력
python
//출력
NOHTYP

string = input("입력: ")
print(string.upper()[::-1])
'''

'''
//문제
전화번호를 입력받아 하이푼('-')을 제거하고 출력하시오.

//입력
010-2345-6789
//출력
010 2345 6789

phone_number = input()
print(phone_number.replace("-"," "))
'''


'''
//문제
문자열을 입력받아 소문자 'a'를 대문자 'A'로 변경하시오

//입력
abcde1234a457baa
//출력
Abcde1234A457bAA

s = input()
print(s.replace('a','A'))
'''


'''
//문제
문자열 두 개를 입력받아 아래와 같이 출력되는 프로그램을 작성하시오.

//입력
python
java
//출력
python java python java python java python java

a, b = input(), input()
c = a+' '+b+' '
print(c*4)
또는
print(f'{a} {b} '*4)
'''


'''
//문제
이름과 나이가 순서대로 입력되면 다음과 같이 출력되는 프로그램을 작성하시오.

//입력
김민수
10
//출력
이름: 김민수, 나이: 10

name, age = input(), input()
print("이름: %s, 나이: %d" %(name, int(age)))
print("이름: {0}, 나이: {1}".format(name, age))
print(f'이름: {name}, 나이: {age}')
'''


'''
//문제
민영이는 이전까지 저금하던 통장에서 돈을 꺼내기 위해 은행에 갔다. 
통장에서 꺼내는 돈의 금액과 이자가 순서대로 입력으로 주어지면, 총 민영이가 받을 수 있는 돈은 얼마인지 출력하는 프로그램을 작성하시오.

//입력
금액: 5,123,456
이자: 65,000
//출력
5,188,456

money, plus = input("금액: "), input("이자: ")
sum = int(money.replace(",",""))+int(plus.replace(",",""))
print("{0:,}".format(sum))

s = str(123456789)
s_copy = list(s)
d = list(s[::-3])
s_copy.insert(int(d[1]),",")
s_copy.insert(int(d[2]),",")
f = "".join(s_copy)
print(f)
'''


'''
//문제
문자열이 입력되었을때, 양쪽 공백을 제거하는 프로그램을 작성하시오

//입력
   hi    
//출력
hi
'''


'''
//문제
날짜가 입력으로 들어오면 XXXX년 XX월 XX일로 바꾸어 출력하는 프로그램을 작성하시오.

//입력
2021-07-01
//출력
2021년 7월 1일

'''
date = input()
d = date.split("-")
print(f'{d[0]}년 {d[1]:0}월 {d[2]:0}일')