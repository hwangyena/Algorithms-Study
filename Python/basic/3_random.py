# from random import *
# print(int(random()*20))

# 랜덤 함수
# print(randrange(1, 46)) #1이상 46미만 임의의 정수값
# print(randint(1, 45)) #1이상 45이하 임의의 정수값

#sample, shuffle 함수
# li = [1,2,3,4,5]
# print(li)
# shuffle(li) #li 리스트 섞기
# print(li)
# print(sample(li, 1)) #li 리스트에서 1개 무작위로 뽑기


#코딩 스터디 모임
'''
//문제
기찬이는 최근에 코딩 스터디 모임을 새로 만들었다.
월 4회 스터디를 하는데 3번은 온라인으로, 1번은 오프라인으로 하기로 했다.
아래 조건에 맞는 오프라인 모임 날짜를 정해주는 프로그램을 작성하시오.

1. 랜덤으로 날짜를 뽑아야한다.
2. 매월 1~3일은 스터디 준비를 해야하므로 제외한다.
3. 월별 날짜가 다름을 감안하여 최소 일수인 28일 이내로 정한다.
4. 팀원수를 입력받고 팀원별로 안되는 날을 입력받아, 해당 날짜는 제외한다.
(단, 안되는 일이 없는 팀원은 0을 입력한다)

//입력
팀원 수: 4
7/1 
12/5 
0
9/17


//출력
오프라인 스터디 모임 날짜는 매월 6일로 선정되었습니다.


from random import *

team = int(input("팀원 수: "))
exceptDay = []

for d in range(team):
    day = input()
    if(day != "0"): exceptDay.append(int(day.split("/")[1]))

# print(exceptDay)

study_day = randrange(4, 29)
while(True):
    if study_day in exceptDay: study_day = randrange(4, 29)
    else: break

print("오프라인 스터디 모임 날짜는 매월 %d일로 선정되었습니다." % study_day)
'''


'''
//문제
보성이의 학교에서 파이썬 코딩 대회를 주최하게 되었는데, 참석률을 높이기 위해 댓글 이벤트를 진행하기로 하였다.
댓글 작성자들 중 추첨을 통해 1명은 치킨, 3명은 커피 쿠폰을 받게된다.
다음 조건에 맞는 추첨 프로그램을 작성하시오.

1. 댓글을 작성한 수는 입력으로 받는다. 아이디는 1~N번으로 가정한다.
2. 댓글 내용과 상관없이 무작위로 추첨하되 중복은 불가능하다.

//입력
댓글 작성 수: 20

//출력
— 당첨자 발표 —
치킨 : 1
커피 : 2 3 4
— 축하합니다 —


from random import *
id_num = int(input("댓글 작성 수: "))
id_list = list(range(1, id_num+1))
#print(id_list)
present = sample(id_list,4)

print("-- 당첨자 발표 --")
print(f"치킨 : {present[0]}")
print("커피 : ", end="")
for i in present[1:]: print(i, end=" ")
print("\n-- 축하합니다! --")

'''



'''
//문제
당신은 Cocoa 서비스를 이용하는 택시기사님입니다.
5명의 승객과 매칭 기회가 있을 때, 총 탑승 승객 수를 구하는 프로그램을 작성하시오.

조건 1) 승객별 운행 소요 시간은 5~50분 사이의 난수로 정해집니다.
조건 2) 당신은 소요 시간 5~15분 사이의 승객만 매칭가능합니다.


//출력
[O] 1번째 손님 (소요시간: 5분)
[X] 2번째 손님 (소요시간: 48분)
[X] 3번째 손님 (소요시간: 30분)
[O] 4번째 손님 (소요시간: 15분)
[O] 5번째 손님 (소요시간: 6분)

총 탑승 승객: 3분


from random import *

num = 0; i=1
for texi in range(5):
    p = randrange(5,51)

    if p>=5 and p<=15:
        print("[O] ",end="")
        num+=1
    else:
        print("[X] ",end="")
    print(f"{texi+1}번째 손님 (소요시간: {p}분)")
    
print(f"\n총 탑승 승객: {num}분")
'''

