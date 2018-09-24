package characters.person.shadowrun;

import characters.CharacterAttribute;
import characters.PlayerCharacter;
import characters.equipment.shadowrun.Gear;
import characters.equipment.shadowrun.GearAugmentation;
import characters.social.shadowrun.Contact;
import characters.social.shadowrun.Identity;
import exceptions.RPG_CharacterManagementException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Nicolas Brax
 */
public class ShadowrunPlayerCharacter extends PlayerCharacter {
    
  private ShadowrunRaces race;
  
  private HashMap<String,Integer> reputation; //street credit, public awareness, notoriety
  
  private RunnerTypes runnertype;
  private SpecialSkills specialskill;
  
  private HashMap<String,Integer> computedAttribute;
  // initiatives, matrixInit, astralInit, physicalLimit,mentalLimit, socialLimit
  // physical dmg track, stun damage track, overflow, composure, judgeIntention,
  // memory, lift, movement, life cost adjustment
  
  private int startingNuyens;
  private double essance;
  
  private LifeStyles lifestyle;
  
  // other information and data
  private ArrayList<String> raceAdvantages;
  private ArrayList<Identity> identityList;
  private ArrayList<Contact> contactList;
  private ArrayList<GearAugmentation> augmentationList;
  private ArrayList<Gear> gearList;
  
  
  public ShadowrunPlayerCharacter(){
    // TODO: the race must be set in first or almost in order to init the attribute...
    // but do we have to put it in the constructor?
  }
  
  /**
   * 
   */
  public void computeDerivatedAttribute(){
    
  }
  
  /**
   * 
   * @param race 
   */
  public void setRace(String race){
    this.race = ShadowrunRaces.valueOf(race);
    this.attributeList.put("body", 
            new CharacterAttribute("body",(race.equalsIgnoreCase("dwarf") ? 3 :
                                  (race.equalsIgnoreCase("ork") ? 4 :
                                    (race.equalsIgnoreCase("troll") ? 5
                                    : 1) // other race
                                  ) // end ork
                                ) // race check
                                )// end attribute
            ); // end body 
    
    this.attributeList.put("strength", 
        new CharacterAttribute("strength",(race.equalsIgnoreCase("dwarf") ? 3 :
                              (race.equalsIgnoreCase("ork") ? 3 :
                                (race.equalsIgnoreCase("troll") ? 5
                                : 1) // other race
                              ) // end ork
                            ) // race check
                            )// end attribute
        ); // end strength
    
    
    this.attributeList.put("reaction",new CharacterAttribute("reaction",1));
    this.attributeList.put("intuition",new CharacterAttribute("intuition",1));
    this.attributeList.put("agility", new CharacterAttribute("agility",
                                       (race.equalsIgnoreCase("elf") ? 2 : 1)));
    this.attributeList.put("agility", new CharacterAttribute("agility",
                                     (race.equalsIgnoreCase("dwarf") ? 2 : 1)));
    this.attributeList.put("logic",new CharacterAttribute("logic",1));
    this.attributeList.put("agility", new CharacterAttribute("agility",
                                       (race.equalsIgnoreCase("elf") ? 3 : 1)));
  }
  
  /**
   * 
   */
  public void setSpecialAttributes(){
    this.attributeList.put("edge",new CharacterAttribute("edge",
                      (this.race.getRace().equalsIgnoreCase("human") ? 2 : 1)));
    this.attributeList.put("magic",new CharacterAttribute("magic", 
                        (this.specialskill == SpecialSkills.magician ? 1 : 0)));
    this.attributeList.put("resonance",new CharacterAttribute("resonance", 
                    (this.specialskill == SpecialSkills.technomancer ? 1 : 0)));
  }
  
  /**
   * 
   * @param attribute
   * @param modifier
   * @param special 
   */
  public void modifyAttribute(String attribute, int modifier, boolean special)
                                       throws RPG_CharacterManagementException {
    if(((this.attributeList.get(attribute).getCurrentValue() + modifier) 
                              > this.attributeList.get(attribute).getMaxValue())
    || ((this.attributeList.get(attribute).getCurrentValue() + modifier) < 0)
    && !godMode
    ){
      throw new RPG_CharacterManagementException("Attribute value must be "
                + "between " + this.attributeList.get(attribute).getMinValue()  
                + "and " + this.attributeList.get(attribute).getMaxValue() 
                + ".");
    }
    else{
      if(!special 
      && ((this.attributeList.get(attribute).getCurrentValue() + modifier) 
                           == this.attributeList.get(attribute).getMaxValue())){
        if(checkLimits()){
          this.attributeList.get(attribute).setCurrentValue(
                this.attributeList.get(attribute).getCurrentValue() + modifier);
        }
      }
    }
  }
  
  /**
   * 
   * @return 
   */
  private boolean checkLimits(){
    boolean toReturn = true;
    if(!godMode){
      for(CharacterAttribute a : this.attributeList.values()){
        if(a.getCurrentValue() == a.getMaxValue()){
          toReturn = false;
        }
      }
    }
    return toReturn;
  }
  
  @Override
  public void saveCharacter(){
    //TODO
  }
  
  @Override
  public void loadCharacter(String playerName){
    //TODO
  }
}
