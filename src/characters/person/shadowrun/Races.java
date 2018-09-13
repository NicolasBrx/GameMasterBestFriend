package characters.person.shadowrun;

/**
 *
 * @author Nicolas Brax
 */
public enum Races {
  
  Dwarf("Dwarf"),
  Elf("Elf"),
  Ork("Ork"),
  Troll("Troll"),
  Human("Human");
  
  private final String text;
  
  Races(final String text){
    this.text = text; 
  }
  
  // TODO maybe add the possible sub ethny
  
}
