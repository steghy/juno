package juno.view.pages.main.menuPanel;

import juno.controller.menu.NewGameListener;
import juno.view.util.ImageButton;

public class NewGameButton extends ImageButton {

    private static NewGameButton instance;

    private NewGameButton() {
        this.setName("New game button");
        init();
    }

    public static NewGameButton getInstance() {
       if(instance == null) {
           instance = new NewGameButton();
       } return instance;
    }
}
