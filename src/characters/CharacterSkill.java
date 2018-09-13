package characters;

import java.util.ArrayList;

/**
 *
 * @author Nicolas Brax
 */
public class CharacterSkill {
  private final String skillName;
  private final String skillType;
  private int skillRating;
  private ArrayList<String> specializations;
  
  /**
   * 
   */
  public CharacterSkill(){
    this.skillName = "";
    this.skillRating = -1;
    this.skillType = "";
    this.specializations = new ArrayList<>();
  }
  
  /**
   * 
   * @param name
   * @param rating
   */
  public CharacterSkill(String name, int rating){
    this.skillName = name;
    this.skillRating = rating;
    this.skillType = "";
    this.specializations = new ArrayList<>();
  }
  
  /**
   * 
   * @param name
   * @param rating
   * @param type 
   */
  public CharacterSkill(String name, int rating, String type){
    this.skillName = name;
    this.skillRating = rating;
    this.skillType = type;
    this.specializations = new ArrayList<>();
  }

  
  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public String getSkillName() {
    return skillName;
  }

  public int getSkillRating() {
    return skillRating;
  }

  public void setSkillRating(int skillRating) {
    this.skillRating = skillRating;
  }

  public String getSkillType() {
    return skillType;
  }

  public void addSpecialisation(String specialisation){
    this.specializations.add(specialisation);
  }
}
