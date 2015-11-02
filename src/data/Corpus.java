package data;

import java.util.ArrayList;
import java.util.Collections;

public class Corpus {

	public static String modifierPoor(){
	    ArrayList<String> PoorList = new ArrayList();
	    PoorList.add("poor");
	    PoorList.add("impoverished");
	    PoorList.add("poverty-stricken");
	    PoorList.add("famished");
	    PoorList.add("penniless");
	
	    Collections.shuffle(PoorList);
	    return PoorList.get(0);
	}
	
	public static String nounOccupation(){
		ArrayList<String> OccupationList = new ArrayList();
		OccupationList.add("vocation");
		OccupationList.add("profession");
		OccupationList.add("occupation");
		
		Collections.shuffle(OccupationList);
		return OccupationList.get(0);
	}
	
	public static String modifierHouseholds(){
	    ArrayList<String> HouseholdList = new ArrayList();
	    HouseholdList.add("households");
	    HouseholdList.add("families");
	
	    Collections.shuffle(HouseholdList);
	    return HouseholdList.get(0);
	}
	
	public static String modifierFound(){
	    ArrayList<String> FoundList = new ArrayList();
	    FoundList.add("located");
	    FoundList.add("found");
	
	    Collections.shuffle(FoundList);
	    return FoundList.get(0);
	}
	
	public static String modifierRespondents(){
	    ArrayList<String> RespondentList = new ArrayList();
	    RespondentList.add("respondents");
	    RespondentList.add("population");
	    
	    Collections.shuffle(RespondentList);
	    return RespondentList.get(0);
	}
	
	public static String modifierComprises(){
	    ArrayList<String> ComprisesList = new ArrayList();
	    ComprisesList.add("comprises");
	    ComprisesList.add("contain");
	    ComprisesList.add("composed of");
	    ComprisesList.add("consists of");
	    
	    Collections.shuffle(ComprisesList);
	    return ComprisesList.get(0);
	}
}
