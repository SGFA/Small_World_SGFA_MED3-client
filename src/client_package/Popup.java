package client_package;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.newdawn.slick.AppletGameContainer;
import org.newdawn.slick.AppletGameContainer.Container;
import org.newdawn.slick.Game;

import javafx.scene.input.MouseButton;
import javafx.stage.PopupWindow;

public class Popup extends JDialog implements MouseListener {

	private int shopSize = arrayDeterminator();

	public Popup() {

		this.addMouseListener(this);
		this.setTitle("Combo Shop");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(shopSize, 2));
		this.getContentPane().setBackground(new Color(248, 245, 228));
		this.setResizable(false);
		// this.setModalityType(Dialog.ModalityType.DOCUMENT_MODAL);

		for (int i = 0; i < shopSize; i++) {

			JPanel abilityPane = new JPanel(new FlowLayout(10, 10, 10));
			abilityPane.setBackground(new Color(248, 245, 228));
			JLabel ability = new JLabel(getComboImage("abilities/" + GameController.stack.abilityStack.get(i).name));
			abilityPane.add(ability);
			this.add(abilityPane);

			JPanel racePane = new JPanel(new FlowLayout(10, 10, 10));
			racePane.setBackground(new Color(248, 245, 228));
			JLabel race = new JLabel(getComboImage("races/" + GameController.stack.raceStack.get(i).name));
			racePane.add(race);

			this.add(racePane);

		}

		this.setVisible(true);

	}

	/**
	 * Method to fetch the image from assets/races corresponding to the target
	 * race.
	 * 
	 * @param location
	 *            the race image you want to fetch, eg. "races/orcs" or
	 *            "abilities/seafaring".
	 * @return the corresponding image as an ImageIcon
	 * @see javax.swing.ImageIcon
	 */
	public ImageIcon getComboImage(String location) {
		ImageIcon localImage;

		localImage = new ImageIcon("./assets/" + location + ".png");

		Image localimg = localImage.getImage();
		Image newimg = localimg.getScaledInstance(240, 80, java.awt.Image.SCALE_SMOOTH);
		localImage = new ImageIcon(newimg);

		return localImage;

	}

	/**
	 * Checks which of the stack's amount of abilities and races that is smaller
	 * and returns that integer. For use in avoiding IndexOutOfBounds errors in
	 * the shop.
	 * 
	 * @return smallest integer of GameController.stack.abilityStack.size() and
	 *         GameController.stack.raceStack.size())
	 */
	private int arrayDeterminator() {
		if (GameController.stack.abilityStack.size() < GameController.stack.raceStack.size()) {
			return GameController.stack.abilityStack.size();
		} else
			return GameController.stack.raceStack.size();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		for (int j = 0; j < shopSize; j++) {
			for (int i = 0; i < 2; i++) {
				if (e.getX() > i * 600 / 2 && e.getX() < i * 600 / 2 + 300 && e.getY() > j * 600 / shopSize && e.getY() < j * 600 / shopSize + 600 /shopSize ) {
					GameController.setPair(GameController.CURRENT_ACTIVE_PLAYER, j);
				}
			}
		}
	}
}
