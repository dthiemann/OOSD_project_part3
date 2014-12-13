package org.uiowa.cs2820.engine;

import java.io.*;
import java.nio.file.*;
import java.util.*;

// This class provides methods to access areas randomly
// in a disc file. The file can grow as needed, but each
// area has a fixed (upper limit) size. 
public class DiskSpace {
  static final String filename = "Resources/diskspace.dat";
  static final int AREASIZE = 1024;
  static final int LIMIT = AREASIZE - 2;
  // encode is a class method (function) producing a 2-byte
  // array that encodes an integer equal to length of
  // a given array. The "Java" way to do encoding is
  // something like this:
  //    ByteBuffer X = ByteBuffer.allocate(2);
  //    X.putShort(source.length);
  // The "C" way is below, which is actually faster.
  public static byte[] encode( byte[] source ) {
    int n = source.length;
    byte [] result = new byte[2];
    result[0] = (byte) (n / 256);
    result[1] = (byte) n;
    return result;
    }
  // decode is a function that does the converse of encode
  // The "Java" way to decode is X.getShort(0) where X is
  // a ByteBuffer, but then you have to first insert the
  // two bytes into the ByteBuffer, so the code is about
  // as long as the "C" method below.
  public static int decode( byte[] thesize ) {
    int n = (int)thesize[0];  // high order part of size
    if (n < 0) n += 256;
    n *= 256;  
    int m = (int) thesize[1];
    if (m < 0) m += 256;
    return n + m;
    }
  // write(area,buffer) stores the buffer at the 
  // specified area & remembers the buffer length on disk
  public static void write( int area, byte[] stuff ) {
    assert (stuff.length < LIMIT);
    try {
      RandomAccessFile F = new RandomAccessFile(filename,"rw");     
      long position = area * AREASIZE;
      // ready the file F for writing to specified area
      F.seek(position);
      // first encode length, write that, then write stuff 
      F.write(encode(stuff));
      F.write(stuff);
      F.close();
      }
    catch (Exception e) { 
      System.err.println("DiskSpace write error: " + e); 
      e.printStackTrace();
      }
    }
  public static byte[] read( int area ) {
    try {
      RandomAccessFile F = new RandomAccessFile(filename,"rw");     
      long position = area * AREASIZE;
      F.seek(position);
      byte[] size = new byte[2];
      F.read(size);
      byte[] buffer = new byte[decode(size)];
      F.read(buffer);
      F.close();
      return buffer;
      }
    catch (Exception e) { return new byte[0]; }
    }
  // reset() is for unit or integration testing, it 
  // erases the entire file
  public static void reset() {
	
    try { 
      Path P = FileSystems.getDefault().getPath(filename);
      Files.delete(P); 
      }
    catch (Exception e) { }
    }
  }

