package game_chooser;

import exceptions.RPG_GameChooserException;

/**
 * The various games that might be handled by the Game Master Best Friend.
 *
 * @author Nicolas BRAX
 */
public enum Games {
  
  NONE("No game choosen",0.0),
  GENERIC("Generic",0.0),
  ADD("Advanced Dungeons and Dragons", 3.5),
  SR("Shadowrun", 5),
  P13("Patient 13", 2),
  CTHULHU("Call of Cthulhu", 7),
  FS("Feng Shui", 2),
  ORESTE("Oreste", 1),
  TOMBEAU("Notre Tombeau", 1);

  private final String text;
  private final double version;

  /**
   * Constructor of a Games enum value.
   * @param text the textual name of the game, human readable.
   * @param version the game version related to the enum value.
   */
  Games(final String text, final double version){
    this.text = text;
    this.version = version;
  }

  /**
   * This method return the Games enum value related to the textual parameter.
   * @param text the String that indicates the Games enum value to retrieve.
   * @return the Game enum value.
   * @throws RPG_GameChooserException if the String does not match any Games 
   *                                  enum values.
   */
  public Games getGame(String text) throws RPG_GameChooserException{
    Games toReturn = null;
    for(Games game : Games.values()){
      if(game.text.equalsIgnoreCase(text)){
        toReturn = game;
      }
    }
    if(toReturn == null){
      throw new RPG_GameChooserException("The game " + text 
                                         +  " is not a valid game.");
    }
    return toReturn;
  }
  
  /**
   * The getter for the textual version of the current Games enum value.
   * @return the textual version of the current Games enum value.
   */
  public String getText(){
    return this.text;
  }
  
  /**
   * The getter for the version number of the current Games enum value.
   * @return the version number of the current Games enum value.
   */
  public double getVersion(){
    return this.version;
  }
}
