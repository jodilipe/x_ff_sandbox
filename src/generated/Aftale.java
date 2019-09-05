package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Aftale {
	@XmlElement
	public String leverandoer;
	@XmlElement
	public String aftalenummer;
	@XmlElement
	public Indbetalingsaftale indbetalingsaftale;
	@XmlElementWrapper( name = "daekninger" )
	@XmlElements( {
		@XmlElement( name="risikoDaekning", type = RisikoDaekning.class ),
		@XmlElement( name="kapitalpension", type = Kapitalpension.class ),
		@XmlElement( name="aldersopsparing", type = Aldersopsparing.class ),
		@XmlElement( name="livrente", type = Livrente.class )
	} )
	public List<Daekning> daekninger;

	public Aftale() {}
}
