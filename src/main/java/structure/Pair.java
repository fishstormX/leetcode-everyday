package structure;

import java.io.Serializable;

public class Pair<L, R> implements Serializable {
    private static final long serialVersionUID = 4954918890077093841L;

    private L key;

    private R value;

    public Pair(L l,R r) {
        this.key = l;
        this.value = r;
    }
    // 这里的获取key其实就是获取getLeft()方法的值
    public final L getKey() {
        return this.key;
    }
    // 这里的获取value  其实就是获取getRight()方法的值
    public R getValue() {
        return this.value;
    }

    public int hashCode() {
        return (this.getKey() == null ? 0 : this.getKey().hashCode()) ^ (this.getValue() == null ? 0 : this.getValue().hashCode());
    }


}