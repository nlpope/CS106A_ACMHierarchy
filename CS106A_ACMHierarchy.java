/**
 * File: CS106A_ACMHierarchy.java
 * ----------------------------
 * This Java program draws a partial version of the 
 * acm.program class hierarchy diagram. ACM stands for 
 * Association for Computing Machinery; It's where most
 * the methods I work with come from.
 * 
 * algorithm based on below link:
 * https://duckduckgo.com/?q=how+to+shrink+a+java+goval+bounding+box+towards+its+center&ia=web
 *
 *!!! I NEED TO ADD A NEW CLASS FOLDER TO BE ABLE TO DEFINE
 *ACMCLASSBOX CREATIONS, BUT HOW DO I DO THAT WITHOUT...
 *I THINK I JUST NEED TO MOVE THE CONTENTS OF ACMCLASSBOX
 *INTO ITS OWN SEPARATE PROJECT.
 */

import acm.program.*;
import acm.graphics.*;
//import ACMClassBox.*;


public class CS106A_ACMHierarchy extends GraphicsProgram
{	
	private final int BOX_WIDTH = 30;
	private final int BOX_HEIGHT = 15;
	private final int PADDING = 20;
	private GPoint PARENT_ANCHOR_POINT = new GPoint(0,0);
	private GRect currentBox;
	private ACMClassBox[] rectArray; 
	
	public void run()
	{ 
		createHierarchyBox(ACMClasses.PROGRAM);
		createHierarchyBox(ACMClasses.GRAPHICS_PROGRAM);
		createHierarchyBox(ACMClasses.CONSOLE_PROGRAM);
		createHierarchyBox(ACMClasses.DIALOG_PROGRAM);
	}
	
	
	private void createHierarchyBox(ACMClasses acmClass)
	{
		if (acmClass.parent == true) { createParentBox(acmClass); }
		else { createChildBox(acmClass); }
	}
	
	
	private void createParentBox(ACMClasses acmClass)
	{
		double x = (getWidth() / 2) - (BOX_WIDTH / 2);
		double y = (getHeight() / 2) - (BOX_HEIGHT / 2);
		
		currentBox = new ACMClassBox(
				x,
				y,
				BOX_WIDTH,
				BOX_HEIGHT
		);
		
		
		PARENT_ANCHOR_POINT = new GPoint(
				currentBox.getX() + currentBox.getWidth() / 2,
				currentBox.getY() + currentBox.getHeight()
		);
		
		GLabel classLabel = new GLabel(
				acmClass.name, 
				currentBox.getX() + (currentBox.getWidth() / 2), 
				currentBox.getY() + (currentBox.getHeight() / 2)		
		);	
		
		add(currentBox);
		add(classLabel);
		rectArray[0] = currentBox;
	}
	
	
	private void createChildBox(ACMClasses acmClass)
	{
		int i = rectArray.length + 1;
		String className;
		double x;
		double y = PARENT_ANCHOR_POINT.getY() + BOX_HEIGHT;
		
		switch (acmClass) {
		case GRAPHICS_PROGRAM: 
			x = (PARENT_ANCHOR_POINT.getX() - (BOX_WIDTH * 1.5)) - PADDING;
			className = acmClass.name;
			break;
			
		case CONSOLE_PROGRAM:
			x = (PARENT_ANCHOR_POINT.getX() - BOX_WIDTH / 2) - PADDING;
			className = acmClass.name;
			break;
			
		case DIALOG_PROGRAM:
			x = (PARENT_ANCHOR_POINT.getX() - BOX_WIDTH / 2) - PADDING;
			className = acmClass.name;
			break;
			
		default: 
			x = 0; 
			className = acmClass.name;
			break;
		}
		
		currentBox = new GRect(
				x,
				y,
				BOX_WIDTH,
				BOX_HEIGHT
		);
		
		
		
		GLabel classLabel = new GLabel(
				className,
				currentBox.getX() + (currentBox.getWidth() / 2),
				currentBox.getY() + (currentBox.getHeight() / 2)
		);
		
		add(currentBox);
		add(classLabel);
		rectArray[i] = currentBox;
		connect(currentBox, rectArray[0]);
	}
	
	
	private void connect(GRect child, GRect toParent)
	{
		GLine connectorLine = new GLine(
			0,
			0,
			0,
			0
		);
		
		add(connectorLine);
	}
}