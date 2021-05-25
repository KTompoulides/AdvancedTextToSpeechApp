/*
    Nikolaos Oikonomopoulos 4298
    Kallinikos Tompoulidis 3344
 */

//This is the main laucher class it contains the main function and launches the GUI
package mainLauncher;

import graphicalInterface.MainGUI;

public class MainClass {

    public static void main(String[] args){
        System.out.println("***Advanced TTS Application***");
        MainGUI mg = new MainGUI();
        mg.initVariables();
        mg.prepareGUI();




    }


}
