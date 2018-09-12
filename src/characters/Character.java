package characters;

import java.util.HashMap;

/**
 * This class is the mother class for all characters created in this software
 * suit, either playable or not playable. It regroups all the intel in order to 
 * provide the Civil Status of the character: sex, name, age, weight, ...
 * @author Nicolas Brax
 */
public class Character {
  
  protected boolean female;
  protected String familyName;
  protected String firstname;
  protected String surname;
  protected int age;
  protected double height;
  protected double weight;
  protected String eyeColor;
  protected String ethnicity;
  protected HashMap<String,CharacterAttribute> attributeList;
  protected HashMap<String,CharacterSkill> skillList;
  protected HashMap<String,CharacterQuality> qualityList;
  
  /**
   * The Constructor for the Character class.
   */
  public Character(){
    female = true;
    familyName = "";
    firstname = "";
    surname = "";
    age = 0;
    height = 0.0;
    weight = 0.0;
    eyeColor = "";
    ethnicity = "";
    attributeList = new HashMap<>();
    skillList = new HashMap<>();
    qualityList = new HashMap<>();
  }
  
  
  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public boolean isFemale() {
    return female;
  }

  public void setFemale(boolean female) {
    this.female = female;
  }

  public String getFamilyname() {
    return familyName;
  }

  public void setFamilyname(String familyname) {
    this.familyName = familyname;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }
  
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public double getSize() {
    return height;
  }

  public void setSize(double size) {
    this.height = size;
  }

  public double getWeigth() {
    return weight;
  }

  public void setWeigth(double weight) {
    this.weight = weight;
  }

  public String getEyecolor() {
    return eyeColor;
  }

  public void setEyecolor(String eyecolor) {
    this.eyeColor = eyecolor;
  }

  public String getEthnicity() {
    return ethnicity;
  }

  public void setEthnicity(String ethnicity) {
    this.ethnicity = ethnicity;
  }
}
