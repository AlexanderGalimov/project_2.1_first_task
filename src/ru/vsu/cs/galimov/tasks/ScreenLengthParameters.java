package ru.vsu.cs.galimov.tasks;

public class ScreenLengthParameters {
    private int curr;
    private int prev;

    public ScreenLengthParameters(int curr, int prev) {
        this.curr = curr;
        this.prev = prev;
    }

    public int getCurr() {
        return curr;
    }

    public void setCurr(int curr) {
        this.curr = curr;
    }

    public int getPrev() {
        return prev;
    }

    public void setPrev(int prev) {
        this.prev = prev;
    }
}
