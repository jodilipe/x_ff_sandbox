package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public abstract class Daekning {
	@XmlElement
	public Skattekode skattekode;
	@XmlElement
	public Person medforsikret;
	@XmlElement
	public MedforsikretType medforsikretType;
	@XmlElementWrapper
	@XmlElement( name = "daekningId" )
	public List<DaekningId> daekningIder;

	public Daekning() {}
}
