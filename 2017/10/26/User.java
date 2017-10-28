/**
 * 117：策略模式的简单应用（接口或者抽象类）
 */

public class User {
    public static void main(String[] args) {
        System.out.println("用户选择了 GIF 格式：");
        ImageSaver saver = TyperChooser.getSaver("GIF");
        saver.save();
        System.out.println("用户选择了 JPEG 格式：");
        saver = TyperChooser.getSaver("JPEG");
        saver.save();
        System.out.println("用户选择了 PNG 格式：");
        saver = TyperChooser.getSaver("PNG");
        saver.save();
    }
}
