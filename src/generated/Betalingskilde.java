package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Betalingskilde {
	@XmlElement
	public Skattekode skattekode;
	@XmlElementWrapper
	@XmlElement( name = "betalingskildeType" )
	public List<BetalingskildeType> betalingskildeTyper;

	public Betalingskilde() {}
}
