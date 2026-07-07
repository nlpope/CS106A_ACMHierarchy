import acm.program.*;
import acm.graphics.*;

public class ACMClassBox extends GraphicsProgram
{
	private static final int BOX_WIDTH = 30;
	private static final int BOX_HEIGHT = 15;
	public ACMClassEnums classType;
	public GPoint coord;
	
	public void createBox(
			ACMClassEnums ofType,
			GPoint atCoord
	)
	{
		this.classType = ofType;
		
		GRect rect = new GRect(
				atCoord.getX(),
				atCoord.getY(),
				BOX_WIDTH,
				BOX_HEIGHT		
		);
		
		GLabel label = new GLabel(
				ofType.name,
				rect.getX() + BOX_WIDTH / 2.0,
				rect.getY() + BOX_HEIGHT / 2.0
		);
		
		add(rect);
		add(label);
	}
}
