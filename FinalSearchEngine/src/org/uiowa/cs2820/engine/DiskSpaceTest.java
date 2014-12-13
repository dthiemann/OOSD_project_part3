package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiskSpaceTest {

  @Test
  public void test() {
    DiskSpace.reset();
    byte [] A = new byte[500];
    for (int i=0; i<A.length; i++) A[i] = (byte)'*';
    DiskSpace.write(55,A);
    for (int i=0; i<A.length; i++) A[i] = (byte)'K';
    DiskSpace.write(21,A);
    byte [] B = DiskSpace.read(21);
    assertEquals(B.length,500);
    assertEquals((char)B[0],'K');
    assertEquals((char)B[B.length-1],'K');
    B = DiskSpace.read(55);
    assertEquals(B.length,500);
    B = DiskSpace.read(0);
    assertEquals(B.length,0);
    } 
  }
