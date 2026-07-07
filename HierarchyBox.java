import acm.program.*;
import acm.graphics.*;

public class HierarchyBox extends GraphicsProgram
{
	private static final int BOX_WIDTH = 30;
	private static final int BOX_HEIGHT = 15;
	public ACMClassEnums classType;
	//public boolean hasParent = false;
	public GPoint coord;
	public GRect rect;
	public GLabel label;
	public GPoint anchorPoint;
	
	public void createParent()
	{
		
	}
	
	
	public void createChild(GRect underParent)
	{
		
	}
	
	
	public void createBox(
			ACMClassEnums ofType,
			GPoint atCoord
	)
	{
		this.classType = ofType;
		
		this.rect = new GRect(
				atCoord.getX(),
				atCoord.getY(),
				BOX_WIDTH,
				BOX_HEIGHT		
		);
		
		this.label = new GLabel(
				ofType.name,
				rect.getX() + BOX_WIDTH / 2.0,
				rect.getY() + BOX_HEIGHT / 2.0
		);
		
		if (classType.parent == true) {
			anchorPoint = new GPoint(
					rect.getX() + rect.getWidth() / 2,
					rect.getY() + rect.getHeight()
			);
		} else { 
			anchorPoint = new GPoint(
					rect.getX() + rect.getWidth() / 2,
					rect.getY()
			);
		}
		
		add(rect);
		add(label);
		boxesMade += this.
	}
}
