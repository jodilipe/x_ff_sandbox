package generated;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class PrisPerYdelse {
	@XmlElement
	public Integer alderIMdr;
	@XmlElement
	public Double prisPerAar;
	@XmlElement
	public YdelseFrekvens ydelseFrekvens;
	@XmlElement
	public PrisOpkraevningsfrekvens prisOpkraevningsfrekvens;

	public PrisPerYdelse() {}
}
