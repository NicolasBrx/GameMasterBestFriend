package standalones;

import game_chooser.Games;
import ihm.IHM_DiceLauncher;
import javax.swing.UnsupportedLookAndFeelException;
import exceptions.RPG_DiceException;

/**
 * This class allows to handle dice launches according to the game
 * managed. It also computes and displays results.
 * 
 * @author Nicolas Brax
 */
public class DiceLauncher {
  
  /**
   * The IHM related to the plugin
   */
  private static IHM_DiceLauncher ihm;
  
  /**
   * The main method to launch the IHM and initialize the user interface
   * 
   * @param args The command line arguments
   * @throws tools.RPGDLException 
   */
  public static void main(String[] args) throws RPG_DiceException {
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    }catch(ClassNotFoundException | InstantiationException 
         | IllegalAccessException | UnsupportedLookAndFeelException ex){
      throw new RPG_DiceException("Can't set the UI Look and Feel.");
    }
    ihm = new IHM_DiceLauncher();
    if(args.length != 0){
      ihm.setGame(Games.valueOf(args[0]));
    }
    else{
      ihm.setGame(Games.GENERIC);
    }
    ihm.setVisible(true);
  }
  
  /**
   * Give an access to the IHM. Might be useful for integration in other
   * projects.
   * 
   * @return A link to the RPG Dice Launcher IHM.
   */
  public IHM_DiceLauncher getMainFrame(){
    return ihm;
  }
}
