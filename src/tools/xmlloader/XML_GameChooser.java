package tools.xmlloader;

import exceptions.RPG_GameChooserException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 * This class is dedicated to the handling of several XML files in order to
 * properly run the RPGGameChoose project.
 * 
 * These XML files are used to:
 * - read the available game and intel on them;
 * 
 * As these files are designed to be part of the project, their names are
 * hard coded and should not be modified. With a little chance, the project
 * will give the ability to modify theses files to stick to the user preference.
 * Maybe.
 * 
 * @author Nicolas Brax
 */
public class XML_GameChooser {
  
  /**
   * Relatively to the project, the path of the file that contains all the 
   * game information.
   */
  private final String dataPath = System.getProperty("user.dir") + "/data/games.xml";
  
  /****************************************************************************/
  /** Constructor Methods                                                    **/
  /****************************************************************************/
  
  /**
   * The Default Constructor that does nothing.
   */
  public XML_GameChooser(){
    // things to do ?
  }
  
  
  /****************************************************************************/
  /** Tool Methods                                                           **/
  /****************************************************************************/
  
  /**
   * This method provides a list of all the games that can be choosen and are
   * usable into the RPG Software Suit.
   * 
   * @return An HashMap Containing each game and its description plus a 
   *          short name for reference.
   * @throws exceptions.RPG_GameChooserException
   */
  public HashMap<String,ArrayList<String>> getAllGames() throws RPG_GameChooserException{
    HashMap<String,ArrayList<String>> toReturn = new HashMap<>();
    File inputFile = new File(dataPath);
    
    /* XML BLOCK */
    try{
      SAXBuilder saxBuilder = new SAXBuilder();
      Document document = saxBuilder.build(inputFile);
      Element root = document.getRootElement();
      for(Element game : root.getChildren()){
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add(game.getChildText("name"));
        tmp.add(game.getChildText("short"));
        tmp.add(game.getChildText("description"));
        toReturn.put(tmp.get(0),tmp);
      }//for
    }catch(IOException e){
      throw new RPG_GameChooserException("Can't find or read the file.");
    }catch(JDOMException e){
      throw new RPG_GameChooserException("XML is ill-formatted.");
    }//catch
    /* END of XML BLOCK */
    
    return toReturn;
  }
}