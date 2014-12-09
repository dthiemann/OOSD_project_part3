package org.uiowa.cs2820.engine;

import static org.junit.Assert.*;

import org.junit.Test;

public class NodeTest {

  @Test
  public void test() {
	Field F = new Field("x","y");
	Field G = new Field("a","b");
	Node T = Node.newNode(F);
	Node U = Node.newNode(G);
	Node S = Node.findNode(G);
	Node R = Node.findNode(F);
	assertEquals(U.location,S.location);
	assertEquals(R.location,T.location);
    }

  }
