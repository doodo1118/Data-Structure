# Problem Solving
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
  

### programmers [42888](https://programmers.co.kr/learn/courses/30/lessons/42888#)
\#map

### programmers [42839](https://programmers.co.kr/learn/courses/30/lessons/42839#)
\#dfs \#recursiveCalls
