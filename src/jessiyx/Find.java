package jessiyx;

import java.util.Map;
import java.util.Scanner;

public class Find {
	void find(Map<String, Integer> map) {
		Scanner in = new Scanner(System.in);

		System.out.println("��������Ҫ��ѯ�ĵ��� :");
		String string = in.nextLine();
		String[] word = string.split(",");
		float sum;
		for (int i = 0; i < word.length; i++) {
			for (Map.Entry<String, Integer> num : map.entrySet()) {
				if (word[i].equals(num.getKey())) {
					sum = (float) (num.getValue()) / 100;
					for (int j = 0; j < sum; j++) {
						System.out.print("��" + "\n");

					}
					System.out.print(num.getKey());
					System.out.println("����" + num.getKey() + "����" + num.getValue() + "��");
				}

			}
		}

	}
}
