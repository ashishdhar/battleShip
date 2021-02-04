package com.mypractice;

import com.mypractice.interfaces.IBoard;
import com.mypractice.interfaces.IPlayerInteraction;

/*
Factory class the returns player objects configured with the correct interaction type.
Currently only console interaction type is configured.
 */
public class PlayerFactory {

    public enum InteractionType {
        CONSOLE
    }

    public static Player getPlayer(String displayName, InteractionType type, IBoard board) {
        if (type == InteractionType.CONSOLE) {
            IPlayerInteraction playerInteraction = new ConsolePlayerInteraction(displayName, board);
            Player player = new Player(playerInteraction);
            return player;
        }
        return null;
    }
}
