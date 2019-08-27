package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public abstract class Daekning {
	@XmlElement
	public Skattekode skattekode;
	@XmlElement
	public BetalingskildeType betalingskildeType;
	@XmlElement
	public Person medforsikret;
	@XmlElement
	public MedforsikretType medforsikretType;
	@XmlElementWrapper
	@XmlElement( name = "udbyderId" )
	public List<UdbyderId> udbyderIder;

	public Daekning() {}
}
