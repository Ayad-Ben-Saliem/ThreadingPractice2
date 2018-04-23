package edu.kse.threadingpractice;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SoundClipTest {

    public SoundClipTest(String audioFileURI) {
        try {
            File soundFile = new File(audioFileURI);
            InputStream in = new FileInputStream(soundFile);
            AudioStream audioStream = new AudioStream(in);
            AudioPlayer.player.start(audioStream);
        } catch (IOException e) { }
    }
}