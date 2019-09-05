package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class DaekningRammeRisiko extends DaekningRamme {
	@XmlElement
	public RisikoDaekningType risikoDaekningType;
	@XmlElement
	public Integer praemieophoerAlderIMdr;
	@XmlElement
	public Integer risikoophoerAlderIMdr;
	@XmlElement
	public Integer risikoophoerMedforsikretAlderIMdr;
	@XmlElement
	public Integer udbetalingsophoerMedforsikretAlderIMdr;
	@XmlElement
	public Double ydelseReguleringsfaktorUdbetalingsperiode;
	@XmlElement
	public Double kapitaliseringsfaktor;
	@XmlElementWrapper
	@XmlElement( name = "ydelse" )
	public List<Ydelse> ydelser;
	@XmlElementWrapper
	@XmlElement( name = "pantsat" )
	public List<Pantsat> pantsatMuligheder;

	public DaekningRammeRisiko() {}
}
