package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class DanTilbudResponse {
	@XmlElement
	public Status status;
	@XmlElementWrapper
	@XmlElement( name = "valideringsfejl" )
	public List<Valideringsfejl> valideringsfejl;

	public DanTilbudResponse() {}
}
