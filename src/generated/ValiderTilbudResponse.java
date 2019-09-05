package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class ValiderTilbudResponse {
	@XmlElementWrapper
	@XmlElement( name = "daekningVilkaar" )
	public List<DaekningVilkaar> daekningVilkaar;
	@XmlElementWrapper
	@XmlElement( name = "valideringsfejl" )
	public List<Valideringsfejl> valideringsfejl;
	@XmlElement
	public Date acceptfrist;

	public ValiderTilbudResponse() {}
}
