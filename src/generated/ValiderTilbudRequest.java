package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class ValiderTilbudRequest {
	@XmlElementWrapper( name = "aendringer" )
	@XmlElements( {
		@XmlElement( name="risikoDaekning", type = RisikoDaekning.class ),
		@XmlElement( name="kapitalpension", type = Kapitalpension.class ),
		@XmlElement( name="aldersopsparing", type = Aldersopsparing.class ),
		@XmlElement( name="livrente", type = Livrente.class )
	} )
	public List<Daekning> aendringer;
	@XmlElementWrapper( name = "oprettelser" )
	@XmlElements( {
		@XmlElement( name="risikoDaekning", type = RisikoDaekning.class ),
		@XmlElement( name="kapitalpension", type = Kapitalpension.class ),
		@XmlElement( name="aldersopsparing", type = Aldersopsparing.class ),
		@XmlElement( name="livrente", type = Livrente.class )
	} )
	public List<Daekning> oprettelser;
	@XmlElement
	public String kundeCpr;
	@XmlElementWrapper
	@XmlElement( name = "daekningVilkaar" )
	public List<DaekningVilkaar> accepteredeVilkaar;

	public ValiderTilbudRequest() {}
}
