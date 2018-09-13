package characters;

import exceptions.RPG_CharacterManagementException;

/**
 *
 * @author Nicolas Brax
 */
public class CharacterAttribute {
    
  private final String attributeName;
  private int minValue;
  private int maxValue;
  private int currentValue;
  private int augmentedValue;
  private int modifierValue;
  
  /**
   * 
   * @param attributeName 
   */
  public CharacterAttribute(String attributeName){
    this.attributeName = attributeName;
    this.currentValue = 0;
    this.minValue = -1;
    this.maxValue = -1;
    this.augmentedValue = -1;
    this.modifierValue = 0;
  }
  
  /**
   * 
   * @param attributeName
   * @param currentValue 
   */
  public CharacterAttribute(String attributeName, int currentValue){
    this.attributeName = attributeName;
    this.currentValue = currentValue;
    this.minValue = -1;
    this.maxValue = -1;
    this.augmentedValue = -1;
    this.modifierValue = 0;
  }
  
  /**
   * 
   * @param attributeName
   * @param currentValue
   * @param minValue
   * @param maxValue 
   */
  public CharacterAttribute(String attributeName, int currentValue,  
                                                    int minValue, int maxValue){
    this.attributeName = attributeName;
    this.currentValue = currentValue;
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.augmentedValue = -1;
    this.modifierValue = 0;
  }

  
  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  /**
   * 
   * @param currentValue
   * @throws RPG_CharacterManagementException 
   */
  public void setCurrentValue(int currentValue) 
                                       throws RPG_CharacterManagementException {
    if((currentValue < this.minValue) || (currentValue > this.maxValue)){
      throw new RPG_CharacterManagementException("The value of the attribute "
              + this.attributeName + " must be between " + this.minValue 
              + " and " + this.maxValue + " (currently trying to set to "
              + currentValue + ".");
    }
    else{
      this.currentValue = currentValue;
    }
  }
  
  public int getMinValue(){
    return minValue;
  }

  public void setMinValue(int minValue){
    this.minValue = minValue;
  }

  public int getMaxValue(){
    return maxValue;
  }

  public void setMaxValue(int maxValue){
    this.maxValue = maxValue;
  }

  public int getCurrentValue(){
    return currentValue;
  }

  public int getAugmentedValue(){
    return augmentedValue;
  }

  public void setAugmentedValue(int augmentedValue){
    this.augmentedValue = augmentedValue;
  }

  public String getAttributeName(){
    return attributeName;
  }

  public int getModifierValue(){
    return modifierValue;
  }

  public void setModifierValue(int modifierValue){
    this.modifierValue = modifierValue;
  }
}
