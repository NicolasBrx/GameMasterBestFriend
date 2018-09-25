package characters.person.shadowrun;

import exceptions.RPG_CharacterManagementException;

/**
 * The various games that might be handled by the Game Master Best Friend.
 * @author Nicolas BRAX
 */
public enum LifeStyles {

  Street("Street"),
  Squat("Squat"),
  Low("Low"),
  Middle("Middle"),
  High("High"),
  Luxury("Luxury");
  
  /**
   * 
   */
  private final String text;
  
  /**
   * 
   * @param text 
   */
  LifeStyles(final String text){
    this.text = text;
  }
  
  /**
   * 
   * @param lifeText
   * @return 
   */
  public LifeStyles getLifeStyle(String lifeText){
    for(LifeStyles style : LifeStyles.values()){
      if(style.text.equalsIgnoreCase(lifeText)){
        return style;
      }
    }
    return null;
  }
  
  /**
   * 
   * @return 
   */
  @Override
  public String toString(){
    return text;
  }
  
  /**
   * 
   * @param lf
   * @return 
   * @throws exceptions.RPG_CharacterManagementException 
   */
  public int getCost(LifeStyles lf) throws RPG_CharacterManagementException {
    switch(lf){
      case Street: return 0;
      case Squat:  return 500;
      case Low:    return 2000;
      case Middle: return 5000;
      case High:   return 10000;
      case Luxury: return 100000;
      default: throw new RPG_CharacterManagementException("LifeStyle.getCost(): This is hard coded, this default case should not be reached.");
    }
  }
  
  /**
   * 
   * @param lf
   * @return
   * @throws exceptions.RPG_CharacterManagementException 
   */
  public String getStartingNuyens(LifeStyles lf) throws RPG_CharacterManagementException {
    switch(lf){
      case Street: return "1D6+20";
      case Squat:  return "2D6+40";
      case Low:    return "3D6+60";
      case Middle: return "4D6+100";
      case High:   return "5D6+500";
      case Luxury: return "6D6+1000";
      default: throw new RPG_CharacterManagementException("LifeStyle.getStartingNuyens(): This is hard coded, this default case should not be reached.");
    }
  }
    
    
}
