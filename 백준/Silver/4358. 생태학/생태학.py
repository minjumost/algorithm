import sys

input = sys.stdin.readline

words = dict()
total = 0

while True:
    word = input().rstrip()
    if word == '':
        break

    if word in words:
        words[word] += 1
        
    else:
        words[word] = 1

    total += 1

words :dict = dict(sorted(words.items(), key = lambda x: x[0]))

for word, count in words.items():
    print("%s %.4f" %(word, count/total*100))
