package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Pantsat {
	@XmlElement
	public Skattekode skattekode;
	@XmlElementWrapper
	@XmlElement( name = "pantsatVariant" )
	public List<PantsatVariant> pantsatVarianter;

	public Pantsat() {}
}
