package com.rau.common;

public class VolatileSampleTest extends Thread{
    //static boolean isStopped; //child never ending because isStopped = true; not reflected in shared memory of the thread. to fix this use volatile
    static volatile boolean isStopped;//this cause child end
    public void run(){
        int count=1;
        while (!isStopped){
            count++;
        }
        System.out.println("child thread end count:"+count);
    }
    public static void main(String[] args) throws Exception{
        VolatileSampleTest v = new VolatileSampleTest();
        v.start();
        Thread.sleep(1000);
        isStopped = true;
        System.out.println("Main thread end count:");
    }
}
