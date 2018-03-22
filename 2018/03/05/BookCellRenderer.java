import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class BookCellRenderer implements TreeCellRenderer{
    private JLabel titleLabel=new JLabel();
    private JLabel pressLabel=new JLabel();
    private JLabel publicationDateLabel=new JLabel();
    private JLabel booksCategoryLabel=new JLabel();
    private JLabel priceLabel=new JLabel();
    private JPanel panel=new JPanel(new GridLayout(5,1,5,5));

    public BookCellRenderer(){
        titleLabel.setForeground(Color.RED);
        titleLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(titleLabel);
        pressLabel.setForeground(Color.GREEN);
        pressLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(pressLabel);
        publicationDateLabel.setForeground(Color.BLUE);
        publicationDateLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(publicationDateLabel);
        booksCategoryLabel.setForeground(Color.ORANGE);
        booksCategoryLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(booksCategoryLabel);
        priceLabel.setForeground(Color.PINK);
        priceLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        panel.add(priceLabel);
        panel.setPreferredSize(new Dimension(350, 110));
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Object userObject=((DefaultMutableTreeNode)value).getUserObject();
        if(userObject instanceof Book){ // 对于 Book 类型的节点使用自定义渲染器
            Book book= (Book) userObject; // 获得 Book 类型的对象
            titleLabel.setText("书名："+book.getTitle()); // 设置属性
            pressLabel.setText("出版社："+book.getPress());
            publicationDateLabel.setText("出版时间："+book.getPublicationDate());
            booksCategoryLabel.setText("丛书类别："+book.getBooksCategory());
            priceLabel.setText("定价："+book.getPrice()+"元");
            return panel;
        }else{ // 对于其他节点使用默认的渲染器
            return new DefaultTreeCellRenderer().getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        }
    }
}
