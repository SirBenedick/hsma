package pr1.uebung06;
import static pr.MakeItSimple.*;
public class BaconKodiererImpl {
	
	static String reinigeNachricht(String nachricht){
//		println("1. " + nachricht);
		nachricht = nachricht.replaceAll("Ä", "AE");
		nachricht = nachricht.replaceAll("Ö", "OE");
		nachricht = nachricht.replaceAll("Ü", "UE");
		nachricht = nachricht.replaceAll("ä", "AE");
		nachricht = nachricht.replaceAll("ö", "OE");
		nachricht = nachricht.replaceAll("ü", "UE");
//		println("2. " + nachricht);
		nachricht = nachricht.toUpperCase();
		String kurzeNachricht = "";
		
		char buchstabe;
		for(int i = 0; i<nachricht.length(); i++){
			buchstabe = nachricht.charAt(i);
			if('A' <= buchstabe && buchstabe <= 'Z'){
				kurzeNachricht += buchstabe;
			}

		}
//		println("3. " + kurzeNachricht);
		return kurzeNachricht;
	}
	
	static String kodiereNachricht(String gereinigteNachricht){
		boolean rein = true;
		char buchstabe;
		for(int i = 0; i<gereinigteNachricht.length(); i++){
			buchstabe = gereinigteNachricht.charAt(i);
			if(!('A' <= buchstabe && buchstabe <= 'Z')){
				rein = false;
			}
			
		}
		if(gereinigteNachricht.equals("") || !rein)
			throw new PRException("Die Nachricht enthält keine kodierbaren Zeichen");
		else{	
			
		gereinigteNachricht = gereinigteNachricht.replaceAll("A", "kkkkk");
		gereinigteNachricht = gereinigteNachricht.replaceAll("B", "kkkkg");
		gereinigteNachricht = gereinigteNachricht.replaceAll("C", "kkkgk");
		gereinigteNachricht = gereinigteNachricht.replaceAll("D", "kkkgg");
		gereinigteNachricht = gereinigteNachricht.replaceAll("E", "kkgkk");
		gereinigteNachricht = gereinigteNachricht.replaceAll("F", "kkgkg");
		gereinigteNachricht = gereinigteNachricht.replaceAll("G", "kkggk");
		gereinigteNachricht = gereinigteNachricht.replaceAll("H", "kkggg");
		gereinigteNachricht = gereinigteNachricht.replaceAll("I", "kgkkk");
		gereinigteNachricht = gereinigteNachricht.replaceAll("J", "kgkkk");
		gereinigteNachricht = gereinigteNachricht.replaceAll("K", "kgkkg");
		gereinigteNachricht = gereinigteNachricht.replaceAll("L", "kgkgk");
		gereinigteNachricht = gereinigteNachricht.replaceAll("M", "kgkgg");
		gereinigteNachricht = gereinigteNachricht.replaceAll("N", "kggkk");
		gereinigteNachricht = gereinigteNachricht.replaceAll("O", "kggkg");
		gereinigteNachricht = gereinigteNachricht.replaceAll("P", "kgggk");
		gereinigteNachricht = gereinigteNachricht.replaceAll("Q", "kgggg");
		gereinigteNachricht = gereinigteNachricht.replaceAll("R", "gkkkk");
		gereinigteNachricht = gereinigteNachricht.replaceAll("S", "gkkkg");
		gereinigteNachricht = gereinigteNachricht.replaceAll("T", "gkkgk");
		gereinigteNachricht = gereinigteNachricht.replaceAll("U", "gkkgg");
		gereinigteNachricht = gereinigteNachricht.replaceAll("V", "gkkgg");
		gereinigteNachricht = gereinigteNachricht.replaceAll("W", "gkgkk");
		gereinigteNachricht = gereinigteNachricht.replaceAll("X", "gkgkg");
		gereinigteNachricht = gereinigteNachricht.replaceAll("Y", "gkggk");
		gereinigteNachricht = gereinigteNachricht.replaceAll("Z", "gkggg");	
		}
		String binaerCode = gereinigteNachricht;
//		println(binaerCode);
		

		return binaerCode;
	}
	
	
	static String dekodiereNachricht(String binaerCode){
		String dekodierteNachricht = "";
		//String zum vergleichen des Codes deklarieren
		for(int i = 0; i < binaerCode.length(); i++){
		String dekodieren = "";
	
			dekodieren += binaerCode.charAt(i);
			
			if((i + 1) % 5 == 0){				
//				print(dekodieren + " ");
				if(dekodieren.equals("kkkkk"))
					dekodierteNachricht += "A";
				else if (dekodieren.equals("kkkkg"))
					dekodierteNachricht += "B";
				else if (dekodieren.equals("kkkgk"))
					dekodierteNachricht += "C";
				else if (dekodieren.equals("kkkgg"))
					dekodierteNachricht += "D";
				else if (dekodieren.equals("kkgkk"))
					dekodierteNachricht += "E";
				else if (dekodieren.equals("kkgkg"))
					dekodierteNachricht += "F";
				else if (dekodieren.equals("kkggk"))
					dekodierteNachricht += "G";
				else if (dekodieren.equals("kkggg"))
					dekodierteNachricht += "H";
				else if (dekodieren.equals("kgkkk"))
					dekodierteNachricht += "I";
				else if (dekodieren.equals("kgkkg"))
					dekodierteNachricht += "K";
				else if (dekodieren.equals("kgkgk"))
					dekodierteNachricht += "L";
				else if (dekodieren.equals("kgkgg"))
					dekodierteNachricht += "M";
				else if (dekodieren.equals("kggkk"))
					dekodierteNachricht += "N";
				else if (dekodieren.equals("kggkg"))
					dekodierteNachricht += "O";
				else if (dekodieren.equals("kgggk"))
					dekodierteNachricht += "P";
				else if (dekodieren.equals("kgggg"))
					dekodierteNachricht += "Q";
				else if (dekodieren.equals("gkkkk"))
					dekodierteNachricht += "R";
				else if (dekodieren.equals("gkkkg"))
					dekodierteNachricht += "S";
				else if (dekodieren.equals("gkkgk"))
					dekodierteNachricht += "T";
				else if (dekodieren.equals("gkkgg"))
					dekodierteNachricht += "U";
				else if (dekodieren.equals("gkgkk"))
					dekodierteNachricht += "W";
				else if (dekodieren.equals("gkgkg"))
					dekodierteNachricht += "X";
				else if (dekodieren.equals("gkggk"))
					dekodierteNachricht += "Y";
				else if (dekodieren.equals("gkggg"))
					dekodierteNachricht += "Z";
				else
					dekodierteNachricht += "#";
				
				//String zum Vergleichen zurücksetzen
				dekodieren = "";
			}
					
		}
//		println("\n Dekodierte: "+ dekodierteNachricht);
		return dekodierteNachricht;
	}
	
//	static String versteckeNachricht(String nachricht, String traegerMedium){
//		String versteckteNachricht = "";
//		String binaerCode = kodiereNachricht(reinigeNachricht(nachricht));
//		int j = 0;
//		if(binaerCode.length() > traegerMedium.length())
//			throw new PRException("Das Trägermedium ist zu kurz.");
//		else{
//			for(int i = 0; i < binaerCode.length();i++){
//				if ((('A' <= traegerMedium.charAt(i) && traegerMedium.charAt(i) >= 'Z') || 
//					('a' <= traegerMedium.charAt(i) && traegerMedium.charAt(i) >= 'z') ||
//					traegerMedium.charAt(i) =='Ö' ||
//					traegerMedium.charAt(i) =='Ä' ||
//					traegerMedium.charAt(i) =='Ü' ||
//					traegerMedium.charAt(i) =='ö' ||
//					traegerMedium.charAt(i) =='ä' ||
//					traegerMedium.charAt(i) =='ü' ) &&
//					binaerCode.charAt(j) == 'g' && 
//					!(traegerMedium.charAt(i) =='ß') ){
////					bisherige Überlegung:
//						String traegerMediumZeichen = "" + traegerMedium.charAt(i);
//						traegerMediumZeichen = traegerMediumZeichen.toUpperCase(); 
//						versteckteNachricht += traegerMediumZeichen;
//						j++;
//
//				}
//				else if ((('A' <= traegerMedium.charAt(i) && traegerMedium.charAt(i) >= 'Z') || 
//					('a' <= traegerMedium.charAt(i) && traegerMedium.charAt(i) >= 'z') ||
//					traegerMedium.charAt(i) =='Ö' ||
//					traegerMedium.charAt(i) =='Ä' ||
//					traegerMedium.charAt(i) =='Ü' ||
//					traegerMedium.charAt(i) =='ö' ||
//					traegerMedium.charAt(i) =='ä' ||
//					traegerMedium.charAt(i) =='ü' ||
//					traegerMedium.charAt(i) =='ß' ) &&
//					binaerCode.charAt(j) == 'k'){
//						String traegerMediumZeichen = "" + traegerMedium.charAt(i);
//						traegerMediumZeichen = traegerMediumZeichen.toLowerCase();						
//						versteckteNachricht += traegerMediumZeichen;
//						j++;
//				}
//				else{
//				String traegerMediumZeichen = "" + traegerMedium.charAt(i);						
//				versteckteNachricht += traegerMediumZeichen;						
//				}	
//				println(versteckteNachricht);
//			}			
//		}
//		return versteckteNachricht;
//	}
	
	
	static String versteckeNachricht(String nachricht, String traegerMedium){
		String versteckteNachricht = "";
		String binaerCode = kodiereNachricht(reinigeNachricht(nachricht));
		int j = 0;
		String traegerMediumZeichen = "";
//		println("Trägermedium: "+traegerMedium.length() + "-" + traegerMedium);
//		println("Binärlänge : "+binaerCode.length());
		if(binaerCode.length() > traegerMedium.length())//ohne anzahl der ß und sonderzeichen
			throw new PRException("Das Trägermedium ist zu kurz.");
		else{
			for(int i = 0; i < traegerMedium.length();i++){
				if ((('A' <= traegerMedium.charAt(i) && traegerMedium.charAt(i) <= 'Z') || 
					('a' <= traegerMedium.charAt(i) && traegerMedium.charAt(i) <= 'z') ||
					traegerMedium.charAt(i) =='Ö' ||
					traegerMedium.charAt(i) =='Ä' ||
					traegerMedium.charAt(i) =='Ü' ||
					traegerMedium.charAt(i) =='ö' ||
					traegerMedium.charAt(i) =='ä' ||
					traegerMedium.charAt(i) =='ü' ) &&
					!(traegerMedium.charAt(i) =='ß') ){
					if(j < binaerCode.length()){
						if(binaerCode.charAt(j)=='k' && j < binaerCode.length()){
							traegerMediumZeichen = String.valueOf(traegerMedium.charAt(i));
							versteckteNachricht +=  traegerMediumZeichen.toLowerCase();
							j++;
						}
						else if(binaerCode.charAt(j)=='g'){
							traegerMediumZeichen = String.valueOf(traegerMedium.charAt(i));
							versteckteNachricht += traegerMediumZeichen.toUpperCase();
							j++;
						}	
							
					}
					else	
						versteckteNachricht += String.valueOf(traegerMedium.charAt(i));
				}
				else{
					versteckteNachricht += String.valueOf(traegerMedium.charAt(i));
					
				}
//				println("Für i:"+ i + " " + versteckteNachricht);
			}
			
		}
		return versteckteNachricht;
	}
	
	static String zeigeNachricht(String steganogramm){

		String binaerCode = "";
		
		for(int i = 0; i < steganogramm.length(); i++){
			if(('A' <= steganogramm.charAt(i) && steganogramm.charAt(i) <= 'Z') || 
					steganogramm.charAt(i) =='Ö' ||
					steganogramm.charAt(i) =='Ä' ||
					steganogramm.charAt(i) =='Ü' ){
				binaerCode += "g";
//				println("i: " + i + "g");
			}
			else if(('a' <= steganogramm.charAt(i) && steganogramm.charAt(i) <= 'z') || 
					steganogramm.charAt(i) =='ö' ||
					steganogramm.charAt(i) =='ä' ||
					steganogramm.charAt(i) =='ü' ){
				binaerCode += "k";
//				println("i: " + i + "k");
				}
					
		}
//		println(binaerCode);
		return dekodiereNachricht(binaerCode);
	}
	
	public static void main(String[] args) {
//		print("Bitte geben Sie einen Text ein: ");
//		String nachricht = readString();
//		String gereinigteNachricht = reinigeNachricht(nachricht);
//		String binaerCode = kodiereNachricht(gereinigteNachricht);
//		String dekodierteNachricht = dekodiereNachricht(binaerCode);
		
//		println(versteckeNachricht("Hallo Welt!", "Es ist traurig zu denken, die Natur spricht und keiner hört zu."));
		
//		print(zeigeNachricht("es IST trauriG zU deNkEn, dIE nATuR spriCht uNd KeIneR hört zu"));
		String Botschaft = "ZZ";
		String TraegerMedium = "Mein Name ist Juan Sanchez Villa-Lobos Ramirez, oberster Metallurge am Hofe König Karl V. von Spanien; ich wurde 896 vor Christus in Ägypten geboren und bin unsterblich seit 846 vor Christus.”";
		println(versteckeNachricht(Botschaft, TraegerMedium));
//		println(zeigeNachricht(versteckeNachricht(Botschaft, TraegerMedium)));
//		println(kodiereNachricht("a"));

	}

}


/**
*
*1.
*static String reinigeNachricht(String nachricht)
*alles->groß, toUppercase()
* Sonderzeichen ä->au etc.
* Sonderzeichen entfernen
*
* 2.
* static String kodiereNachricht(String gereinigteNachricht)
* gemäß binärcode (tabelle) kodieren
* ->falsche übergabe -> PRException
* HALLO->kkgggkkkkkgkgkkgkgkkgg...
* 
* 3.
* static String dekodiereNachricht(String binaerCode)
* binär zu Klartext
* kkgggkkkkkgkgkkgkgkkgg...->HALLO
* 5er Block unbekannt-> "#"
* doppeldeutiger Code -> ersten Buchstaben (s.h. Tabelle, z.b. "I, J")
* wenn nicht modulo 5 = 0 -> rest ignorieren
*  
*  4.
*  static String versteckeNachricht(String nachricht, String traegerMedium)
*  Nachricht mit reinigeNachricht und kodiereNachricht umwandeln
*  Wenn Trägermedium zu kurz -> PRException
*  Trägermedium mittels Geheimtext umwandeln
*  Wenn Sonderzeichen -> nächster Buchstabe
*  
*  5.
*  
* 
*/
