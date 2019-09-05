package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class DaekningRammeLivrente extends DaekningRammePensionsordning {
	@XmlElement
	public Integer udbetalingStartAlderIMdrMinimum;
	@XmlElement
	public Integer udbetalingStartAlderIMdrMaksimum;
	@XmlElement
	public Boolean kundekapitalMulig;
	@XmlElementWrapper
	@XmlElement( name = "investeringsprofil" )
	public List<Investeringsprofil> investeringsprofiler;
	@XmlElement
	public Investeringsprofil defaultInvesteringsprofil;
	@XmlElement
	public ReservesikringRamme reservesikringRamme;

	public DaekningRammeLivrente() {}
}
