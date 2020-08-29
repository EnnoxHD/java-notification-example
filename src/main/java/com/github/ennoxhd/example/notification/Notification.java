package com.github.ennoxhd.example.notification;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Notification {
	public static void main(String[] args) {
		if(SystemTray.isSupported()) {
			SystemTray systemTray = SystemTray.getSystemTray();
			Image image = Toolkit.getDefaultToolkit().createImage(Notification.class.getClassLoader().getResource("java-icon.png"));
			TrayIcon trayIcon = new TrayIcon(image, "Tooltip of TrayIcon");
			trayIcon.setImageAutoSize(true);
			trayIcon.addMouseListener(new MouseListener() {
				@Override
				public void mouseReleased(MouseEvent e) {
					return;
				}
				@Override
				public void mousePressed(MouseEvent e) {
					return;
				}
				@Override
				public void mouseExited(MouseEvent e) {
					return;
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					return;
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					systemTray.remove(trayIcon);
					System.out.println("Icon: http://icons.iconarchive.com/icons/papirus-team/papirus-apps/16/java-icon.png");
					System.exit(0);
				}
			});
			try {
				systemTray.add(trayIcon);
			} catch (AWTException e) {
				e.printStackTrace();
				System.exit(2);
			}
			trayIcon.displayMessage("Caption of Message", "This is the text of the Message", MessageType.INFO);
		} else {
			System.err.println("Systemtray is not supported!");
			System.exit(1);
		}
	}
}
