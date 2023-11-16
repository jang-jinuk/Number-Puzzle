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

        MixNumber();
        scanNumber();
    }
    static void MixNumber(){
        int[] szBuffer = new int[8]; // 1 ~ 8까지 숫자를 무작위로 섞기
        for (int i = 0; i < 8; i++) {
            szBuffer[i] = (int) (Math.random() * 8 + 1);
            for (int j = 0; j < i; j++) {
                if (szBuffer[i] == szBuffer[j])
                    --i;
            }
        }
        System.out.print("[ ");
        for (int num:szBuffer // 섞은 숫자 출력
        ) {
            System.out.print(num + " ");
        }
        System.out.print("] \n");
    }
    static void scanNumber(){
        int nInput_1 = 0, nInput_2 = 0;

        Scanner scanner = new Scanner(System.in); //숫자 입력 받기
        do{
        System.out.print("교환할 두 숫자 입력 > "); //입력 받은 숫자 유효성 검사
        nInput_1 = scanner.nextInt();
        nInput_2 = scanner.nextInt();
        if(nInput_1 < 1 || nInput_1 > 8 || nInput_2 < 1 || nInput_2 > 8){
            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.\n");
        }
        }while(nInput_1 < 1 || nInput_1 > 8);
    }
}