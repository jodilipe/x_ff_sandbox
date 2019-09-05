package test;

import java.io.FileOutputStream;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import generated.Aftale;
import generated.BeregnLivrentePrognoseResponse;
import generated.Betalingskilde;
import generated.BetalingskildeType;
import generated.Betalingskonto;
import generated.DaekningId;
import generated.DaekningRammeLivrente;
import generated.DaekningRammeRisiko;
import generated.Garanti;
import generated.HentEngagementResponse;
import generated.Investeringsprofil;
import generated.InvesteringsprofilType;
import generated.Kunde;
import generated.Livrente;
import generated.LivrentePrognose;
import generated.MedforsikretType;
import generated.Pantsat;
import generated.PantsatVariant;
import generated.Person;
import generated.PrisOpkraevningsfrekvens;
import generated.PrisPerYdelse;
import generated.PrivatIndbetalingsaftale;
import generated.Ratepension;
import generated.Reservesikring;
import generated.ReservesikringRamme;
import generated.RisikoDaekning;
import generated.RisikoDaekningType;
import generated.RisikoMaksimalDaekning;
import generated.Skattekode;
import generated.Ydelse;
import generated.YdelseFrekvens;

public class JaxbTest {

	public static void main( String[] args ) throws Exception {
		createHentEngagementResponse();
		createBeregnPrognoseResponse();
	}

	protected static void createBeregnPrognoseResponse() throws Exception {
		BeregnLivrentePrognoseResponse beregnLivrentePrognoseResponse = new BeregnLivrentePrognoseResponse();

		beregnLivrentePrognoseResponse.cprNr = "0102700001";
		beregnLivrentePrognoseResponse.livrentePrognose = createLivrentePrognose( 2040, 2, 2000000d );

		JAXBContext contextObj = JAXBContext.newInstance( BeregnLivrentePrognoseResponse.class );
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
		marshallerObj.marshal( beregnLivrentePrognoseResponse, System.out );
		marshallerObj.marshal( beregnLivrentePrognoseResponse, new FileOutputStream( "/Users/jon/festinafinance/eclipse/workspace/secondary/x_ff_sandbox/src/xml/beregnLivrentePrognoseResponse.xml" ) );
	}

	private static LivrentePrognose createLivrentePrognose( int startAar, int startMaaned, double reserveVedPensionering ) {
		LivrentePrognose livrentePrognose = new LivrentePrognose();
		livrentePrognose.startAar = startAar;
		livrentePrognose.startMaaned = startMaaned;
		livrentePrognose.reserveVedPensionsalder = reserveVedPensionering;

		return livrentePrognose;
	}

	protected static void createHentEngagementResponse() throws Exception {
		DaekningId letpensionTaeId = new DaekningId();
		letpensionTaeId.navn = "letpensionId";
		letpensionTaeId.id = "123456";
		DaekningId pfaTaeId = new DaekningId();
		pfaTaeId.navn = "pfaId";
		pfaTaeId.id = "654321";
		RisikoDaekning tabAfErhvervsevne = createTabAfErhvervsevne( letpensionTaeId, pfaTaeId );

		Ydelse ydelseNytegning60250 = createYdelse( 60250d, createPrisPerYdelse( 0, 2415d ), createPrisPerYdelse( 360, 3015d ), createPrisPerYdelse( 540, 3360d ) );
		Ydelse ydelseNytegning120500 = createYdelse( 120500d, createPrisPerYdelse( 0, 4830d ), createPrisPerYdelse( 360, 6030d ), createPrisPerYdelse( 540, 6720d ) );
		Ydelse ydelseNytegning180750 = createYdelse( 180750d, createPrisPerYdelse( 0, 7245d ), createPrisPerYdelse( 360, 9045d ), createPrisPerYdelse( 540, 10080d ) );
		Ydelse ydelseNytegning241000 = createYdelse( 241000d, createPrisPerYdelse( 0, 9660d ), createPrisPerYdelse( 360, 12060d ), createPrisPerYdelse( 540, 13440d ) );
		Ydelse ydelseNytegning301250 = createYdelse( 301250d, createPrisPerYdelse( 0, 12075d ), createPrisPerYdelse( 360, 15075d ), createPrisPerYdelse( 540, 16800d ) );
		Ydelse ydelseNytegning361500 = createYdelse( 361500d, createPrisPerYdelse( 0, 14490d ), createPrisPerYdelse( 360, 18090d ), createPrisPerYdelse( 540, 20160d ) );
		Ydelse ydelseNytegning421750 = createYdelse( 421750d, createPrisPerYdelse( 0, 16905d ), createPrisPerYdelse( 360, 21105d ), createPrisPerYdelse( 540, 23520d ) );
		Ydelse ydelseNytegning482000 = createYdelse( 482000d, createPrisPerYdelse( 0, 19320d ), createPrisPerYdelse( 360, 24120d ), createPrisPerYdelse( 540, 26880d ) );
		Ydelse ydelseNytegning542250 = createYdelse( 542250d, createPrisPerYdelse( 0, 21735d ), createPrisPerYdelse( 360, 27135d ), createPrisPerYdelse( 540, 30240d ) );

		DaekningRammeRisiko daekningRammeRisikoNytegning = createDaekningRammeRisiko( ydelseNytegning60250, ydelseNytegning120500, ydelseNytegning180750, ydelseNytegning241000, ydelseNytegning301250, ydelseNytegning361500, ydelseNytegning421750, ydelseNytegning482000, ydelseNytegning542250 );

		Kunde kunde = new Kunde();
		kunde.navn = "Homer Simpson";
		kunde.cprNr = "0102700001";
//		kunde.eksisterendeRisikoDaekninger = Arrays.asList( tabAfErhvervsevne );
		kunde.nytegningDaekningRammer = Arrays.asList( daekningRammeRisikoNytegning );
		kunde.samletMaksimalDaekningDoed = 1928000d;
		kunde.samletMaksimalDaekningSygdom = 537750d;
//		kunde.eksisterendePensionsordninger = Arrays.asList( new Ratepension() );
		kunde.nytegningBetalingskonti = Arrays.asList( new Betalingskonto() );
		kunde.risikoMaksimalDaekningMuligheder = Arrays.asList( createLetsikringRisikoMaksimalDaekning( RisikoDaekningType.doedsfaldsdaekningRate, 210511d ), createLetsikringRisikoMaksimalDaekning( RisikoDaekningType.doedsfaldsdaekningSum, 1928000d ) );

		DaekningId letpensionLivrenteId = new DaekningId();
		letpensionLivrenteId.navn = "letpensionId";
		letpensionLivrenteId.id = "123456";
		DaekningId pfaLivrenteId = new DaekningId();
		pfaLivrenteId.navn = "pfaId";
		pfaLivrenteId.id = "654321";
//		kunde.eksisterendeLivrenter = Arrays.asList( createLivrente( letpensionLivrenteId, pfaLivrenteId ) );
		
		PrivatIndbetalingsaftale privatIndbetalingsaftale = new PrivatIndbetalingsaftale();
		privatIndbetalingsaftale.beloeb = 1000d;
		privatIndbetalingsaftale.betalingskonto = new Betalingskonto();
		privatIndbetalingsaftale.pensionsordning = null;
		privatIndbetalingsaftale.prisOpkraevningsfrekvens = PrisOpkraevningsfrekvens.maanedlig;
		privatIndbetalingsaftale.betalingSlutAlderIMdr = 1068;
		privatIndbetalingsaftale.betalingStartAlderIMdr = 360;

		Aftale aftale = new Aftale();
		aftale.aftalenummer = "1234567890";
		aftale.leverandoer = "Letpension";
		aftale.daekninger = Arrays.asList( tabAfErhvervsevne,new Ratepension(),createLivrente( letpensionLivrenteId, pfaLivrenteId ) );
		aftale.indbetalingsaftale = privatIndbetalingsaftale;
		
		kunde.aftaler = Arrays.asList( aftale );

		HentEngagementResponse hentEngagementResponse = new HentEngagementResponse();
		hentEngagementResponse.kunde = kunde;

		JAXBContext contextObj = JAXBContext.newInstance( HentEngagementResponse.class );
		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
		marshallerObj.marshal( hentEngagementResponse, System.out );
		marshallerObj.marshal( hentEngagementResponse, new FileOutputStream( "/Users/jon/festinafinance/eclipse/workspace/secondary/x_ff_sandbox/src/xml/hentEngagementResponse.xml" ) );
	}

	protected static DaekningRammeRisiko createDaekningRammeRisiko( Ydelse ydelseNytegning60250, Ydelse ydelseNytegning120500, Ydelse ydelseNytegning180750, Ydelse ydelseNytegning241000, Ydelse ydelseNytegning301250, Ydelse ydelseNytegning361500, Ydelse ydelseNytegning421750, Ydelse ydelseNytegning482000, Ydelse ydelseNytegning542250 ) {
		DaekningRammeRisiko daekningRammeNytegning = new DaekningRammeRisiko();
		daekningRammeNytegning.ydelser = Arrays.asList( ydelseNytegning60250, ydelseNytegning120500, ydelseNytegning180750, ydelseNytegning241000, ydelseNytegning301250, ydelseNytegning361500, ydelseNytegning421750, ydelseNytegning482000, ydelseNytegning542250 );
		daekningRammeNytegning.betalingskilder = Arrays.asList( createBetalingskilde( Skattekode.sk1, BetalingskildeType.bankkonto, BetalingskildeType.pensionSkat2 ) );
		daekningRammeNytegning.risikoDaekningType = RisikoDaekningType.tabAfErhvervsevne;
		daekningRammeNytegning.pantsatMuligheder = Arrays.asList( createPantsat( Skattekode.sk1, PantsatVariant.altidNej ) );
		daekningRammeNytegning.praemieophoerAlderIMdr = 828;
		daekningRammeNytegning.risikoophoerAlderIMdr = 828;
		daekningRammeNytegning.risikoophoerMedforsikretAlderIMdr = 828;
		daekningRammeNytegning.skattekoder = Arrays.asList( Skattekode.sk1 );
		daekningRammeNytegning.udbetalingsophoerMedforsikretAlderIMdr = 828;
		daekningRammeNytegning.kapitaliseringsfaktor = 1.0;
		daekningRammeNytegning.ydelseReguleringsfaktorUdbetalingsperiode = 1.0;
		return daekningRammeNytegning;
	}

	protected static Livrente createLivrente( DaekningId...ids ) {
		ReservesikringRamme reservesikringRamme = new ReservesikringRamme();
		reservesikringRamme.betalingskilder = Arrays.asList( createBetalingskilde( Skattekode.sk2, BetalingskildeType.bankkonto, BetalingskildeType.pensionSkat2 ), createBetalingskilde( Skattekode.sk5, BetalingskildeType.bankkonto ) );

		DaekningRammeLivrente daekningRammeLivrente = new DaekningRammeLivrente();
		daekningRammeLivrente.betalingskilder = Arrays.asList( createBetalingskilde( Skattekode.sk1, BetalingskildeType.bankkonto, BetalingskildeType.pensionSkat2 ) );
		Investeringsprofil defaultInvesteringsProfil = createInvesteringsProfil( InvesteringsprofilType.valgfri, "Valgfri investeringsfordeling", false, false );
		daekningRammeLivrente.investeringsprofiler = Arrays.asList(	createInvesteringsProfil( InvesteringsprofilType.A, "Meget lav andel af opsparing i Høj", true, true ),
																																createInvesteringsProfil( InvesteringsprofilType.B, "Lav andel af opsparing i Høj", false, false ),
																																createInvesteringsProfil( InvesteringsprofilType.C, "Mellem andel af opsparing i Høj", false, false ),
																																createInvesteringsProfil( InvesteringsprofilType.D, "Høj andel af opsparing i Høj", false, false ),
																																defaultInvesteringsProfil );
		daekningRammeLivrente.defaultInvesteringsprofil = defaultInvesteringsProfil;
		
		daekningRammeLivrente.kundekapitalMulig = true;
		daekningRammeLivrente.medforsikretTyper = Arrays.asList( MedforsikretType.values() );
		daekningRammeLivrente.reservesikringRamme = reservesikringRamme;
		daekningRammeLivrente.skattekoder = Arrays.asList( Skattekode.sk1 );
		daekningRammeLivrente.udbetalingStartAlderIMdrMaksimum = 1062;
		daekningRammeLivrente.udbetalingStartAlderIMdrMinimum = 768;
		daekningRammeLivrente.reservesikringRamme = reservesikringRamme;

		Garanti garanti = new Garanti();
		garanti.antalAar = 8;
		garanti.maksimalPeriode = false;

		Reservesikring reservesikring = new Reservesikring();
		reservesikring.aktuelUdbetalingFoerSkat = 500000d;
		reservesikring.betalingskonto = new Betalingskonto();
		reservesikring.skattekode = Skattekode.sk2;

		Livrente livrente = new Livrente();
		livrente.daekningIder = Arrays.asList( ids );
		livrente.aendringDaekningRammeLivrente = daekningRammeLivrente;
		livrente.udbetalingStartAlderIMdr = 768;
		livrente.garanti = garanti;
		livrente.investeringsprofil = createInvesteringsProfil( InvesteringsprofilType.B, "Lav andel af opsparing i Høj", false, true ); 
		livrente.kundekapitalValgt = false;

		Person medforsikret = new Person();
		medforsikret.cprNr = "0102700000";
		medforsikret.navn = "Marge Simpson";
		livrente.medforsikret = medforsikret;
		livrente.medforsikretType = MedforsikretType.aegtefaelle;
		livrente.reservesikring = reservesikring;
		livrente.skattekode = Skattekode.sk1;

		return livrente;
	}

	private static Investeringsprofil createInvesteringsProfil( InvesteringsprofilType investeringsprofilType, String beskrivelse, boolean andelIHoejSkalAngives, boolean udbetalingSikringMulig ) {
		Investeringsprofil investeringsprofil = new Investeringsprofil();
		investeringsprofil.investeringsprofilType = investeringsprofilType;
		investeringsprofil.beskrivelse = beskrivelse;
		investeringsprofil.andelIHoejSkalAngives = andelIHoejSkalAngives;
		investeringsprofil.udbetalingssikringMulig = udbetalingSikringMulig;
		return investeringsprofil;
	}

	protected static RisikoMaksimalDaekning createLetsikringRisikoMaksimalDaekning( RisikoDaekningType risikoDaekningType, double beloeb ) {
		RisikoMaksimalDaekning letsikringRisikoMaksimalDaekning = new RisikoMaksimalDaekning();
		letsikringRisikoMaksimalDaekning.risikoDaekningType = risikoDaekningType;
		letsikringRisikoMaksimalDaekning.maksimalDaekning = beloeb;
		return letsikringRisikoMaksimalDaekning;
	}

	protected static RisikoDaekning createTabAfErhvervsevne( DaekningId...ids ) {
		Person forsikrede = new Person();
		forsikrede.navn = "Homer Simpson";
		forsikrede.cprNr = "0102700001";

		Ydelse ydelseAendring60250 = createYdelse( 60250d, createPrisPerYdelse( 0, 1932d ), createPrisPerYdelse( 360, 2412d ), createPrisPerYdelse( 540, 2688d ) );
		Ydelse ydelseAendring120500 = createYdelse( 120500d, createPrisPerYdelse( 0, 3864d ), createPrisPerYdelse( 360, 4824d ), createPrisPerYdelse( 540, 5376d ) );
		Ydelse ydelseAendring180750 = createYdelse( 180750d, createPrisPerYdelse( 0, 5796d ), createPrisPerYdelse( 360, 7236d ), createPrisPerYdelse( 540, 8064d ) );

		DaekningRammeRisiko daekningRammeAendring = new DaekningRammeRisiko();
		daekningRammeAendring.ydelser = Arrays.asList( ydelseAendring60250, ydelseAendring120500, ydelseAendring180750 );
		daekningRammeAendring.betalingskilder = Arrays.asList( createBetalingskilde( Skattekode.sk1, BetalingskildeType.bankkonto, BetalingskildeType.pensionSkat2 ) );
		daekningRammeAendring.risikoDaekningType = RisikoDaekningType.tabAfErhvervsevne;
		daekningRammeAendring.pantsatMuligheder = Arrays.asList( createPantsat( Skattekode.sk1, PantsatVariant.altidNej ) );
		daekningRammeAendring.praemieophoerAlderIMdr = 744;
		daekningRammeAendring.risikoophoerAlderIMdr = 744;
		daekningRammeAendring.risikoophoerMedforsikretAlderIMdr = null;
		daekningRammeAendring.skattekoder = Arrays.asList( Skattekode.sk1 );
		daekningRammeAendring.udbetalingsophoerMedforsikretAlderIMdr = null;
		daekningRammeAendring.kapitaliseringsfaktor = 1.0;
		daekningRammeAendring.ydelseReguleringsfaktorUdbetalingsperiode = 1.0;

		RisikoDaekning tabAfErhvervsevne = new RisikoDaekning();
		tabAfErhvervsevne.daekningIder = Arrays.asList( ids );
		tabAfErhvervsevne.aendringDaekningRammeRisiko = daekningRammeAendring;
		tabAfErhvervsevne.forbedretPrisgruppe = false;
		tabAfErhvervsevne.forsikrede = forsikrede;
		tabAfErhvervsevne.risikoDaekningType = RisikoDaekningType.tabAfErhvervsevne;
		tabAfErhvervsevne.medforsikret = null;
		tabAfErhvervsevne.medforsikretType = null;
		tabAfErhvervsevne.pantsat = false;
		tabAfErhvervsevne.prognosePriser = ydelseAendring180750.prognosepriser;
		tabAfErhvervsevne.skattekode = Skattekode.sk1;
		tabAfErhvervsevne.ydelse = 180750d;
		return tabAfErhvervsevne;
	}

	protected static Betalingskilde createBetalingskilde( Skattekode skattekode, BetalingskildeType... betalingskildeTyper ) {
		Betalingskilde betalingskilde = new Betalingskilde();
		betalingskilde.skattekode = skattekode;
		betalingskilde.betalingskildeTyper = Arrays.asList( betalingskildeTyper );
		return betalingskilde;
	}

	protected static Pantsat createPantsat( Skattekode skattekode, PantsatVariant... pantsatVarianter ) {
		Pantsat pantsat = new Pantsat();
		pantsat.pantsatVarianter = Arrays.asList( pantsatVarianter );
		pantsat.skattekode = skattekode;
		return pantsat;
	}

	protected static Ydelse createYdelse( Double ydelseSats, PrisPerYdelse... prisPerYdelser ) {
		Ydelse ydelse = new Ydelse();
		ydelse.ydelse = ydelseSats;
		ydelse.prognosepriser = Arrays.asList( prisPerYdelser );
		return ydelse;
	}

	protected static PrisPerYdelse createPrisPerYdelse( Integer alderIMdr, Double prisPerAar ) {
		PrisPerYdelse prisPerYdelse01 = new PrisPerYdelse();
		prisPerYdelse01.alderIMdr = alderIMdr;
		prisPerYdelse01.prisPerAar = prisPerAar;
		prisPerYdelse01.prisOpkraevningsfrekvens = PrisOpkraevningsfrekvens.maanedlig;
		prisPerYdelse01.ydelseFrekvens = YdelseFrekvens.maanedlig;
		return prisPerYdelse01;
	}

}
