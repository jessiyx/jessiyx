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
		System.out.println("请输入需要查询的单词 :");
		String string = in.nextLine();
		word = string.split(",");
		for (int i = 0; i < word.length; i++) {
			for (Map.Entry<String, Integer> num : map.entrySet()) {
				if (word[i].equals(num.getKey())) {
					System.out.println("单词" + num.getKey() + "出现" + num.getValue() + "次");
				}

			}
		}
		return word;

	}

	public Find(String[] word, Map<String, Integer> wordsCount) {
		super();
		this.word = word;
		this.wordsCount = wordsCount;
		setTitle("绘制柱形图");
		setBounds(word.length, 200, 450, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Find() {
	}

	@Override
	public void paint(Graphics g) {

		int Width = getWidth();
		int Height = getHeight();
		int leftMargin = 50;// 柱形图左边界
		int topMargin = 50;// 柱形图上边界
		Graphics2D g2 = (Graphics2D) g;
		int ruler = Height - topMargin;
		int rulerStep = ruler / 20;// 将当前的高度评分为20个单位
		g2.setColor(Color.WHITE);// 绘制白色背景
		g2.fillRect(0, 0, Width, Height);// 绘制矩形图
		g2.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i < rulerStep; i++) {
			g2.drawString((400 - 20 * i) + "个", 8, topMargin + rulerStep * i);// 绘制Y轴上的数据
		}
		g2.setColor(Color.BLUE);
		int m = 0;
		for (int i = 0; i < word.length; i++) {
			int value = wordsCount.get(word[i]);
			int step = (m + 1) * 40;// 设置每隔柱形图的水平间隔为40
			g2.fillRoundRect(leftMargin + step * 2, Height - value, 40, value, 0, 0);// 绘制每个柱状条
			g2.drawString(word[i], leftMargin + step * 2, Height - value - 5); // 标识每个柱状条
			m++;
		}
	}
}
