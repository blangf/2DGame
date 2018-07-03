package engine.audio;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SoundClip {

    private Clip clip = null;
    private FloatControl gain;

    public SoundClip(String path) {

        try {
            InputStream audioSrc = SoundClip.class.getResourceAsStream(path);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream ais = AudioSystem.getAudioInputStream(bufferedIn);
            AudioFormat baseFormat = ais.getFormat();
            AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                                                        baseFormat.getSampleRate(),
                                                        16,
                                                        baseFormat.getChannels(),
                                                        baseFormat.getChannels() * 2,
                                                        baseFormat.getSampleRate(),
                                                        false);

            AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);

            clip = AudioSystem.getClip();
            clip.open(dais);

            gain = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play(){
        if(clip == null){
            return;
        }

        stop();
        clip.setFramePosition(0);
        while (!clip.isRunning()){
            clip.start();
        }
    }

    public void stop(){
        if(clip.isRunning()){
            clip.stop();
        }
    }

    public void close(){
        stop();
        clip.drain();
        clip.close();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        play();
    }

    public void setVolume(float value){
        gain.setValue(value);
    }

    public boolean isRunning(){
        return clip.isRunning();
    }
}
