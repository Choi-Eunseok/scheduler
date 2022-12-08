import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

public class clockThread extends Thread {
	
	main m;
	Date time;
	String alarm_list[] = {"08:20", "08:40", "09:30", "09:40", "10:30", "10:40", "11:30", "11:40", "12:30",
			"13:25", "13:30", "14:20", "14:30", "15:20", "15:40", "16:30"};
	int one = 0;
	AudioInputStream inputStream;
	
	public clockThread(main m) {
		this.m = m;
		start();
	}
	
	public void run() {
		while(true) {
			time = new Date();
			m.clock[0].setText(Integer.toString(time.getHours()));
			m.clock[1].setText(Integer.toString(time.getMinutes()));
			m.clock[2].setText(Integer.toString(time.getSeconds()));
			for(int i = 0; i < alarm_list.length; i++) {
				String[] temp = alarm_list[i].split(":");
				int ah = Integer.parseInt(temp[0]);
				int am = Integer.parseInt(temp[1]);
				if(ah == time.getHours() && am == time.getMinutes() && time.getSeconds() == 0 && one == 0) {
					Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
					try {
						inputStream = AudioSystem.getAudioInputStream(new File("C:\\1.wav"));
					} catch (UnsupportedAudioFileException e) {} catch (IOException e) {}
					int mixer_index = Integer.parseInt(m.inde[m.device.getSelectedIndex()]);
					Mixer.Info info = mixerInfo[mixer_index];
					Clip clip;
					try {
						clip = AudioSystem.getClip(info);
						clip.open(inputStream);
				        clip.start();
					} catch (LineUnavailableException e) {} catch (IOException e) {}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		}
	}
}
