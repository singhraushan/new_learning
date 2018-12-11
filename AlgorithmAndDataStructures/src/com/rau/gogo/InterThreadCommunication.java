/**
 * 
 */
package com.rau.gogo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Raushan kumar
 *
 */
public class InterThreadCommunication {

	public static void main(String[] args) {
		Shared shared = new Shared();
		Thread1 t1 = new Thread1(shared);
		Thread2 t2 = new Thread2(shared);

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Main end!");
	}

}

class Thread1 extends Thread {
	Shared s;

	Thread1(Shared s) {
		this.s = s;
		start();
	}

	@Override
	public void run() {
		try {
			boolean isFileReading = true;
			while (isFileReading) {
				isFileReading = s.readWrite();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Thread2 extends Thread {
	Shared s;

	Thread2(Shared s) {
		this.s = s;
		start();
	}

	@Override
	public void run() {
		try {
			boolean isFileWriting = true;
			while (isFileWriting) {
				isFileWriting = s.write();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Shared {
	boolean flag;
	String line;
	BufferedWriter bw1, bw2;
	BufferedReader br;

	Shared() {
		try {
			bw2 = new BufferedWriter(new FileWriter("D:/output.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	synchronized boolean readWrite() {

		try {
			if (flag) {
				wait();
			}
			br = new BufferedReader(new FileReader("D:/input.txt"));
			if ((line = br.readLine()) != null) {
				this.line = line;
				StringBuilder sb = new StringBuilder();
				String line2;
				while((line2 = br.readLine()) != null){
					sb.append(line2);
					sb.append("\n");
				}
				br.close();
				bw1 = new BufferedWriter(new FileWriter("D:/input.txt"));
				bw1.write(sb.toString().trim());
				bw1.flush();
				System.out.println("Available in 1st file: "+sb.toString());
			} else {
				this.line = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		flag = true;
		notify();
		if (line != null && !line.isEmpty())
			return true;
		else
			return false;
	}

	synchronized boolean write() {
		try {
			if (!flag) {
				wait();
			}
			System.out.println("writing in 2nd file line: " + line);
			
			if(line!=null && !line.isEmpty())
			bw2.write(line);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		flag = false;
		notify();
		if (line != null && !line.isEmpty())
			return true;
		else {
			try {
				bw2.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}
			
	}
}
