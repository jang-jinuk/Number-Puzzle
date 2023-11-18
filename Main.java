// 1. "간단 숫자 퍼즐" 타이틀 출력(프로그램 실행 시 한번만 출력)
// 2. 현재 turn을 출력(반복해서 출력)
// 3. 1 ~ 8까지 숫자를 무작위로 섞고 한줄로 출력 (반복해서 출력)
// 4. "교환할 두 숫자 입력"라는 프롬포트 출력 (반복해서 출력)


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int[] puzzleNumber = new int[8];

        System.out.println("간단 숫자 퍼즐"); // 타이틀 출력
        puzzleNumber = mixNumber(); // 1~8 숫자 섞어주기
        startGame(puzzleNumber); //  게임진행

    }
    static int[] mixNumber() {    // 1 ~ 8까지 숫자를 무작위로 섞기
        int[] puzzleBox = new int[8];
        for (int i = 0; i < 8; i++) {
            puzzleBox[i] = (int) (Math.random() * 8 + 1);
            for (int j = 0; j < i; j++) {
                if (puzzleBox[i] == puzzleBox[j])
                    --i;
            }
        }
        return puzzleBox;
    }
    static void printNumber(int[] NumberPuzzle) {

        System.out.print("[ ");
        for (int number:NumberPuzzle) {     //섞은 숫자 출력
            System.out.print(number + " ");
        }
        System.out.print("] \n");
    }
    static int[] scanNumber() {
        int changeNum_1 = 0, changeNum_2 = 0;

        Scanner scanner = new Scanner(System.in); //숫자 입력 받기
        do{
        System.out.print("교환할 두 숫자 입력 > "); //입력 받은 숫자 유효성 검사
        changeNum_1 = scanner.nextInt();
        changeNum_2 = scanner.nextInt();
        if(changeNum_1 < 1 || changeNum_1 > 8 || changeNum_2 < 1 || changeNum_2 > 8) {
            System.out.println("잘못 입력하셨습니다. 다시 입력해 주세요.\n");
        }
        }while(changeNum_1 < 1 || changeNum_1 > 8);

        int[] changeNumArry = new int[2];
        
        changeNumArry[0] = changeNum_1;
        changeNumArry[1] = changeNum_2;
        
        return changeNumArry;
    }
    static int[] changeNumber(int changeNum_1, int changeNum_2, int[] changeObject) {

        int changeIdx_1 = 0, changeIdx_2 = 0;
        int tmp = 0;

        for (int i = 0; i < 8; i++) {
            if (changeObject[i] == changeNum_1)
                changeIdx_1 = i;
        }
        for (int j = 0; j < 8; j++) {
            if (changeObject[j] == changeNum_2)
                changeIdx_2 = j;
        }

        changeObject[changeIdx_1] = changeNum_2;
        changeObject[changeIdx_2] = changeNum_1;

        return changeObject;
    }
    static void startGame(int[] puzzleNumber) {
        int turn = 1;

        int[] rightAnswer = new int[] {1, 2, 3, 4, 5 ,6, 7, 8};

        while (true) {

            System.out.printf("turn %d\n",turn); // 턴 출력
            turn++;

            printNumber(puzzleNumber);
            int[] userNumber;
            userNumber = scanNumber(); // 두가지 숫자 입력 받기

            int changeNum_1, changeNum_2;
            changeNum_1 = userNumber[0];
            changeNum_2 = userNumber[1];

            puzzleNumber = changeNumber(changeNum_1, changeNum_2, puzzleNumber); // 두가지 숫자 교환

            if (Arrays.equals(rightAnswer,puzzleNumber)) { // 게임종료
                System.out.printf("축하합니다! %d턴만에 퍼즐을 완성하셨습니다!",turn);
                break;
            }
        }
    }
}