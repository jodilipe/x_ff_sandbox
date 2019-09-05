package generated;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Investeringsprofil {
	@XmlElement
	public String beskrivelse;
	@XmlElement
	public InvesteringsprofilType investeringsprofilType;
	@XmlElement
	public Boolean andelIHoejSkalAngives;
	@XmlElement
	public Boolean udbetalingssikringMulig;

	public Investeringsprofil() {}
}
