class House {
    private final String name;
    private final int length;
    private final int width;
    private final int height;
    private final int windowsNumber;
    private final int doorsNumber;

    public House(String name, int length, int width, int height, int windowsNumber, int doorsNumber) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.windowsNumber = windowsNumber;
        this.doorsNumber = doorsNumber;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getWindowsNumber() {
        return windowsNumber;
    }

    public int getDoorsNumber() {
        return doorsNumber;
    }
}
