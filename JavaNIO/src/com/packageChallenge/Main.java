package com.packageChallenge;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try(FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel()){

            ByteBuffer buffer = ByteBuffer.allocate(100);
            byte[] outputByte = "Hello World!".getBytes();
            buffer.put(outputByte);
            buffer.putInt(245);
            buffer.putInt(-9876);
            byte[] outputBytes = "Nice to meet you".getBytes();
            buffer.put(outputByte);
            buffer.putInt(1000);
            buffer.flip();
            binChannel.write(buffer);




//            ByteBuffer buffer = ByteBuffer.allocate(outputByte.length);
//            buffer.put(outputByte);
//
//            buffer.flip();
//
//            int numbytes = binChannel.write(buffer);
//            System.out.println("numbytes writte was : " + numbytes);
//
//            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
//            intBuffer.putInt(245);
//            intBuffer.flip();
//            numbytes = binChannel.write(intBuffer );
//            System.out.println("numbytes written was:  " + numbytes);
//
//            intBuffer.flip();
//            intBuffer.putInt(-9876);
//            intBuffer.flip();
//            numbytes = binChannel.write(intBuffer);
//            System.out.println("numbytes written was:  " + numbytes);
//
//
//
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            FileChannel channel = ra.getChannel();
//            outputByte[0] = 'a';
//            outputByte[1] = 'b';
//            buffer.flip();
//            long numBytesRead = channel.read(buffer);
//
//            if(buffer.hasArray()){
////
////              System.out.println("byte buffer = " + new String(buffer.array()));
//                System.out.println("byte buffer =  " + new String(outputByte));
//            }
//
////           ABSOLUTE READ
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            System.out.println(intBuffer.getInt(0)) ;
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt(0)) ;
//            System.out.println(intBuffer.getInt());
//
//
////=======================================================================================
////             RELATIVE READ
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            intBuffer.flip();
////            System.out.println(intBuffer.getInt());
////            intBuffer.flip();
////            numBytesRead = channel.read(intBuffer);
////            intBuffer.flip();
////            System.out.println(intBuffer.getInt());
//
//            channel.close();
//            ra.close();
//
//
//
////            System.out.println("ouputBytes = " + new String(outputByte));
//
//
//
//
//
//
////            ====================================================================================
//
//
////            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
////            byte[] b = new byte[outputByte.length];
////            ra.read(b);
////            System.out.println(new String(b));
////            long int1 = ra.readInt();
////            long int2 = ra.readInt();
////            System.out.println(int1);
////            System.out.println(int2);
//
//
////            ====================================================================================
//
////            FileInputStream file = new FileInputStream("data.txt");
////            FileChannel channel = file.getChannel();
////            Path dataPath = FileSystems.getDefault().getPath("data.txt");
////
////            Files.write(dataPath, "\nline 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
////            List<String> lines = Files.readAllLines(dataPath);
////            for(String line : lines){
//                System.out.println(line);
//            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
