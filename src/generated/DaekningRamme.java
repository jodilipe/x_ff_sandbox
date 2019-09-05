package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public abstract class DaekningRamme {
	@XmlElementWrapper
	@XmlElement( name = "medforsikretType" )
	public List<MedforsikretType> medforsikretTyper;
	@XmlElementWrapper
	@XmlElement( name = "skattekode" )
	public List<Skattekode> skattekoder;
	@XmlElementWrapper
	@XmlElement( name = "betalingskilde" )
	public List<Betalingskilde> betalingskilder;

	public DaekningRamme() {}
}
