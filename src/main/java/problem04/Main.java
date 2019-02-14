package problem04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		Random ran = new Random();
		int ranNum = ran.nextInt(999);
		int[] ranNumArray = { ranNum / 100, ranNum % 100 / 10, ranNum % 100 % 10 };

		int S = 0;
		int B = 0;
		int O = 0;
		int N = 0;

		Scanner sc = new Scanner(System.in);
		int input;
		int[] check = new int[3];

		while (true) {
			System.out.print("> ");
			input = sc.nextInt();
			check[0] = input / 100;
			check[1] = input % 100 / 10;
			check[2] = input % 100 % 10;
			N++;
			for (int i = 0; i < ranNumArray.length; i++) {
				for (int j = 0; j < check.length; j++) {
					if (ranNumArray[i] == check[j]) {
						if (i == j) {
							S += 1;
						} else
							B += 1;
					}
				}
			}

			if (S > 0 || B > 0) {
				System.out.println(N + " - S : " + S + ", B : " + B + ", O : " + O);
			} else {
				O++;
				System.out.println(N + " - S : " + S + ", B : " + B + ", O : " + O);
			}
			if (S == 3) { // 3 스트라이크 일때 종료
				System.out.println("(종료)");
				filew(ranNum, S, B, O, N);
				break;
			}
			S = 0;
			B = 0;
		}
	}

	static void filew(int ranNum, int S, int B, int O, int N) throws Exception {
		File file = new File("C:/Users/bit-user/git/solution-type-a/src/main/java/problem04/Main.txt");
		int num = 1;
		if (file.isFile()) {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			while (br.readLine() != null) {
				num = br.read();
			}
			num++;
			br.close();
		}
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(num + " : " + ranNum + "/" + N + " : " + S + " " + B + O);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}