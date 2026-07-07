
public enum ACMClassEnums 
{
	PROGRAM("Program", true),
	GRAPHICS_PROGRAM("Graphics Program", false),
	CONSOLE_PROGRAM("Console Program", false),
	DIALOG_PROGRAM("Dialog Program", false);
	
	public final String name;
	public final boolean parent; 
	
	
	ACMClassEnums(String name, boolean parent)
	{
		this.name = name;
		this.parent = parent;
	}
}
