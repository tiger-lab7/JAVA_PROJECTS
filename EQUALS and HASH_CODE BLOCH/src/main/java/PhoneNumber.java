public class PhoneNumber {
    private final short areaCode, prefix;
    private final int lineNumber;
    private int hashCode = 0;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = checkRanges(areaCode, 999, "Area Code");
        this.prefix = checkRanges(prefix, 999, "Prefix");
        this.lineNumber = lineNumber;

    }
    private short checkRanges(int val, int maxVal, String name) {
        if (val < 0 || val > maxVal)
            throw new IllegalArgumentException("Invalid " + name + " : " + val);
        return (short) val;
    }
    @Override
    public boolean equals(Object o) {
        // Проверка на идентичность объектов по ссылкам для экономии ресурсов:
        if (this == o) return true;
        // Проверка на соотв. классу, включающая проверку на неравенство null
        //  и приведение типа:
        if (!(o instanceof PhoneNumber pn)) return false;
        // После этой проверки безопасно приведение типа o:
        return this.areaCode == pn.areaCode && this.prefix == pn.prefix &&
                this.lineNumber == pn.lineNumber;
    }

    @Override
    public int hashCode() {
        if (this.hashCode == 0) {
            int result = Short.hashCode(areaCode);
            result = 31 * Short.hashCode(prefix) + result;
            result = 31 * Integer.hashCode(lineNumber) + result;
            this.hashCode = result;
        }
        return this.hashCode;
    }

    @Override
    public String toString() {
        return areaCode + " " + prefix + " " + lineNumber;
    }

}
