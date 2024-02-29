import sys
from collections import defaultdict

input = sys.stdin.readline

p, m = map(int, input().split())
players = []
rooms = []

for i in range(p):
    level, name = input().split()
    players.append([int(level), name])


rooms.append([[players[0][0], players[0][1]]])
for level, player in players[1:]:
    for room in rooms:
        if room[0][0]-10 <= level <= room[0][0]+10 and len(room) < m:
            room.append([level, player])
            break
    else:
        rooms.append([[level, player]])


for room in rooms:
    room.sort(key = lambda x: x[1])
    if len(room) == m:
        print("Started!")
        for level, player in room:
            print(level, player)

    else:
        print("Waiting!")
        for level, player in room:
              print(level, player)
    

        
    
