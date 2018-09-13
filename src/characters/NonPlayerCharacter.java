package characters;

/**
 *
 * @author Nicolas Brax
 */
public abstract class NonPlayerCharacter extends Character {
  
  protected boolean mobs;
  
  public NonPlayerCharacter(){
    this.mobs = false;
  }
  
  public NonPlayerCharacter(boolean mobs){
    this.mobs = mobs;
  }

  public boolean isMobs(){
    return this.mobs;
  }

  public void setMobs(boolean mobs){
    this.mobs = mobs;
  }
}
