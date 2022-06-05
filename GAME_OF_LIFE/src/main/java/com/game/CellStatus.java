package com.game;

public enum CellStatus {
    NONE,
    BORN,
    LIVE,
    DEAD;

    public CellStatus firstStep(int liveAroundCells) {
        switch (this) {
            case NONE -> {
                return (liveAroundCells == 3) ? BORN : NONE;
            }
            case LIVE -> {
                return (liveAroundCells < 1 || liveAroundCells > 4) ? DEAD : LIVE;
            }
            default -> {
                return this;
            }
        }
    }

    public CellStatus secondStep() {
        switch (this) {
            case BORN -> {
                return LIVE;
            }
            case DEAD -> {
                return NONE;
            }
            default -> {
                return this;
            }
        }
    }

}
