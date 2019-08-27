package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class ReservesikringRamme {
	@XmlElementWrapper
	@XmlElement( name = "betalingskilde" )
	public List<Betalingskilde> betalingskilder;
	@XmlElement
	public Integer udbetalingStartAlderIMdrMaksimum;

	public ReservesikringRamme() {}
}
