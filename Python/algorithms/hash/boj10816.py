N, cardList = int(input()), list(map(int, input().split()))
M, cardOrder = int(input()), list(map(int, input().split()))

card = {}; cardPrint = []
for i in cardList:
    card[i] = card.get(i, 0)+1;


for c in cardOrder:
    cardPrint.append(card.get(c, 0))

for p in cardPrint:
    print(p, end=" ")