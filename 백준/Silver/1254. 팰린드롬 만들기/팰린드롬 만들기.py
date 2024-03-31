import sys
input = sys.stdin.readline

string = input().rstrip()

def isPalindrome(string: str):
    return string == string[::-1]
    
for i in range(len(string)):
    if isPalindrome(string[i:]):
        print(len(string[i:]) + len(string[:i]) * 2)
        break
