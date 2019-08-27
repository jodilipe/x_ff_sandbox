package generated;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Livrente extends Pensionsordning {
	@XmlElement
	public DaekningRammeLivrente aendringDaekningRammeLivrente;
	@XmlElement
	public Investeringsprofil investeringsprofil;
	@XmlElement
	public Integer betalingStartAlderIMdr;
	@XmlElement
	public Integer betalingSlutAlderIMdr;
	@XmlElement
	public Integer udbetalingStartAlderIMdr;
	@XmlElement
	public ArbejdsgiverIndbetalingsaftale arbejdsgiverIndbetalingsaftale;
	@XmlElement
	public PrivatIndbetalingsaftale privatIndbetalingsaftale;
	@XmlElement
	public Boolean kundekapitalValgt;
	@XmlElement
	public Garanti garanti;
	@XmlElement
	public Reservesikring reservesikring;
	@XmlElement
	public Ratepension overloebFra;

	public Livrente() {}
}
