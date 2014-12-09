package org.uiowa.cs2820.engine;

import java.io.*;

//Utility class has useful generally used 
//functions
public class Utility {
public static byte[] convert(Object O) {
 // converts objects into byte array
 // this code copies from Java tutorials
 // the Object O needs to have "implements Serializable"
 ByteArrayOutputStream M = new ByteArrayOutputStream();
 ObjectOutput N = null;
 try {
   N = new ObjectOutputStream(M);
   N.writeObject(O);
   } 
 catch (IOException e) {
   System.err.println("convert failure: " + e);
   return null; // wrong, but should not happen	    	
   }
 return M.toByteArray();
 }
	
public static Object revert(byte[] seq) {
 // revert does the converse of what convert does
 Object O = null;  // default value
 try {
   ByteArrayInputStream M = new ByteArrayInputStream(seq);
   ObjectInputStream N = new ObjectInputStream(M);
   O = N.readObject();
   }
 catch (Exception e) { };
   return O;
 }
}
