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
    
  /**
   * 
   */
  public CharacterQuality() {
   this.qualityName = "";
    this.qualityDescription = "";
    this.qualityType = "";
    this.relatedSkillOrAttribute = "";
  }

  /**
   * 
   * @param qualityName
   * @param qualityDescription
   * @param qualityType 
   * @param relatedSkillOrAttribute 
   */
  public CharacterQuality(String qualityName, String qualityDescription, 
                             String qualityType,String relatedSkillOrAttribute){
    this.qualityName = qualityName;
    this.qualityDescription = qualityDescription;
    this.qualityType = qualityType;
    this.relatedSkillOrAttribute = relatedSkillOrAttribute;
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
}
