import pygame

pygame.init() #초기화

#화면 크기 설정
screen_width = 480 #가로
screen_height = 640 #세로
screen = pygame.display.set_mode((screen_width, screen_height))

#화면 타이틀 설정
pygame.display.set_caption("Game Project") #게임 명

#FPS
clock = pygame.time.Clock()

#배경 이미지 불러오기
background = pygame.image.load("D:/Algorithms/Algorithms-Study/Python/gameProject/background.png") #480*640

#캐릭터(sprite) 불러오기
character = pygame.image.load("D:/Algorithms/Algorithms-Study/Python/gameProject/main.png") #70*70
character_size = character.get_rect().size #이미지의 크기 알아내기
character_width = character_size[0]; character_height = character_size[1] #가로, 세로 크기
character_x = (screen_width/2)-character_width/2 #캐릭터 가로 위치
character_y = screen_height-character_height  #캐릭터 세로 위치

#이동 좌표
to_x = 0; to_y=0
#이동 속도
character_speed = 0.5

# event loop
running = True #게임이 진행중인지
while running:
    frame = clock.tick(100) #게임화면 초당 프레임 수

    #print("fps: "+str(clock.get_fps()))

    for event in pygame.event.get():  #이벤트가 발생했는지?
        if event.type == pygame.QUIT: #창을 닫으면(우측 상단 X버튼) 
            running = False            #종료

        if event.type == pygame.KEYDOWN: #키가 눌렸는지 확인
            if event.key == pygame.K_LEFT: #왼쪽
                to_x -= character_speed
            if event.key == pygame.K_RIGHT: #오른쪽
                to_x += character_speed
            if event.key == pygame.K_UP: #위
                to_y -= character_speed
            if event.key == pygame.K_DOWN: #아래
                to_y += character_speed

        if event.type == pygame.KEYUP: #방향키를 떼면
            if event.key == pygame.K_LEFT or event.key == pygame.K_RIGHT: 
                to_x = 0
            elif event.key == pygame.K_UP or event.key == pygame.K_DOWN: 
                to_y = 0

    character_x += to_x * frame
    character_y += to_y * frame

    #화면밖을 벗어나지 않도록
    #가로 경계 처리
    if character_x < 0:
        character_x = 0
    elif character_x > screen_width-character_width: #캐릭터는 왼쪽 상단이 위치값이므로!!
        character_x = screen_width-character_width

    #세로 경계 처리
    if character_y < 0:
        character_y = 0
    elif character_y > screen_height-character_height: #캐릭터는 왼쪽 상단이 위치값이므로!!
        character_y = screen_height-character_height

    #screen.fill((0, 122, 122)) #RGB로 배경 채워 보여주기
    screen.blit(background, (0,0)) #(0,0) 좌표에서 배경 보여주기
    screen.blit(character, (character_x, character_y)) #캐릭터 보여주기

    pygame.display.update() #게임화면 다시 그리기

# game 종료
pygame.quit()