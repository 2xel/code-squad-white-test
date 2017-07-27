package string_edit;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Program {
	public static void main(String[] args) {
		Program program = new Program();
		String inputSentence = program.InputSentence();
		program.reverceStatistics(inputSentence);
		program.countStatistics(inputSentence);
	}

	// 문장입력
	public String InputSentence() {
		System.out.println("문장을 입력해주세요.(특수문자는  . ? ! 만 가능)");
		Scanner scanner = new Scanner(System.in);
		String pattern = "^[a-zA-Z\\s!?.]*$"; // 알파벳 대소문자, 공백, !?. 허용

		// pattern과 일치할때까지 반복
		while (true) {
			String inputSentence = scanner.nextLine();
			if (Pattern.matches(pattern, inputSentence)) {
				return inputSentence;
			} else {
				System.out.println("잘못된 문장을 입력하셨습니다.");
				System.out.println("문장을 다시 입력해주세요.(특수문자는 . ? ! 만 가능)");
				continue;
			}
		}
	}

	// 1.문장의 단어를 역순으로 출력
	public void reverceStatistics(String inputSentence) {
		String removeSentence = inputSentence.replaceAll("\\p{Punct}", ""); // 특수문자제거
		String[] splitSentence = removeSentence.split(" "); // 공백으로 문장나누기
		for (int i = splitSentence.length - 1; i >= 0; i--) {
			System.out.print(splitSentence[i] + " ");
		}
		System.out.println();
	}

	// 2.문장에 포함되어 있는 알파벳의 전체 수를 출력
	public void countStatistics(String inputSentence) {
		String count = inputSentence.replaceAll("\\p{Space}", ""); // 공백제거
		String count2 = count.replaceAll("\\p{Punct}", ""); // 특수문자제거
		System.out.println("전체 수 : " + count2.length());
	}
}