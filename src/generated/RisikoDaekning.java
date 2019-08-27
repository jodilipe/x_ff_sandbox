package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class RisikoDaekning extends Daekning {
	@XmlElement
	public RisikoDaekningType risikoDaekningType;
	@XmlElement
	public DaekningRammeRisiko aendringDaekningRammeRisiko;
	@XmlElement
	public Boolean pantsat;
	@XmlElement
	public Double ydelse;
	@XmlElementWrapper
	@XmlElement( name = "prisPerYdelse" )
	public List<PrisPerYdelse> prognosePriser;
	@XmlElement
	public Person forsikrede;
	@XmlElement
	public Boolean forbedretPrisgruppe;

	public RisikoDaekning() {}
}
