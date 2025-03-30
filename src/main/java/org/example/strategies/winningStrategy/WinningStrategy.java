package org.example.strategies.winningStrategy;

import org.example.models.Board;
import org.example.models.Move;

public interface WinningStrategy {
    boolean checkWinner(Move move, Board board);
}
