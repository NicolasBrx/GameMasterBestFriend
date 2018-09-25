package characters;

/**
 *
 * @author nibrax
 */
public class CharacterQuality {
  
  private final String qualityName;
  private final String qualityDescription;
  private final String qualityType;
  private final String relatedSkillOrAttribute;
  private int scoreModifier;
  private int cost;
    
  /**
   * 
   */
  public CharacterQuality() {
    this.qualityName = "";
    this.qualityDescription = "";
    this.qualityType = "";
    this.relatedSkillOrAttribute = "";
    this.scoreModifier = 0;
    this.cost = 0;
  }
  
  /**
   * 
   * @param qualityName
   * @param relatedSkillOrAttribute 
   * @param scoreModifier 
   */
  public CharacterQuality(String qualityName, String relatedSkillOrAttribute,
                          int scoreModifier
  ){
    this.qualityName = qualityName;
    this.qualityDescription = "";
    this.qualityType = "";
    this.relatedSkillOrAttribute = relatedSkillOrAttribute;
    this.scoreModifier = scoreModifier;
    this.cost = 0;
    
  }
  
  /**
   * 
   * @param qualityName
   * @param relatedSkillOrAttribute 
   * @param scoreModifier 
   * @param cost 
   */
  public CharacterQuality(String qualityName, String relatedSkillOrAttribute,
                          int scoreModifier, int cost
  ){
    this.qualityName = qualityName;
    this.qualityDescription = "";
    this.qualityType = "";
    this.relatedSkillOrAttribute = relatedSkillOrAttribute;
    this.scoreModifier = scoreModifier;
    this.cost = cost;
    
  }

  /**
   * 
   * @param qualityName
   * @param qualityDescription
   * @param qualityType 
   * @param relatedSkillOrAttribute 
   * @param scoreModifier 
   */
  public CharacterQuality(String qualityName, String qualityDescription, 
                          String qualityType,String relatedSkillOrAttribute,
                          int scoreModifier
  ){
    this.qualityName = qualityName;
    this.qualityDescription = qualityDescription;
    this.qualityType = qualityType;
    this.relatedSkillOrAttribute = relatedSkillOrAttribute;
    this.scoreModifier = scoreModifier;
  }

  
  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public String getQualityName() {
    return qualityName;
  }

  public String getQualityDescription() {
    return qualityDescription;
  }

  public String getQualityType() {
    return qualityType;
  }

  public String getRelatedSkillOrAttribute() {
    return relatedSkillOrAttribute;
  } 
  
  public void setScoreModifier(int scoreModifier){
    this.scoreModifier = scoreModifier;
  }
  
  public int getScoreModifier(){
    return this.scoreModifier;
  }

  public int getCost(){
    return cost;
  }

  public void setCost(int cost){
    this.cost = cost;
  }
  
}
