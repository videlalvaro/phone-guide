package org.videlalvaro.phoneguide;

import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * As seen in Effective Java Item 9
 */
public final class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode,    999, "area code");
        rangeCheck(prefix,      999, "prefix");
        rangeCheck(lineNumber, 9999, "line number");

        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    public static PhoneNumber fromPhoneNumber(PhoneNumber phoneNumber) {
        return new PhoneNumber(phoneNumber.getAreaCode(), phoneNumber.getPrefix(), phoneNumber.getLineNumber());
    }

    public short getAreaCode() {
        return areaCode;
    }

    public short getPrefix() {
        return prefix;
    }

    public short getLineNumber() {
        return lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max)
            throw new IllegalArgumentException(name + ":" + arg);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if(!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber) o;
        return pn.lineNumber == lineNumber
                && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31)
                .append(areaCode)
                .append(prefix)
                .append(lineNumber)
                .toHashCode();
    }
}
