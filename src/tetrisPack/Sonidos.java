package tetrisPack;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sonidos {

	private Clip clip;
	private float bajar_volumen_audios = -10.0f;

	public Sonidos() {
	}

	public void cargar_audio(String ruta) {

		try {

			File sonido_aReproducir = new File(ruta);
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(sonido_aReproducir);

			clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			gainControl.setValue(bajar_volumen_audios);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void play_sonido() {
		
		if (clip != null) {
			clip.setFramePosition(0);
			clip.start();
		}
	}
	
	public void detener_sonido() {
		
		if (clip != null && clip.isRunning()) {
			clip.stop();
		}
	}
	
	public Clip getClip() {
		return clip;
	}
}
