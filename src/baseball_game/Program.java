package baseball_game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {

		// 컴퓨터가 문제 생성
		List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Collections.shuffle(number);
		int[] createAnswer = new int[3];
		for (int i = 0; i < 3; i++) {
			createAnswer[i] = number.get(i);
		}

		// 사용자에게 답변 받기
		int attempt = 1;
		while (true) {
			Scanner scanner = new Scanner(System.in);
			int[] userAnswer = new int[3];
			for (int i = 0; i < 3; i++) {
				System.out.println(attempt + "번째 시도 숫자를 입력해주세요.(1~9까지 숫자, 중복불가)");
				System.out.print((i + 1) + "번째 숫자 : ");
				userAnswer[i] = scanner.nextInt();

				// 1~9까지 숫자가 아닌수 입력시
				if (userAnswer[i] < 1 || userAnswer[i] > 9) {
					System.out.println("1~9까지 숫자만 입력하세요.");
					i--;
				}

				// 중복된 값 입력시
				for (int j = 0; j < i; j++) {
					if (userAnswer[i] == userAnswer[j]) {
						System.out.println("중복된 값이 존재합니다.");
						i--;
					}
				}
			}

			// 판정
			int strike = 0;
			int ball = 0;

			// 스트라이크 판정
			for (int i = 0; i < 3; i++) {
				if (createAnswer[i] == userAnswer[i]) {
					strike += 1;
				}
			}
			// 볼 판정
			ArrayList createAnswerArray = new ArrayList<>();
			for (int i = 0; i < 3; i++) {
				createAnswerArray.add(createAnswer[i]);
			}
			for (int i = 0; i < 3; i++) {
				if (createAnswerArray.contains(userAnswer[i]) && createAnswer[i] != userAnswer[i]) {
					ball += 1;
				}
			}

			if (strike == 3) {
				System.out.println("정답을 맞추셨습니다. 게임을 종료합니다.");
				break;
			} else {
				System.out.println(strike + " 스트라이크, " + ball + " 볼");
				System.out.println("다시 시도합니다.");
				attempt += 1;
				continue;
			}
		}
	}
}
