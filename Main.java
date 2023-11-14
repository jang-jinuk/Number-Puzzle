// 1. "간단 숫자 퍼즐" 타이틀 출력(프로그램 실행 시 한번만 출력)
// 2. 현재 turn을 출력(반복해서 출력)
// 3. 1 ~ 8까지 숫자를 무작위로 섞고 한줄로 출력 (반복해서 출력)
// 4. "교환할 두 숫자 입력"라는 프롬포트 출력 (반복해서 출력)


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("간단 숫자 퍼즐"); // 타이틀 출력

        int turn = 1;
        System.out.printf("turn %d%n",turn); // 현재 턴 출력

        int[] szBuffer = new int[8]; // 1 ~ 8까지 숫자를 무작위로 섞기
        for (int i = 0; i < 8; i++) {
            szBuffer[i] = (int) (Math.random() * 8 + 1);
            for (int j = 0; j < i; j++) {
                if (szBuffer[i] == szBuffer[j])
                    --i;
            }
        }

        for (int i = 0; i < 8; i++) { // 섞은 숫자 한줄로 출력
            System.out.printf("%d ", szBuffer[i]);
        }
        System.out.println("");

        Scanner scanner = new Scanner(System.in);

        System.out.print("교환할 두 숫자 입력 >"); // 프롬포터 출력
        int nInput_1 = scanner.nextInt();
        int nInput_2 = scanner.nextInt();

    }
}