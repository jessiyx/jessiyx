package jessiyx;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFrame;

public class Find extends JFrame {

	private static final long serialVersionUID = 1L;
	public String[] word;
	public Map<String, Integer> wordsCount;

	String[] find(Map<String, Integer> map) {
		Scanner in = new Scanner(System.in);
		System.out.println("��������Ҫ��ѯ�ĵ��� :");
		String string = in.nextLine();
		word = string.split(",");
		for (int i = 0; i < word.length; i++) {
			for (Map.Entry<String, Integer> num : map.entrySet()) {
				if (word[i].equals(num.getKey())) {
					System.out.println("����" + num.getKey() + "����" + num.getValue() + "��");
				}

			}
		}
		return word;

	}

	public Find(String[] word, Map<String, Integer> wordsCount) {
		super();
		this.word = word;
		this.wordsCount = wordsCount;
		setTitle("��������ͼ");
		setBounds(word.length, 200, 450, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Find() {
	}

	@Override
	public void paint(Graphics g) {

		int Width = getWidth();
		int Height = getHeight();
		int leftMargin = 50;// ����ͼ��߽�
		int topMargin = 50;// ����ͼ�ϱ߽�
		Graphics2D g2 = (Graphics2D) g;
		int ruler = Height - topMargin;
		int rulerStep = ruler / 20;// ����ǰ�ĸ߶�����Ϊ20����λ
		g2.setColor(Color.WHITE);// ���ư�ɫ����
		g2.fillRect(0, 0, Width, Height);// ���ƾ���ͼ
		g2.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < rulerStep; i++) {
			g2.drawString((400 - 20 * i) + "��", 8, topMargin + rulerStep * i);// ����Y���ϵ�����
		}
		g2.setColor(Color.BLUE);
		int m = 0;
		for (int i = 0; i < word.length; i++) {
			int value = wordsCount.get(word[i]);
			int step = (m + 1) * 40;// ����ÿ������ͼ��ˮƽ���Ϊ40
			g2.fillRoundRect(leftMargin + step * 2, Height - value, 40, value, 0, 0);// ����ÿ����״��
			g2.drawString(word[i], leftMargin + step * 2, Height - value - 5); // ��ʶÿ����״��
			m++;
		}
	}
}
