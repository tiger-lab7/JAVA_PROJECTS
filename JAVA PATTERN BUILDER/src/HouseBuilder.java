class HouseBuilder implements Builder {
    private String name;
    private int length;
    private int width;
    private int height;
    private int windowsNumber;
    private int doorsNumber;
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public void setLength(int length) {
        this.length = length;
    }
    @Override
    public void setWidth(int width) {
        this.width = width;
    }
    @Override
    public void setHeight(int height) {
        this.height = height;
    }
    @Override
    public void setWindowNumber(int windowNumber) {
        this.windowsNumber = windowNumber;
    }
    @Override
    public void setDoorNumber(int doorNumber) {
        this.doorsNumber = doorNumber;
    }

    public House getHouse() {
        return new House(name, length, width, height, windowsNumber, doorsNumber);
    }
}
