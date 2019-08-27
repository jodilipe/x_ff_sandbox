package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class BeregnLivrentePrognoseRequest {
	@XmlElement
	public Livrente livrente;
	@XmlElement
	public Date pensionsdato;
	@XmlElement
	public String cprNr;

	public BeregnLivrentePrognoseRequest() {}
}
