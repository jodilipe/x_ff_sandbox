package generated;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class BeregnLivrentePrognoseResponse {
	@XmlElement
	public String cprNr;
	@XmlElement
	public LivrentePrognose livrentePrognose;

	public BeregnLivrentePrognoseResponse() {}
}
