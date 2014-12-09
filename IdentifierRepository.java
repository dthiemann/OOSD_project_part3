/**
 * 
 * @author Raymond
 *
 */
package org.uiowa.cs2820.engine;

import java.util.*;

//Iterator pattern requires that this implements the Handler
public class IdentifierRepository(int head) implements Handler{
	//this code is from the getAllIds class
	//it is used to get the array list of the strings
	// head is the disk area of the first Identifier in linked list
    DiskLinkedList D = new DiskLinkedList(head);
    CollectIds idlist = new CollectIds();  
    D.traverse(idlist);
    String [] R = (idlist.C).toArray(new String[idlist.C.size()]);
    
    
}
