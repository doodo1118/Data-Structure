# Problem Solving
### algospot [FENCE](https://www.algospot.com/judge/problem/read/FENCE)
- 처음 문제 보고 분할정복이다라고 떠올리기까지가?
  - 분할정복인거 몰랐으면 그냥 부분합문제 + 가지치기로 접근했을듯
  - 아니면 어떤문제든 분할정복이 가능한 문제면 분할정복으로 풀 가치가있다는 생각으로 접근?
- 분할정복의 시간복잡도 O( (nlogn)*부분문제의시간복잡도 )


### algospot [TILING2](https://algospot.com/judge/problem/read/TILING2)
- DP문제들의 공통적인 발상
  - 완전 탐색으로 모든 답의 개수 count하는 함수 작성 한 뒤
  - 메모이제이션 활용방안 구상
- 가능한 모든 경우를 맨 왼쪽이 어떻게 시작하느냐에 따라 두 케이스로 나눔
  - 타일링하는 모든 방법은 두 케이스중 하나에 속함
  - 두 케이스에 동시에 속하는 방법은 없음
- 생각보다 memo데이터 활용을 엄청함.
  - n=100인경우 tiling(99) tiling(98) 호출
  - tiling(99)는 tiling(98) tiling(97)호출 
  - tiling(98)은 tiling(97) tiling(96)호출하므로..
  - 총 함수호출회수 : 2^(n)

### algospot [PI](https://www.algospot.com/judge/problem/read/PI)
\#DP \#memoization \#recursiveCalls
- input 끝에서부터 3개 / 4개 / 5개 로 나눈경우로 각각 케이스 분류해서
  - 각 단계에서 3갈래로 갈라지는 최단경로찾기문제?
  - TRIPATH같은 문제와 비슷
- 각각의 index에 대한 최소값 memo하기.
- 여전히 경계처리가 가장 헷갈린다..


### programmers [60060](https://programmers.co.kr/learn/courses/30/lessons/60060#)
\#trie
- 완전탐색시 queries.length \* 각 query 문자열의 길이 \* words.length만큼의 시간복잡도
- words들의 중복되는 부분을 겹쳐놓기 위해 그래프 모양 생각


### algospot [PICNIC](https://algospot.com/judge/problem/read/PICNIC)
\#dfs, \#stack
- 한 방향으로 순회할 수 있도록 친구관계 정보를 정렬
  - 친구관계임을 나타낸 정수 쌍 (a, b)에 대하여 a<b가 되도록
  - 위의 쌍들을 사전식으로 배열
- 위의 정렬된 정보를 n\*n의 정사각형 boolean 배열로 나타냄
- 위 정사각형 배열을 \\모양으로 반 잘랐을 때의 오른쪽 위 조각을 탐색
- 각 순서쌍(a,b), 다르게 말해서 위 배열에서 true로 설정된 좌표 a,b 를 하나의 노드로 간주하고 dfs
  - 각 행마다
    - 해당 행에 해당하는 어린이 a가 짝이 있는지
      - 있으면 다음 loop
      - 없으면 각 열마다 
        - 어린이 b가 짝이 있는지,
        - 어린이 a와 b가 친구사이인지, 
        - 만족하면 stack에 현재의 loop상태와 짝 상태를 저장
  - 필요한 행과 열을 모두 탐색하면
    - stack에서 상태를 꺼내 반복
  

### programmers [42888](https://programmers.co.kr/learn/courses/30/lessons/42888#)
\#map

### programmers [42839](https://programmers.co.kr/learn/courses/30/lessons/42839#)
\#dfs \#recursiveCalls
