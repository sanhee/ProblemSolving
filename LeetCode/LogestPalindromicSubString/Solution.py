class Solution:
    def longestPalindrome(self, s: str) -> str:
        # 팰린드롬 판별 및 투 포인터 확장
        def expand(left: int, right: int) -> str: # 투 포인터를 받아 문자열을 왼쪽~오른쪽에서 조여오는 함수
            while left>=0 and right <= len(s)-1 and s[left] == s[right]:  # s[left] == s[right] :: 팰린드롬의 규칙 양끝 같아야함
               left-= 1
               right+= 1
            return s[left:right]  # while을 벗어나려면 무조건 left는 음수 right는 문자열 길이보다 길다.

        # 해당 사항이 없을 때 빠르게 리턴
        if len(s) == 1 or s == s[::-1]:
            return s

        # 슬라이딩 윈도우 우측으로 이동
        # 문자열 순회하면서 길이가 가장 큰 팰린드롬 찾기

        result = ''

        for i in range (len(s)-1):
            result = max(result,
                        expand(i,i+1),
                        expand(i,i+2),
                        key=len)
        return result
