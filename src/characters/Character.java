package characters;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class is the mother class for all characters created in this software
 * suit, either playable or not playable. It regroups all the intel in order to 
 * provide the Civil Status of the character: sex, name, age, weight, ...
 * @author Nicolas Brax
 */
public abstract class Character {
  
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
  
  protected ArrayList<String> information;
  
  protected boolean godMode;
  
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
    information = new ArrayList<>();
    godMode = false;
  }
  
  public abstract void saveCharacter();
  public abstract void loadCharacter(String name);
  
  
  /****************************************************************************/
  /*****                    Getter and Setter Methods                     *****/
  /****************************************************************************/
  public boolean isFemale() {
    return female;
  }

  public void setFemale(boolean female) {
    this.female = female;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyname) {
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

  public String getEyeColor() {
    return eyeColor;
  }

  public void setEyeColor(String eyecolor) {
    this.eyeColor = eyecolor;
  }

  public String getEthnicity() {
    return ethnicity;
  }

  public void setEthnicity(String ethnicity) {
    this.ethnicity = ethnicity;
  }

  public double getHeight(){
    return height;
  }

  public void setHeight(double height){
    this.height = height;
  }

  public double getWeight(){
    return weight;
  }

  public void setWeight(double weight){
    this.weight = weight;
  }

  public HashMap<String, CharacterAttribute> getAttributeList(){
    return attributeList;
  }

  public void setAttributeList(HashMap<String, CharacterAttribute> attributeList){
    this.attributeList = attributeList;
  }

  public HashMap<String, CharacterSkill> getSkillList(){
    return skillList;
  }

  public void setSkillList(HashMap<String, CharacterSkill> skillList){
    this.skillList = skillList;
  }

  public HashMap<String, CharacterQuality> getQualityList(){
    return qualityList;
  }

  public void setQualityList(HashMap<String, CharacterQuality> qualityList){
    this.qualityList = qualityList;
  }

  public ArrayList<String> getInformation(){
    return information;
  }

  public void setInformation(ArrayList<String> information){
    this.information = information;
  }
  
  public boolean isGodMode(){
    return godMode;
  }

  public void setGodMode(boolean godMode){
    this.godMode = godMode;
  }
  
  // TODO: remove a piece of information
}
