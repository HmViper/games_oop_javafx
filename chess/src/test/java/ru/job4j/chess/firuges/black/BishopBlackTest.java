package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.*;

import static org.hamcrest.Matchers.is;

public class BishopBlackTest {
    @Test
    public void positionA7() {
        BishopBlack bb = new BishopBlack(Cell.A7);
        Cell pos = bb.position();
        Cell expected = Cell.A7;
        Assert.assertThat(expected, is(pos));

    }

    @Test
    public void copy() {
        BishopBlack bb = new BishopBlack(Cell.A7);
        Figure copy = bb.copy(Cell.A6);
        Cell expected = Cell.A6;
        Assert.assertThat(copy.position(), is(expected));

    }

    @Test
    public void way() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] probeCell = bb.way(Cell.G5);
        Cell[] expected = new Cell[]{
                Cell.D2, Cell.E3, Cell.F4, Cell.G5
        };
        Assert.assertArrayEquals(probeCell, expected);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void isDiagonal() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Cell[] probeCell = bb.way(Cell.G7);
    }
}