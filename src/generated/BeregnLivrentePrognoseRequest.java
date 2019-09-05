package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class BeregnLivrentePrognoseRequest {
	@XmlElement
	public Date pensionsdato;
	@XmlElement
	public String cprNr;
	@XmlElement
	public Livrente livrente;
	@XmlElement
	public Indbetalingsaftale indbetalingsaftale;
	@XmlElementWrapper
	@XmlElement( name = "aarligIndbetaling" )
	public List<AarligIndbetaling> aarligeIndbetalinger;

	public BeregnLivrentePrognoseRequest() {}
}
