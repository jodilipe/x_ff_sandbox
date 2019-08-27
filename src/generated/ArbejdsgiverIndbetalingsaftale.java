package generated;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class ArbejdsgiverIndbetalingsaftale extends Indbetalingsaftale {
	@XmlElement
	public Double procentAfLoen;
	@XmlElement
	public String cvrNummer;

	public ArbejdsgiverIndbetalingsaftale() {}
}
