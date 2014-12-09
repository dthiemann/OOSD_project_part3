package org.uiowa.cs2820.engine;

import java.util.*;

public class Allocate {

  private static BitSet T = null;

  // constructor tries to get old BitSet
  // or if that fails, creates a new one
  private static void setup() { 
    if (T != null) return;
    T = new BitSet(); 
    BitSet W = null;
    try { W = (BitSet) CheckPoint.restore(); }
    catch (Exception e) { }
    if (W != null) T = W;
    }

  public static int allocate() {
    // find and allocate one bit
    setup();
    int i = T.nextClearBit(0);
    T.flip(i);  
    CheckPoint.save(T);
    return i;
    }

  public static void free( int areanumber ) {
    // let an allocated area be recycled
    setup();
    T.clear(areanumber);
    CheckPoint.save(T);
    }

  // for intializing databases, resetall()
  public static void resetall() {
    setup();
    T.clear();
    CheckPoint.save(T);
    }

  // method for unit testing purposes
  public static boolean inquire( int areanumber ) {
    setup();
    return T.get(areanumber);
    }
  }
