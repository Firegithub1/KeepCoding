import javax.swing.*;
import java.util.TreeSet;

public class SortedListModel extends AbstractListModel {
    private static final long serialVersionUID = -8908769624938773296L;
    private TreeSet<Object> model = new TreeSet<>();

    @Override
    public Object getElementAt(int index) {
        return model.toArray()[index]; // 获得模型中指定索引的值
    }

    @Override
    public int getSize() {
        return model.size(); // 获得模型中元素的个数
    }

    public void add(Object element) { // 向 TreeSet 中增加元素
        if (model.add(element)) {
            fireContentsChanged(this, 0, getSize());
        }
    }
}
