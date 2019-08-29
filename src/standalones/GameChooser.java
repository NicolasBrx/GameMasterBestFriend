package standalones;

import game_chooser.Games;
import ihm.IHM_GameChooser;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.UnsupportedLookAndFeelException;
import exceptions.RPG_GameChooserException;
import tools.xmlloader.XML_GameChooser;

/**
 * This plugin is dedicated to be used with the RPG whole software as a game
 * chooser for the user and the initialisation of the other plugns.
 * 
 * @author Nicolas Brax
 */
public class GameChooser {
 
  /**
   * The IHM related to the plugin.
   */
  private static IHM_GameChooser ihm;
  
  /**
   * An HashMap to register and use the game names and description.
   */
  private static HashMap<String,ArrayList<String>> gameData = new HashMap<>();

  /**
   * The main method to launch the IHM and initialize the user interface
   * 
   * @param args The command line arguments
   * @throws exceptions.RPG_GameChooserException
   */
  public static void main(String[] args) throws RPG_GameChooserException {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }catch(ClassNotFoundException | InstantiationException 
         | IllegalAccessException | UnsupportedLookAndFeelException ex){
      throw new RPG_GameChooserException("Can't set the UI Look and Feel.");
    }
    ihm = new IHM_GameChooser();
    XML_GameChooser xml = new XML_GameChooser();
    gameData = xml.getAllGames();
    ihm.setGameNames(gameData);
    ihm.setVisible(true);
  }
  
  /**
   * Give an access to the IHM. Might be useful for integration in other
   * projects.
   * 
   * @return A link to the RPG Game Chooser IHM.
   */
  public IHM_GameChooser getMainFrame(){
    return ihm;
  }
  
  /**
   * Give the game choosen by the user. 
   * 
   * @return The choosen game.
   */
  public Games getChoosenGame(){
    return ihm.getChoosenGame();
  }
  
  /**
   * Enable or disable the plugin interactions.
   * 
   * @param enabled True to enable, false to disable interactions.
   */
  public void setEnabled(boolean enabled){
    ihm.setEnabled(enabled);
  }
}
