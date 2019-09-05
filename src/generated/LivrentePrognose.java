package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class LivrentePrognose {
	@XmlElement
	public Integer startAar;
	@XmlElement
	public Integer startMaaned;
	@XmlElement
	public Double reserveVedPensionsalder;
	@XmlElement
	public Double reserveVedAlder60;
	@XmlElementWrapper
	@XmlElement( name = "reservesikringPraemie" )
	public List<ReservesikringPraemie> reservesikringPraemier;
	@XmlElementWrapper
	@XmlElement( name = "aarligYdelse" )
	public List<AarligYdelse> aarligeYdelser;

	public LivrentePrognose() {}
}
