/**
 * File: CS106A_ACMHierarchy.java
 * ----------------------------
 * This Java program draws a partial version of the 
 * acm.program class hierarchy diagram. ACM stands for 
 * Association for Computing Machinery; It's where most
 * the methods I work with come from.
 * 
 */

import acm.program.*;
import acm.graphics.*;


public class CS106A_ACMHierarchy extends GraphicsProgram
{	
	//private HierarchyBox HIERARCHY_BOX_CLASS = new HierarchyBox();
	private final int BOX_WIDTH = 30;
	private final int BOX_HEIGHT = 15;
	private final int PADDING = 20;
	private GPoint PARENT_ANCHOR_POINT = new GPoint(0,0);
	private HierarchyBox currentBox;
	private HierarchyBox[] rectArray; 
	
	public void run()
	{ 
		createBox(ACMClassEnums.PROGRAM);
		createBox(ACMClassEnums.GRAPHICS_PROGRAM);
		createBox(ACMClassEnums.CONSOLE_PROGRAM);
		createBox(ACMClassEnums.DIALOG_PROGRAM);
	}
	
	
	private void createBox(ACMClassEnums classType)
	{
		if (classType.parent == true) { createParentBox(classType); }
		else { createChildBox(classType); }
	}

	
	private void createParentBox(ACMClassEnums classType)
	{
		double x = (getWidth() / 2) - (BOX_WIDTH / 2);
		double y = (getHeight() / 2) - (BOX_HEIGHT / 2);
		GPoint gPoint = new GPoint(x,y);
		
		currentBox = new HierarchyBox();
		currentBox.createBox(classType, gPoint);
		
		
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
	
	
	private void createChildBox(ACMClassEnums acmClass)
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