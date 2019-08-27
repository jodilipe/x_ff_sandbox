package generated;

import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement
public class Ydelse {
	@XmlElement
	public Double ydelse;
	@XmlElementWrapper
	@XmlElement( name = "prisPerYdelse" )
	public List<PrisPerYdelse> prognosepriser;

	public Ydelse() {}
}
