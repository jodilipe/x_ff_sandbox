package generated;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class BeregnLivrentePrognoseResponse {
	@XmlElement
	public LivrentePrognose livrentePrognose;
	@XmlElement
	public String cprNr;

	public BeregnLivrentePrognoseResponse() {}
}
