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
	@XmlElement( name = "risikoMaksimalDaekning" )
	public List<RisikoMaksimalDaekning> risikoMaksimalDaekningMuligheder;
	@XmlElementWrapper
	@XmlElement( name = "aftale" )
	public List<Aftale> aftaler;
	@XmlElementWrapper( name = "nytegningDaekningRammer" )
	@XmlElements( {
		@XmlElement( name="daekningRammeRisiko", type = DaekningRammeRisiko.class ),
		@XmlElement( name="daekningRammeLivrente", type = DaekningRammeLivrente.class )
	} )
	public List<DaekningRamme> nytegningDaekningRammer;

	public Kunde() {}
}
