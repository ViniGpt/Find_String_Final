import java.io.File;


public class InputFields{
	
	public File FileName;
	public String Pat;
	case_attr caseAttr;
	public InputFields(File FileName,String Pat, case_attr caseAttr)
	{
		this.FileName=FileName;
		this.Pat=Pat;
		this.caseAttr=caseAttr;
	}
}