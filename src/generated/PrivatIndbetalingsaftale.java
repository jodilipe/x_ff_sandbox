package generated;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class PrivatIndbetalingsaftale extends Indbetalingsaftale {
	@XmlElement
	public PrisOpkraevningsfrekvens prisOpkraevningsfrekvens;
	@XmlElement
	public Betalingskonto betalingskonto;

	public PrivatIndbetalingsaftale() {}
}
