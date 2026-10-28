
package src.Audio;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import java.io.File;

/**
 * Provides playback of sound effects for the game.
 *
 * <p>Audio playback runs independently of the game loop.</p>
 *
 * @version 1.0
 */
public final class AudioPlayer {

    private AudioPlayer() {
        // Utility class.
    }

    /**
     * Plays a WAV audio file.
     *
     * @param path path to the audio file
     */
    public static void play(String path) {
        try {
            File file = new File(path);

            try (AudioInputStream audio =
                         AudioSystem.getAudioInputStream(file)) {

                Clip clip = AudioSystem.getClip();
                clip.open(audio);

                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                });

                clip.start();
            }
        } catch (Exception e) {
            System.err.println(
                    "Could not play sound '" + path + "': "
                            + e.getMessage()
            );
        }
    }
}
