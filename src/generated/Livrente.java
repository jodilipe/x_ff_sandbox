package generated;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Livrente extends Pensionsordning {
	@XmlElement
	public Integer udbetalingStartAlderIMdr;
	@XmlElement
	public Boolean kundekapitalValgt;
	@XmlElement
	public Investeringsprofil investeringsprofil;
	@XmlElement
	public Garanti garanti;
	@XmlElement
	public Reservesikring reservesikring;
	@XmlElement
	public Ratepension overloebFra;
	@XmlElement
	public DaekningRammeLivrente aendringDaekningRammeLivrente;

	public Livrente() {}
}
