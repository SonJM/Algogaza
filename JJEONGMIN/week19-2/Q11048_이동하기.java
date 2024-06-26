public class Q11048_이동하기 {
    public static void main(String[] args) {
        // 로직 설계 (다이나믹 프로그래밍(DP))
        // 준규의 처음 시작 위치(1,1) 부터 목표 위치(N,M)까지 가는 동안 먹을 수 있는 최대 사탕의 개수
        // 준규가 움직일 수 있는 경우의 수는 (+1,0), (0,+1), (+1,+1) 세 가지 경우의 수만 존재
        // 현재 위치에서 (-1,0), (0,-1), (-1,-1)위치의 사탕 개수 + 현재 위치의 사탕 개수를 구하며 계산
        // 목표 위치(N,M)에 도달했을 때의 사탕 개수를 출력
    }
}
