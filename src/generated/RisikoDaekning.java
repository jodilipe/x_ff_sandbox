package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class RisikoDaekning extends Daekning {
	@XmlElement
	public RisikoDaekningType risikoDaekningType;
	@XmlElement
	public Boolean pantsat;
	@XmlElement
	public Double ydelse;
	@XmlElement
	public Boolean forbedretPrisgruppe;
	@XmlElement
	public Person forsikrede;
	@XmlElementWrapper
	@XmlElement( name = "prisPerYdelse" )
	public List<PrisPerYdelse> prognosePriser;
	@XmlElement
	public DaekningRammeRisiko aendringDaekningRammeRisiko;

	public RisikoDaekning() {}
}
