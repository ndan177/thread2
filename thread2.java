package javaapplication8;

import java.util.Timer;
import java.util.TimerTask;

class Stop extends Thread{
    private boolean stopThread =false;
    private int counter= 0;
    public void run(){
        while(!stopThread && counter < 12000){
            System.out.println(counter++);
            
        }
        if(stopThread){
            System.out.println("A requested stop has been made.");
        }
        
    }
    public void requestStop(){
        stopThread = true;
    }
}
public class JavaApplication8 {
    public static void main(String[] args) {
        final Stop ob= new Stop();
        ob.start();
        new Timer(true).schedule(new TimerTask(){
            public void run(){
                System.out.println("A stop has been requested for the thread.");
                ob.requestStop();
            }
        },275);
        
    }
    
}
