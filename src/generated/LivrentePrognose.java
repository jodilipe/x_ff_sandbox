package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class LivrentePrognose {
	@XmlElement
	public Integer startAar;
	@XmlElement
	public Integer startMaaned;
	@XmlElementWrapper
	@XmlElement( name = "aarligYdelse" )
	public List<AarligYdelse> aarligeYdelser;
	@XmlElement
	public Double reserveVedPensionsalder;

	public LivrentePrognose() {}
}
