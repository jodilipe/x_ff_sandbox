package generated;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class Person {
	@XmlElement
	public String cprNr;
	@XmlElement
	public String navn;

	public Person() {}
}
