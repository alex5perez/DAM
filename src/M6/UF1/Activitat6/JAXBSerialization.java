package exercici6uf1m6;

/*
* File: Exercici6UF1M6.java 
* Author: Alex Pérez Rubio
* Date: 30-10-2020
* Description: Activitat 6 PRACTICA UF1 M6
*/

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
 
public class JAXBSerialization {
	
	private static final String ALUMNES_XML_FILE = "alumnes.xml";
 
	public static void main(String[] args) throws JAXBException, IOException {
		
		JAXBContext context = JAXBContext.newInstance(Departaments.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		
		Departaments alumnes = ompleDepartaments();
		
		//Mostrem el document XML generat por la sortida estandard
		marshaller.marshal(alumnes, System.out);
		
		FileOutputStream fos = new FileOutputStream(ALUMNES_XML_FILE);
		//guardem l'objecte serializat en un document XML
		marshaller.marshal(alumnes, fos);
		fos.close();
		
		Unmarshaller unmarshaller = context.createUnmarshaller();
		//Deserialitzem a partir de un document XML
		Departaments alumnesAux = (Departaments) unmarshaller.unmarshal(new File(ALUMNES_XML_FILE));
		System.out.println("********* Baix Camp carregat desde fitxer XML***************");
		//Mostrem l'objeto Java obtingut
		marshaller.marshal(alumnesAux, System.out);
		
	}

	private static Departaments ompleDepartaments(){
		
		String[] noms = {"DAM", "DAW", "ESO", "BAT"};
                String[] cursos = {"SEGON", "SEGON", "PRIMER", "SEGON"};
                int[]depN = {104, 105, 35, 96};
		
		Departament[] ArrayDepartaments = new Departament[4];
		
		for(int i=0; i<4; i++){
			ArrayDepartaments[i] = new Departament();
			ArrayDepartaments[i].setNOMBRE(noms[i]);
			ArrayDepartaments[i].setCURS(cursos[i]);
			ArrayDepartaments[i].setDEPT_NO(depN[i]);
                     
			ArrayDepartaments[i].setId(i);			
		}
		
		Departaments alumnes = new Departaments();
		alumnes.setDepartaments(ArrayDepartaments);
		
		return alumnes;
	}
 
}
