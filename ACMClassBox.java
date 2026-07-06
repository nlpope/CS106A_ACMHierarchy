import acm.program.*;
import acm.graphics.*;

public class ACMClassBox extends GraphicsProgram
{
	private static final int BOX_WIDTH = 30;
	private static final int BOX_HEIGHT = 15;
	private GRect rect;
	private GLabel label;
	private String labelName;
	boolean parent;
	
	public void createBox(
			double x, 
			double y, 
			double width, 
			double height,
			String withName
	)
	{
		rect = new GRect(x,y,width,height);
		labelName = withName;
		label = new GLabel("",0,0);
	}
}
