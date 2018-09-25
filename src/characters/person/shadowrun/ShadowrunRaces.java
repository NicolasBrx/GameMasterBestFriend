package characters.person.shadowrun;

import exceptions.RPG_GameChooserException;
import java.util.ArrayList;

/**
 *
 * @author Nicolas Brax
 */
public enum ShadowrunRaces {
  
  Dwarf("Dwarf"),
  Elf("Elf"),
  Ork("Ork"),
  Troll("Troll"),
  Human("Human");
  
  private final String text;
  private final ArrayList<String> raceAdvantages;
  private int lifeCostAdjustment;
  
  // TODO maybe add the possible sub ethny
  
  ShadowrunRaces(final String text){
    this.text = text; 
    this.raceAdvantages = new ArrayList<>();
    switch(text){
      case "Dwarf":
        this.raceAdvantages.add("thermic vision");
        this.raceAdvantages.add("+2 against illness and poisons");
        this.raceAdvantages.add("+20% life costs");
        this.lifeCostAdjustment = 20;
        break;
      case "Elf":
        this.raceAdvantages.add("night vision");
        this.lifeCostAdjustment = 0;
        break;
      case "Ork":
        this.raceAdvantages.add("night vision");
        this.lifeCostAdjustment = 0;
        break;
      case "Troll":
        this.raceAdvantages.add("thermic vision");
        this.raceAdvantages.add("+1 reach");
        this.raceAdvantages.add("+1 skin armor");
        this.raceAdvantages.add("+100% life costs");
        this.lifeCostAdjustment = 100;
        break;
      case "Human":
        this.lifeCostAdjustment = 0;
        break;
    }//end switch
  }
  
  public String getText(){
    return this.text;  
  }
  
  public ShadowrunRaces getRace(String text) throws RPG_GameChooserException{
    ShadowrunRaces toReturn = null;
    for(ShadowrunRaces game : ShadowrunRaces.values()){
      if(game.text.equalsIgnoreCase(text)){
        toReturn = game;
      }
    }
    if(toReturn == null){
      throw new RPG_GameChooserException("The game " + text 
                                         +  " is not a valid game.");
    }
    return toReturn;
  }
  
  public int getLifeCostAdjustment(){
    return this.lifeCostAdjustment;  
  }
  
  public ArrayList<String> getRaceAdvantages(){
    return this.raceAdvantages;  
  }
  
}
