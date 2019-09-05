package generated;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class DaekningVilkaar {
	@XmlElement
	public String tekst;
	@XmlElement
	public Boolean accepteret;
	@XmlElement
	public String daekningId;
	@XmlElement
	public String vilkaarId;

	public DaekningVilkaar() {}
}
