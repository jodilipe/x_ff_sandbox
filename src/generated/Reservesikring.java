package generated;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Reservesikring {
	@XmlElement
	public Skattekode skattekode;
	@XmlElement
	public Betalingskonto betalingskonto;
	@XmlElement
	public Double aktuelUdbetalingFoerSkat;

	public Reservesikring() {}
}
