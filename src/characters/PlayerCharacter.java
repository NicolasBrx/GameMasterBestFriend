package characters;

/**
 *
 * @author nibrax
 */
public abstract class PlayerCharacter extends Character {
  
  protected String playerName;
  
  public PlayerCharacter(){
    super();
  }

  public String getPlayerName(){
    return playerName;
  }

  public void setPlayerName(String playerName){
    this.playerName = playerName;
  }
}
