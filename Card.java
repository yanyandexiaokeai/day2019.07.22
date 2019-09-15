public class Card {
    public int value;
    public String color;

    public Card(int value, String color) {
        this.value = value;
        this.color = color;
    }

    @Override
    public String toString() {
        String v;
        if (value == 1) {
            v = "A";
        } else {
            v = String.valueOf(value);
        }
        return String.format("[%s %s]", color, v);
    }

    @Override
    public boolean equals(Object obj) {
        // this 是 o 是否语义相等
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof Card)) {
            return false;
        }

        if (obj == this) {
            return true;
        }

        // this.value == obj.value;
        // 需要向下转型
        Card o = (Card)obj;

        return value == o.value
                && color.equals(o.color);
    }
}