package generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import generated.Aldersopsparing;
import generated.ArbejdsgiverIndbetalingsaftale;
import generated.Daekning;
import generated.DaekningRamme;
import generated.DaekningRammeLivrente;
import generated.DaekningRammeRisiko;
import generated.Indbetalingsaftale;
import generated.Kapitalpension;
import generated.Livrente;
import generated.PrivatIndbetalingsaftale;
import generated.RisikoDaekning;

public class JaxbUtils {

	public static void main( String[] args ) throws Exception {
		modelToJaxbPojos( new File( "/Users/jon/festinafinance/git/secondary/ffapp/sdc-dk-shared/model/sdc-dk-letpension.types" ), "/Users/jon/festinafinance/eclipse/workspace/secondary/x_ff_sandbox/src/generated/" );
		System.out.println( "Done" );
	}

	public static void modelToJaxbPojos( File model, String savePath ) throws Exception {
		FileReader fis = new FileReader( model );
		BufferedReader br = new BufferedReader( fis );

		Map<String, List<String>> classNameToClassLines = new HashMap<String, List<String>>();

		String line = br.readLine();
		while ( line != null ) {
			if ( line.contains( "class" ) ) {
				String className = line.substring( line.indexOf( "class" ) + "class".length(), line.indexOf( "{" ) ).trim();
				List<String> lines = new ArrayList<String>();
				while ( line != null && !line.contains( "}" ) ) {
					lines.add( line );
					line = br.readLine();
				}
				lines.add( line );
				classNameToClassLines.put( className, generateClass( lines, savePath ) );
			} else if ( line.contains( "enum" ) ) {
				List<String> lines = new ArrayList<String>();
				while ( line != null && !line.contains( "}" ) ) {
					lines.add( line );
					line = br.readLine();
				}
				lines.add( line );
				generateEnum( lines, savePath );
			}
			
			line = br.readLine();
		}

		List<String> classNames = new ArrayList<String>( classNameToClassLines.keySet() );
		Collections.sort( classNames );
		for ( String className : classNames ) {
			logClassDetails( classNameToClassLines.get( className ) );
		}

		br.close();
		fis.close();
	}

	private static void generateEnum( List<String> lines, String savePath ) throws Exception {
		List<String> enumLines = new ArrayList<String>();

		String firstLine = lines.get( 0 );
		String header = "public " + firstLine.substring( 0, firstLine.indexOf( "{" ) + 1 ).trim();
		enumLines.add( header );

		String enums = "";
		for ( int i = 1; i < lines.size() - 1; i++ ) {
			String currentEnum = lines.get( i );
			enums += currentEnum.substring( 0, currentEnum.indexOf( ";" ) ).trim() + ", ";
		}
		enumLines.add( "\t" + enums.substring( 0, enums.length() - 2 ) + ";" );
		enumLines.add( "}" );

		String enumName = firstLine.substring( firstLine.indexOf( "enum" ) + "enum".length(), firstLine.indexOf( "{" ) ).trim();
		writeToFile( enumLines, enumName, savePath, false );
		// System.out.println( "enum " + enumName );
	}

	private static void writeToFile( List<String> lines, String typeName, String path, boolean importJavaUtils ) throws Exception {
		// File out = new File( path + typeName + ".java" );
		// FileWriter fr = new FileWriter( out );
		// BufferedWriter br = new BufferedWriter( fr );
		// br.write( "package generated;" + "\n" );
		// br.write( "" + "\n" );
		// if ( importJavaUtils ) {
		// br.write( "import java.util.*;" + "\n" );
		// }
		// br.write( "import javax.xml.bind.annotation.*;" + "\n" );
		// br.write( "" + "\n" );
		// br.write( "@XmlRootElement" + "\n" );
		// for ( String line : lines ) {
		// br.write( line + "\n" );
		// }
		// br.close();
		// fr.close();
	}

	private static List<String> generateClass( List<String> lines, String savePath ) throws Exception {
		List<String> classLines = new ArrayList<String>();

		String firstLine = lines.get( 0 );
		String header = "public " + firstLine.substring( 0, firstLine.indexOf( "{" ) + 1 ).trim();
		classLines.add( header );

		boolean containsList = false;
		boolean containsDate = false;
		List<String> allAttributeLines = new ArrayList<String>();
		for ( int i = 1; i < lines.size() - 1; i++ ) {
			List<String> attributeWithAnnotationLines = generateAttributeWithAnnotationLines( lines.get( i ) );
			classLines.addAll( attributeWithAnnotationLines );
			for ( String line : attributeWithAnnotationLines ) {
				if ( !line.contains( "@" ) ) {
					if ( !containsList ) {
						containsList = line.contains( "List<" );
					}
					if ( !containsDate ) {
						containsDate = line.contains( "Date" );
					}
					allAttributeLines.add( line.substring( 0, line.length() - 1 ).trim() );
				}
			}
		}

		String className = firstLine.substring( firstLine.indexOf( "class" ) + "class".length(), firstLine.indexOf( "{" ) ).trim();
		if ( className.contains( "extends" ) ) {
			className = className.substring( 0, className.indexOf( "extends" ) ).trim();
		}
		classLines.addAll( generateConstructors( className, allAttributeLines ) );

		String footer = "}";
		classLines.add( footer );
//		logClassDetails( classLines );
		writeToFile( classLines, className, savePath, containsList || containsDate );
		return classLines;
		// System.out.println( "class " + className );
	}

	private static void logClassDetails( List<String> classLines ) {
		System.out.println( classLines.get( 0 ).replace( "public", "" ).replace( "class", "" ).replace( "abstract", "" ).replace( "{", "" ).trim() + ";" );
		for ( int i = 1; i < classLines.size(); i++ ) {
			String line = classLines.get( i );
			if ( !line.contains( "@" ) && !line.contains( "}" ) && !line.trim().isEmpty() ) {
				line = line.replace( "public", "" ).replace( ";", "" ).trim();
				String type = line.substring( 0, line.indexOf( " " ) );
				String name = line.substring( line.indexOf( " " ) );
				System.out.println( name + ";" + type );
			}
		}
		System.out.println();
	}

	private static Collection<? extends String> generateConstructors( String className, List<String> allAttributeLines ) {
		List<String> constructorLines = new ArrayList<String>();
		constructorLines.add( "" );
		constructorLines.add( "\t" + "public " + className + "() {}" );
		// if ( !allAttributeLines.isEmpty() ) {
		// String header = "\t" + "public " + className + "( ";
		// List<String> assignments = new ArrayList<String>();
		// for ( String attributeLine : allAttributeLines ) {
		// header += attributeLine + ", ";
		// String attributeName = attributeLine.substring( attributeLine.indexOf( " " ) ).trim();
		// assignments.add( "\t\t" + "this." + attributeName + " = " + attributeName + ";" );
		// }
		// header = header.substring( 0, header.length() - 2 ) + " ) {";
		// constructorLines.add( "" );
		// constructorLines.add( header );
		// constructorLines.addAll( assignments );
		// constructorLines.add( "\t" + "}" );
		// }

		return constructorLines;
	}

	private static Map<Class<?>, List<Class<?>>> classToSubclasses = new HashMap<Class<?>, List<Class<?>>>();
	static {
		classToSubclasses.put( Daekning.class, Arrays.asList( RisikoDaekning.class, Kapitalpension.class, Aldersopsparing.class, Livrente.class ) );
		classToSubclasses.put( DaekningRamme.class, Arrays.asList( DaekningRammeRisiko.class, DaekningRammeLivrente.class ) );
		classToSubclasses.put( Indbetalingsaftale.class, Arrays.asList( PrivatIndbetalingsaftale.class, ArbejdsgiverIndbetalingsaftale.class ) );
	}

	private static String firstToLowerCase( String value ) {
		return value.substring( 0, 1 ).toLowerCase() + value.substring( 1 );
	}

	private static List<String> generateAttributeWithAnnotationLines( String typeLine ) throws Exception {
		List<String> attributeLines = new ArrayList<String>();
		String type = typeLine.substring( typeLine.indexOf( ":" ) + 1, typeLine.indexOf( ";" ) ).trim();
		String name = typeLine.substring( typeLine.indexOf( ">" ) + 1, typeLine.indexOf( ":" ) ).trim();
		if ( name.contains( "[" ) ) {
			name = name.substring( 0, name.indexOf( "[" ) );
		}
		if ( name.isEmpty() ) {
			name = firstToLowerCase( type );
		}
		if ( typeLine.contains( "*" ) ) {
			List<Class<?>> subTypes = classToSubclasses.get( getClass( type ) );
			if ( subTypes != null ) {
				attributeLines.add( "\t" + "@XmlElementWrapper( name = \"" + name + "\" )" );
				attributeLines.add( "\t" + "@XmlElements( {" );
				for ( int i = 0; i < subTypes.size(); i++ ) {
					Class<?> subType = subTypes.get( i );
					String line = "\t\t" + "@XmlElement( name=\"" + firstToLowerCase( subType.getSimpleName() ) + "\", type = " + subType.getSimpleName() + ".class )";
					if ( i < ( subTypes.size() - 1 ) ) {
						line += ",";
					}
					attributeLines.add( line );
				}
				attributeLines.add( "\t" + "} )" );
			} else {
				attributeLines.add( "\t" + "@XmlElementWrapper" );
				attributeLines.add( "\t" + "@XmlElement( name = \"" + type.substring( 0, 1 ).toLowerCase() + type.substring( 1 ) + "\" )" );
			}
			attributeLines.add( "\t" + "public List<" + type + "> " + name + ";" );
		} else {
			attributeLines.add( "\t" + "@XmlElement" );
			attributeLines.add( "\t" + "public " + type + " " + name + ";" );
		}
		return attributeLines;
	}

	private static Class<?> getClass( String type ) {
		try {
			return Class.forName( "generated." + type );
		} catch ( ClassNotFoundException e ) {
			// ignore
			return null;
		}
	}
}
