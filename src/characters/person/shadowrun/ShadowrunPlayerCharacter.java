package characters.person.shadowrun;

import characters.CharacterAttribute;
import characters.CharacterQuality;
import characters.CharacterSkill;
import characters.PlayerCharacter;
import characters.equipment.shadowrun.Gear;
import characters.equipment.shadowrun.GearAugmentation;
import characters.social.shadowrun.Contact;
import characters.social.shadowrun.Identity;
import exceptions.RPG_CharacterManagementException;
import exceptions.RPG_GameChooserException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Nicolas Brax
 */
public class ShadowrunPlayerCharacter extends PlayerCharacter {
    
  private ShadowrunRaces race;
  
  private HashMap<String,Integer> reputations; //street credit, public awareness, notoriety
  
  private RunnerTypes runnertype;
  private SpecialSkills specialskill;
  
  // computed and derived attributes
  private HashMap<String,Integer> initiatives; // initiative, astral initiative, matrix initiative, initiative passes
  private HashMap<String,Integer> limits; //mental limot, physical limit and social limit
  private HashMap<String,Integer> conditions; // physical damages track, stun damage track, condition overflow
  private HashMap<String,Integer> otherSkills;
  
  private int karma, initialKarma;
  private int startingNuyens;
  private double essence;
  
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
   * @throws exceptions.RPG_CharacterManagementException
   */
  public void computeDerivatedAttribute() 
                                       throws RPG_CharacterManagementException {
    this.initiatives.put("initiative", (getIntuition() + getReaction() 
                                  + ThreadLocalRandom.current().nextInt(1, 7)));
    this.initiatives.put("matrix initiative", (getIntuition() + getReaction() 
                                  + ThreadLocalRandom.current().nextInt(1, 7)));
    if(this.specialskill == SpecialSkills.magician){
      initiatives.put("astral initiative", (getIntuition() * 2 
                                  + ThreadLocalRandom.current().nextInt(1, 7) 
                                  + ThreadLocalRandom.current().nextInt(1, 7)));
    }
    
    this.limits.put("mental", Math.floorDiv((getLogic() * 2 + getBody() 
                                                          + getWillpower()),3));
    this.limits.put("physical", Math.floorDiv((getStrength() * 2 + getBody() 
                                                           + getReaction()),3));
    this.limits.put("social", Math.floorDiv((getCharisma() * 2 + getWillpower() 
                                            + (int)Math.ceil(this.essence)),3));
    
    this.conditions.put("physical", 8 + Math.floorDiv(getBody(), 2));
    this.conditions.put("stun", 8 + Math.floorDiv(getWillpower(), 2));
    this.conditions.put("overflow", getBody());
    this.conditions.put("armor",0); // TODO: for now, modified by gears and possibly by metatype
    
    this.reputations.put("notoriety", this.reputations.get("public awareness") 
                                       + this.reputations.get("street credit"));
    
    
    this.otherSkills.put("composure", getCharisma() + getWillpower());
    this.otherSkills.put("judge intention", getCharisma() + getIntuition());
    this.otherSkills.put("lift", getBody() + getStrength());
    this.otherSkills.put("memory",  getLogic() + getWillpower());
    this.otherSkills.put("movement", getAgility() * 2);
    
    this.startingNuyens = (Integer.parseInt(
                   lifestyle.getStartingNuyens(this.lifestyle).split("D")[0]) 
                * ThreadLocalRandom.current().nextInt(1, 7))
                + Integer.parseInt(
                   lifestyle.getStartingNuyens(this.lifestyle).split("\\+")[1]);
    
    // TODO: compute new attribute values (according to gear and other bonuses/maluses)... when we have the intel
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
                      (this.race.getText().equalsIgnoreCase("human") ? 2 : 1)));
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
   * @throws exceptions.RPG_CharacterManagementException 
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
  
  /**
   * Beware that the cost of the fear has to be managed by the UI...
   * 
   * @param gear
   * @param remove
   * @return 
   */
  public boolean addGear(Gear gear, boolean remove){
    boolean toReturn = true;
    if(!remove){
      this.gearList.add(gear);
    }
    else{
      toReturn = false;
      for(int i = 0 ; i < gearList.size() ; ++i){
        if(gearList.get(i).getGearName().equals(gear.getGearName())){
          this.gearList.remove(i);
          toReturn = true;
        }
      }
    }
    return toReturn;
  }
  
  /**
   * Beware that the cost of the augmentation has to be managed by the UI in the
   * creation process 
   * 
   * @param augmentation
   * @param remove
   * @return 
   */
  public boolean addAugmentation(GearAugmentation augmentation, boolean remove){
    boolean toReturn = true;
    if(!godMode && (essence - augmentation.getAugmentationEssenceCost() < 0) 
    && !remove){
      toReturn = false;
    }
    else{
      if(!remove){
        this.augmentationList.add(augmentation);
        this.essence -= augmentation.getAugmentationEssenceCost();
      }
      else{
        toReturn = false;
        for(int i = 0 ; i < augmentationList.size() ; ++i){
          if(augmentationList.get(i).getGearName().equals(
                                                   augmentation.getGearName())){
            this.essence += augmentation.getAugmentationEssenceCost();
            this.augmentationList.remove(i);
            toReturn = true;
          }
        }
      }
    }
    return toReturn;
  }
  
  /**
   * 
   * @param contact
   * @param add
   * @return 
   */
  public boolean addContact(Contact contact, boolean add){
    boolean toReturn;
    if(add){
      int karmaCost = contact.getContactConnection() 
                    + contact.getContactLoyalty();
      toReturn = checkKarma(karmaCost * -1);
      if(toReturn){
        this.karma -= karmaCost;
        this.contactList.add(contact);  
      }
    }
    else{
      toReturn = false;
      for(int i = 0 ; i < contactList.size() ; ++i){
        if(contactList.get(i).getContactName().equals(contact.getContactName()))
        {
          int karmaCost = contactList.get(i).getContactConnection() 
                                       + contactList.get(i).getContactLoyalty();
          toReturn = checkKarma(karmaCost);
          if(toReturn){
            this.contactList.remove(i);
          }
        }
      }
    }
    return toReturn;
  }
  
  private boolean checkKarma(int karmaModifier){
    boolean toReturn = true;
    if(karmaModifier < 0){
      if((this.karma + karmaModifier) < 0){
        toReturn = false;
      }
    }
    else{
      if((this.karma + karmaModifier) >= (2 * this.initialKarma)){
        toReturn = false;
      }
    }
    return toReturn;
  }
  
  /**
   * 
   * @param quality
   * @param add
   * @return 
   */
  public boolean addQuality(CharacterQuality quality, boolean add){
    boolean toReturn;
    if(add){
      int karmaCost = quality.getCost();
      toReturn = checkKarma(karmaCost * -1);
      if(toReturn){
        this.karma -= karmaCost;
        this.qualityList.put(quality.getQualityName(),quality);  
      }
    }
    else{
      toReturn = false;
      for(String s : qualityList.keySet()){
        if(s.equalsIgnoreCase(quality.getQualityName())){
          toReturn = true;
          int karmaCost = qualityList.get(s).getCost();
          toReturn = checkKarma(karmaCost);
          if(toReturn){
            qualityList.remove(s);
          }
        }
      }
    }
    return toReturn;
  }
  
  /**
   * Beware that this is only for karma tracking, the money gained or spent is 
   * used to create the character and then has to be managed by the UI.
   * 
   * @param karmaCost
   * @param add
   * @return 
   */
  public boolean addNuyens(int karmaCost, boolean add){
    boolean toReturn;
    toReturn = checkKarma((add ? -1 : 1) * karmaCost);
    if(toReturn){
      this.karma += karmaCost  * (add ? -1 : 1);
    }
    return toReturn;
  }
  
  /**
   * 
   * @param skill
   * @param add
   * @return 
   */
  public boolean modifySkill(CharacterSkill skill, boolean add){
    boolean toReturn = false;
    boolean found = false;
    for(String s : this.skillList.keySet()){
      if(this.skillList.get(s).getSkillName().equals(skill.getSkillName())){
        found = true;
        if(this.skillList.get(s).getSkillRating() != (add ? 6 : 0)){
          this.skillList.get(s).setSkillRating(
                       this.skillList.get(s).getSkillRating() + (add ? 1 : -1));
          toReturn = true;
        }
      }
    }
    
    if(!found){
      skill.setSkillRating(1);
      this.skillList.put(skill.getSkillName(),skill);
    }
    
    return toReturn;
  }
  
  public boolean addSpecialisation(String skillName, String specialisation){
    boolean toReturn = false;
    for(String s : this.skillList.keySet()){
      if(this.skillList.get(s).getSkillName().equals(skillName)){
        toReturn = true;
        this.skillList.get(s).addSpecialisation(specialisation);
      }
    }
    return toReturn;
  }
  
  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public ShadowrunRaces getMetatype() {
    return race;
  }

  public void setMetatype(String race) throws RPG_GameChooserException {
    this.race = ShadowrunRaces.valueOf(race);
  }

  public int getStreetcred() {
    return this.reputations.get("street credit");
  }

  public void setStreetcred(int streetcred) {
    this.reputations.put("street credit",streetcred);
  }

  public int getNotoriety() {
    return this.reputations.get("notoriety");
  }

  public void setNotoriety(int notoriety) {
    this.reputations.put("notoriety", notoriety);
  }

  public int getPublicAwareness() {
    return this.reputations.get("public awareness");
  }

  public void setPublicAwareness(int publicAwareness) {
    this.reputations.put("public awareness", publicAwareness);
  }

  public int getKarma() {
    return initialKarma;
  }

  public void setKarma(int karma) {
    this.initialKarma = karma;
  }

  public int getTotalKarma() {
    return karma;
  }

  public void setTotalKarma(int totalKarma) {
    this.karma = totalKarma;
  }

  public int getBody() {
    return this.attributeList.get("body").getCurrentValue();
  }

  public void setBody(int body) throws RPG_CharacterManagementException {
    this.attributeList.get("body").setCurrentValue(body);
  }

  public int getAgility() {
    return this.attributeList.get("agility").getCurrentValue();
  }

  public void setAgility(int agility) throws RPG_CharacterManagementException {
    this.attributeList.get("agility").setCurrentValue(agility);
  }

  public int getReaction() {
    return this.attributeList.get("reaction").getCurrentValue();
  }

  public void setReaction(int reaction) 
                                       throws RPG_CharacterManagementException {
    this.attributeList.get("reaction").setCurrentValue(reaction);
  }

  public int getStrength() {
    return this.attributeList.get("strength").getCurrentValue();
  }

  public void setStrength(int strength) 
                                       throws RPG_CharacterManagementException {
    this.attributeList.get("strength").setCurrentValue(strength);
  }

  public int getWillpower() {
    return this.attributeList.get("willpower").getCurrentValue();
  }

  public void setWillpower(int willpower) 
                                       throws RPG_CharacterManagementException {
    this.attributeList.get("willpower").setCurrentValue(willpower);
  }

  public int getLogic() {
    return this.attributeList.get("logic").getCurrentValue();
  }

  public void setLogic(int logic) throws RPG_CharacterManagementException {
    this.attributeList.get("logic").setCurrentValue(logic);
  }

  public int getIntuition() {
    return this.attributeList.get("intuition").getCurrentValue();
  }

  public void setIntuition(int intuition) 
                                       throws RPG_CharacterManagementException {
    this.attributeList.get("intuition").setCurrentValue(intuition);
  }

  public int getCharisma() {
    return this.attributeList.get("charisma").getCurrentValue();
  }

  public void setCharisma(int charisma) 
                                       throws RPG_CharacterManagementException {
    this.attributeList.get("charisma").setCurrentValue(charisma);
  }

  public int getEdge() {
    return this.attributeList.get("edge").getCurrentValue();
  }

  public void setEdge(int edge) throws RPG_CharacterManagementException {
    this.attributeList.get("edge").setCurrentValue(edge);
  }
  
  public int getMagic(){
    return this.attributeList.get("magic").getCurrentValue();
  }
  
  public void setMagic(int magic) throws RPG_CharacterManagementException {
    this.attributeList.get("magic").setCurrentValue(magic);
  }
  
  public int getResonance(){
    return this.attributeList.get("resonance").getCurrentValue();
  }
  
  public void setResonance(int resonance) 
                                       throws RPG_CharacterManagementException {
    this.attributeList.get("resonance").setCurrentValue(resonance);
  }

  public int getInitiative() {
    return this.initiatives.get("initiative");
  }

  public void setInitiative(int initiative) {
    this.initiatives.put("initiative", initiative);
  }

  public int getMatrixInitiative() {
    return this.initiatives.get("matrix initiative");
  }

  public void setMatrixInitiative(int matrixInitiative) {
    this.initiatives.put("matrix initiative", matrixInitiative);
  }

  public int getAstralInitiative() {
    return this.initiatives.get("astral initiative");
  }

  public void setAstralInitiative(int astralInitiative) {
    this.initiatives.put("astral initiative", astralInitiative);
  }

  public int getComposure() {
    return this.otherSkills.get("composure");
  }

  public void setComposure(int composure) {
    this.otherSkills.put("composure", composure);
  }

  public int getJudgeIntention() {
    return this.otherSkills.get("judge intention");
  }

  public void setJudgeIntention(int judgeIntention) {
    this.otherSkills.put("judge intention", judgeIntention);
  }

  public int getMemory() {
    return this.otherSkills.get("memory");
  }

  public void setMemory(int memory) {
    this.otherSkills.put("memory", memory);
  }

  public int getLift() {
    return this.otherSkills.get("lift");
  }

  public void setLift(int lift) {
    this.otherSkills.put("lift", lift);
  }

  public int getMovement() {
    return this.otherSkills.get("movement");
  }

  public void setMovement(int movement) {
    this.otherSkills.put("movement", movement);
  }

  public int getPhysicalDamageTrack() {
    return this.conditions.get("physical");
  }

  public void setPhysicalDamageTrack(int physicalDamageTrack) {
    this.conditions.put("physical", physicalDamageTrack);
  }

  public int getStunDamageTrack() {
    return this.conditions.get("stun");
  }

  public void setStunDamageTrack(int stunDamageTrack) {
    this.conditions.put("stun", stunDamageTrack);
  }

  public int getPhysicalLimit() {
    return this.limits.get("physical");
  }

  public void setPhysicalLimit(int physicalLimit) {
    this.limits.put("physical",physicalLimit);
  }
  
  public int getOverflow() {
    return this.conditions.get("overflow");
  }

  public void setOverflow(int overflow) {
    this.conditions.put("overflow",overflow);
  }

  public int getMentalLimit() {
    return this.limits.get("mental");
  }

  public void setMentalLimit(int mentalLimit) {
    this.limits.put("mental",mentalLimit);
  }

  public int getSocialLimit() {
    return this.limits.get("social");
  }

  public void setSocialLimit(int socialLimit) {
    this.limits.put("social",socialLimit);
  }

  public ArrayList<Identity> getIdentityList() {
    return identityList;
  }

  public void setIdentityList(ArrayList<Identity> identityList) {
    this.identityList = identityList;
  }

  public HashMap<String,CharacterSkill> getSkillList() {
    return skillList;
  }

  public void setSkillList(HashMap<String,CharacterSkill> skillList) {
    this.skillList = skillList;
  }

  public HashMap<String,CharacterQuality> getQualityList() {
    return qualityList;
  }

  public void setQualityList(HashMap<String,CharacterQuality> qualityList) {
    this.qualityList = qualityList;
  }

  public ArrayList<Contact> getContactList() {
    return contactList;
  }

  public void setContactList(ArrayList<Contact> contactList) {
    this.contactList = contactList;
  }
  
  public SpecialSkills getSpecialSkill(){
    return this.specialskill;
  }
  
  public RunnerTypes getRunnerType(){
    return this.runnertype;
  }

  public double getEssence() {
    return essence;
  }

  public void setEssence(double essence) {
    this.essence = essence;
  }

  public ArrayList<GearAugmentation> getAugmentationList() {
    return augmentationList;
  }

  public void setAugmentationList(
                                 ArrayList<GearAugmentation> augmentationList) {
    this.augmentationList = augmentationList;
  }

  public int getStartingNuyens() {
    return startingNuyens;
  }

  public void setStartingNuyens(int startingNuyens) {
    this.startingNuyens = startingNuyens;
  }

  public int getLifeCostAdjustment() {
    return this.race.getLifeCostAdjustment();
  }

  public LifeStyles getLifeStyle() {
    return lifestyle;
  }

  public void setLifeStyle(LifeStyles lifeStyle) {
    this.lifestyle = lifeStyle;
  }

  public ArrayList<String> getRaceAdvantages() {
    return raceAdvantages;
  }

  public void setRaceAdvantages(ArrayList<String> raceAdvantages) {
    this.raceAdvantages = raceAdvantages;
  }

  public ArrayList<Gear> getGearList() {
    return gearList;
  }

  public void setGearList(ArrayList<Gear> gearList) {
    this.gearList = gearList;
  }
  
  /****************************************************************************/
  /*****                      Load and Save Methods                       *****/
  /****************************************************************************/
  
  @Override
  public void saveCharacter(){
    //TODO
  }
  
  @Override
  public void loadCharacter(String playerName){
    //TODO
  }
}
