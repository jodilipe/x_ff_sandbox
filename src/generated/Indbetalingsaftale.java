package generated;

import javax.xml.bind.annotation.*;

@XmlRootElement
public abstract class Indbetalingsaftale {
	@XmlElement
	public Double beloeb;
	@XmlElement
	public Integer betalingStartAlderIMdr;
	@XmlElement
	public Integer betalingSlutAlderIMdr;
	@XmlElement
	public Betalingskonto betalingskonto;
	@XmlElement
	public Pensionsordning pensionsordning;

	public Indbetalingsaftale() {}
}
