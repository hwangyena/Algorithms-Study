import pygame

pygame.init() #초기화

#화면 크기 설정
screen_width = 480 #가로
screen_height = 640 #세로
screen = pygame.display.set_mode((screen_width, screen_height))

#화면 타이틀 설정
pygame.display.set_caption("Game Project") #게임 명

#배경 이미지 불러오기
background = pygame.image.load("D:/Algorithms/Algorithms-Study/Python/gameProject/background.png")

# event loop
running = True #게임이 진행중인지
while running:
    for event in pygame.event.get():  #이벤트가 발생했는지?
        if event.type == pygame.QUIT: #창을 닫으면(우측 상단 X버튼) 
            running = False            #종료

    screen.blit(background, (0,0)) #(0,0) 좌표에서 배경 보여주기
    pygame.display.update() #게임화면 다시 그리기

# game 종료
pygame.quit()