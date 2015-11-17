package data;

import java.util.ArrayList;
import java.util.Collections;
import user.Config;

public class Corpus {

	public static String modifierPoor(){
	    ArrayList<String> PoorList = new ArrayList<String>();
	    PoorList.add("poor");
	    PoorList.add("impoverished");

	    Collections.shuffle(PoorList);
	    return PoorList.get(0);
	}

	public static String nounOccupation(){
		ArrayList<String> OccupationList = new ArrayList<String>();
		OccupationList.add("occupation");
		OccupationList.add("employment");
		Collections.shuffle(OccupationList);
		return OccupationList.get(0);
	}

	public static String modifierHouseholds(){
	    ArrayList<String> HouseholdList = new ArrayList<String>();
	    HouseholdList.add("households");
	    HouseholdList.add("families");
	    Collections.shuffle(HouseholdList);
	    return HouseholdList.get(0);
	}

	public static String modifierFound(){
	    ArrayList<String> FoundList = new ArrayList<String>();
	    FoundList.add("located");
	    FoundList.add("found");

	    Collections.shuffle(FoundList);
	    return FoundList.get(0);
	}

	public static String modifierRespondents(){
	    ArrayList<String> RespondentList = new ArrayList<String>();
	    RespondentList.add("respondents");
	    Collections.shuffle(RespondentList);
	    return RespondentList.get(0);
	}

	public static String modifierComprises(){
	    ArrayList<String> ComprisesList = new ArrayList<String>();
	    ComprisesList.add("comprises");
	    ComprisesList.add("composed of");
	    ComprisesList.add("consists of");
	    
	    Collections.shuffle(ComprisesList);
	    return ComprisesList.get(0);
	}

	public static String modifierHighest(){
		ArrayList<String> HighestList = new ArrayList<String>();
		HighestList.add("highest");
		
		Collections.shuffle(HighestList);
		return HighestList.get(0);
	}
	
	public static String modifierLowest(){
		ArrayList<String> HighestList = new ArrayList<String>();
		HighestList.add("lowest");
		
		Collections.shuffle(HighestList);
		return HighestList.get(0);
	}
	
	public static String modifierNumber(){
		ArrayList<String> NumberList = new ArrayList<String>();
		NumberList.add("number");
		NumberList.add("tally");
		
		Collections.shuffle(NumberList);
		return NumberList.get(0);
	}	
	
	public static String forIn(){
		ArrayList<String> forIn = new ArrayList<String>();
		forIn.add("For");
		forIn.add("In");
		
		Collections.shuffle(forIn);
		return forIn.get(0);
	}
	
	public static String ranking(Config user){
		if (user.getModeVariants() == Config.HIGHEST_AREA_HIGHEST_OCCU || user.getModeVariants() == Config.LOWEST_AREA_HIGHEST_OCCU){
			return modifierHighest();
		}
		else{
			return modifierLowest();
		}
	}
	
	public static String ranking1(Config user){
		ArrayList<String> words = new ArrayList<String>();
		if (user.getModeVariants() == Config.HIGHEST_AREA_HIGHEST_OCCU || user.getModeVariants() == Config.LOWEST_AREA_HIGHEST_OCCU){
			words.add("majority");
			Collections.shuffle(words);
			return words.get(0);
		}
		else{
			words.add("small portions");
			Collections.shuffle(words);
			return words.get(0);
		}
	}
	
	public static String ranking2(Config user){
		ArrayList<String> words = new ArrayList<String>();
		if (user.getModeVariants() == Config.HIGHEST_AREA_HIGHEST_OCCU || user.getModeVariants() == Config.HIGHEST_AREA_LOWEST_OCCU){
			words.add("high counts");
			Collections.shuffle(words);
			return words.get(0);
		}
		else{
			words.add("low counts");
			Collections.shuffle(words);
			return words.get(0);
		}
	}
	
	public static String ranking3(Config user){
		ArrayList<String> words = new ArrayList<String>();
		if (user.getModeVariants() == Config.HIGHEST_AREA_HIGHEST_OCCU || user.getModeVariants() == Config.HIGHEST_AREA_LOWEST_OCCU){
			words.add("most");
			Collections.shuffle(words);
			return words.get(0);
		}
		else{
			words.add("least");
			Collections.shuffle(words);
			return words.get(0);
		}
	}
	
	public static String ranking4(Config user){
		ArrayList<String> words = new ArrayList<String>();
		if (user.getModeVariants() == Config.HIGHEST_AREA_HIGHEST_OCCU || user.getModeVariants() == Config.LOWEST_AREA_HIGHEST_OCCU){
			words.add(" ");
			Collections.shuffle(words);
			return words.get(0);
		}
		else{
			words.add("lowest ");
			Collections.shuffle(words);
			return words.get(0);
		}
	}
	
	
	
}
