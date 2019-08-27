package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Kunde extends Person {
	@XmlElement
	public Double samletMaksimalDaekningDoed;
	@XmlElement
	public Double samletMaksimalDaekningSygdom;
	@XmlElementWrapper
	@XmlElement( name = "betalingskonto" )
	public List<Betalingskonto> nytegningBetalingskonti;
	@XmlElementWrapper
	@XmlElement( name = "risikoDaekning" )
	public List<RisikoDaekning> eksisterendeRisikoDaekninger;
	@XmlElementWrapper
	@XmlElement( name = "pensionsordning" )
	public List<Pensionsordning> eksisterendePensionsordninger;
	@XmlElementWrapper
	@XmlElement( name = "daekningRammeRisiko" )
	public List<DaekningRammeRisiko> nytegningRisikoDaekningRammer;
	@XmlElementWrapper
	@XmlElement( name = "risikoMaksimalDaekning" )
	public List<RisikoMaksimalDaekning> risikoMaksimalDaekningMuligheder;
	@XmlElementWrapper
	@XmlElement( name = "daekningRammeLivrente" )
	public List<DaekningRammeLivrente> nytegningLivrenteRammer;
	@XmlElementWrapper
	@XmlElement( name = "livrente" )
	public List<Livrente> eksisterendeLivrenter;

	public Kunde() {}
}
