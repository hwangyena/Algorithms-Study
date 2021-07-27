import pygame

pygame.init() #초기화

#화면 크기 설정
screen_width = 480 #가로
screen_height = 640 #세로
screen = pygame.display.set_mode((screen_width, screen_height))

#화면 타이틀 설정
pygame.display.set_caption("Game Project") #게임 명

#배경 이미지 불러오기
background = pygame.image.load("D:/Algorithms/Algorithms-Study/Python/gameProject/background.png") #480*640

#캐릭터(sprite) 불러오기
character = pygame.image.load("D:/Algorithms/Algorithms-Study/Python/gameProject/main.png") #70*70
character_size = character.get_rect().size #이미지의 크기 알아내기
character_width = character_size[0]; character_height = character_size[1] #가로, 세로 크기
character_x = (screen_width/2)-character_width/2 #캐릭터 가로 위치
character_y = screen_height-character_height  #캐릭터 세로 위치

# event loop
running = True #게임이 진행중인지
while running:
    for event in pygame.event.get():  #이벤트가 발생했는지?
        if event.type == pygame.QUIT: #창을 닫으면(우측 상단 X버튼) 
            running = False            #종료

    #screen.fill((0, 122, 122)) #RGB로 배경 채워 보여주기
    screen.blit(background, (0,0)) #(0,0) 좌표에서 배경 보여주기
    screen.blit(character, (character_x, character_y)) #캐릭터 보여주기

    pygame.display.update() #게임화면 다시 그리기

# game 종료
pygame.quit()