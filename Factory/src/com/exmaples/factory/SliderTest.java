package com.exmaples.factory;

import java.util.Dictionary;
import java.util.Hashtable;

// Пример использования ползунков
import javax.swing.BoundedRangeModel;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTest extends JFrame {
	private JLabel label;

	public SliderTest() {
		super("Пример использования ползунков JSlider");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Таблица с надписями ползунка
		Dictionary<Integer, JLabel> labels = new Hashtable<Integer, JLabel>();
		labels.put(new Integer(0), new JLabel("<html><font color=red size=3>0"));
		labels.put(new Integer(60), new JLabel("<html><font color=gray size=3>30"));
		labels.put(new Integer(120), new JLabel("<html><font color=blue size=4>60"));
		labels.put(new Integer(180), new JLabel(new ImageIcon("images/star.png")));

		// Создание модели ползунков
		BoundedRangeModel model = new DefaultBoundedRangeModel(80, 0, 0, 200);

		// Создание ползунков
		JSlider slider1 = new JSlider(0, 80, 20);
		JSlider slider2 = new JSlider(0, 80, 20);
		JSlider slider3 = new JSlider(0, 80, 20);
		JSlider slider4 = new JSlider(0, 80, 20);
		JSlider slider5 = new JSlider(0, 80, 20);
		JSlider slider6 = new JSlider(0, 80, 20);
		JSlider slider7 = new JSlider(0, 80, 20);
		JSlider slider8 = new JSlider(0, 80, 20);

		slider2.setPaintLabels(true);
		slider2.setMajorTickSpacing(10);

		slider3.setPaintLabels(true);
		slider3.setMajorTickSpacing(10);

		// slider4.setLabelTable(labels);
		// slider4.setPaintLabels(true);

		label = new JLabel(getPercent(slider1.getValue()));
		// присоединяем слушателя
		slider1.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// меняем надпись
				int value = ((JSlider) e.getSource()).getValue();
				label.setText(getPercent(value));
			}
		});
		// Размещение ползунков в интерфейсе
		JPanel contents = new JPanel();
		contents.add(slider1);
		// contents.add(comp, constraints);
		contents.add(slider2);
		// contents.add(name, comp)
		contents.add(slider3);
		contents.add(slider4);
		contents.add(slider5);
		contents.add(slider6);
		contents.add(slider7);
		contents.add(slider8);
		getContentPane().add(contents);
		// getContentPane().add(label, BorderLayout.SOUTH);
		// Вывод окна на экран
		setSize(700, 300);
		setVisible(true);
	}

	private String getPercent(int value) {
		return "Размер : " + value / 2 + "%";
	}

	public static void main(String[] args) {
		new SliderTest();
	}
}
