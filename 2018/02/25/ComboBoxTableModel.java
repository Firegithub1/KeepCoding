import javax.swing.table.AbstractTableModel;

public class ComboBoxTableModel extends AbstractTableModel {

    private static String[] states = {"缺货", "需要进货", "不需要进货"}; // 定义组合框的选项
    private Object[][] data = {{"《Java从入门到精通（第2版）》", states[0]}, {"《PHP从入门到精通（第2版）》", states[1]}, {"《Visual C++从入门到精通（第2版）》", states[1]},
            {"《Visual Basic从入门到精通（第2版）》", states[1]}}; // 用数组表示表格中的数据

    @Override
    public int getRowCount() {
        return data.length; // 将表格中的行数设置成数据的行数
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue; // 显示更新后的组合框内容
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 1; // 设置第二列可修改
    }

    @Override
    public String getColumnName(int column) {
        String[] names = {"书名", "状态"};
        return names[column]; // 设置表头
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex]; // 返回值是二维数组的对应值
    }

    @Override
    public int getColumnCount() {
        return 2; // 将表格的列数设置成两列
    }

    public static String[] getStates() {
        return states; // 获得组合框的状态
    }
}
