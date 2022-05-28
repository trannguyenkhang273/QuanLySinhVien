/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.QLSV.Utility;

import com.QLSV.Utility.Auth;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.*;
/**
 *
 * @author Tho
 */
public class NhacNen {
    public static File file=null;
    public static AudioInputStream audio=null;
    public static Clip clip=null;
    public static int nhac=0;

    public static void NhacNen() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
         file =new File(Auth.class.getResource("/com/QLSV/Audio/beat.wav").getFile());
         audio= AudioSystem.getAudioInputStream(file); 
         clip =AudioSystem.getClip();
//         clip.open(audio);
    }
    public static void stop(){
        if(nhac==0){
            clip.start();nhac++;
        }else{
            clip.stop();nhac--;
        }
    }
}
