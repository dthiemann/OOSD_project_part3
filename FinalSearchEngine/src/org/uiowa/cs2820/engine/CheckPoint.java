package org.uiowa.cs2820.engine;
import java.io.*;
import java.nio.file.*;
import java.util.*;

// This class is a single-purpose class to save/restore
// an Object into a file.  The statements are copied from
// one of the Java tutorials on file I/O 
public class CheckPoint {
  static final String filename = "Resources/checkpoint.dat";
  public static void save( Object O ) {
    FileOutputStream out = null;     
    byte[] Source = Utility.convert(O);
    if (Source == null) return;  
    try {
      out = new FileOutputStream(filename);
      out.write(Source);
      out.close();
      } 
    catch (Exception e) { }
    }
  public static Object restore() {
    Object Result = null;
    FileInputStream in = null;     
    try {
      // first, discover how many bytes are in file
      File F = new File(filename);
      int filesize = (int) F.length();
      in = new FileInputStream(filename);
      // read all the bytes into a byte array  
      byte[] Source = new byte[filesize];
      in.read(Source);
      Result = Utility.revert(Source);
      } 
    catch (Exception e) { }
    return Result;
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