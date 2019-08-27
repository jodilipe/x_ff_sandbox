package generated;

import javax.xml.bind.annotation.*;

@XmlRootElement
public abstract class Indbetalingsaftale {
	@XmlElement
	public Pensionsordning pensionsordning;
	@XmlElement
	public Double beloeb;

	public Indbetalingsaftale() {}
}
