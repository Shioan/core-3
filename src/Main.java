import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder txt = new StringBuilder();

        File gameDir = new File("C://Games");
        if (gameDir.mkdir()) txt.append("Создан каталог " + gameDir.getName()); else txt.append("Ошибка создания " + gameDir.getName());
        File src = new File(gameDir, "src");
        if (src.mkdir()) txt.append("\nСоздан каталог " + src.getName()); else txt.append("Ошибка создания " + src.getName());
        File res = new File(gameDir, "res");
        if (res.mkdir()) txt.append("\nСоздан каталог " + res.getName()); else txt.append("Ошибка создания " + res.getName());
        File savegames = new File(gameDir, "savegames");
        if (savegames.mkdir()) txt.append("\nСоздан каталог " + savegames.getName()); else txt.append("Ошибка создания " + savegames.getName());
        File temp = new File(gameDir, "temp");
        if (temp.mkdir()) txt.append("\nСоздан каталог " + temp.getName()); else txt.append("Ошибка создания " + temp.getName());

        File mainDir = new File(src, "main");
        if (mainDir.mkdir()) txt.append("\nСоздан каталог " + mainDir.getName()); else txt.append("Ошибка создания " + mainDir.getName());
        File testDir = new File(src, "test");
        if (testDir.mkdir()) txt.append("\nСоздан каталог " + testDir.getName()); else txt.append("Ошибка создания " + testDir.getName());
        File main = new File(mainDir, "Main. java");
        try {
            if (main.createNewFile()) txt.append("\nСоздан файл " + main.getName()); else txt.append("Ошибка создания " + main.getName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File utils = new File(testDir, "Utils.java");
        try {
            if (utils.createNewFile()) txt.append("\nСоздан файл " + utils.getName()); else txt.append("Ошибка создания " + utils.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File drawableDir = new File(res, "drawable");
        if (drawableDir.mkdir()) txt.append("\nСоздан каталог " + drawableDir.getName()); else txt.append("Ошибка создания " + drawableDir.getName());
        File vectorsDir = new File(res, "vectors");
        if (vectorsDir.mkdir()) txt.append("\nСоздан каталог " + vectorsDir.getName()); else txt.append("Ошибка создания " + vectorsDir.getName());
        File iconsDir = new File(res, "icons");
        if (iconsDir.mkdir()) txt.append("\nСоздан каталог " + iconsDir.getName()); else txt.append("Ошибка создания " + iconsDir.getName());

        File tempTxt = new File(temp, "temp.txt");
        try {
            if (tempTxt.createNewFile()) txt.append("\nСоздан файл " + tempTxt.getName()); else txt.append("Ошибка создания " + tempTxt.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter writer = new FileWriter(tempTxt)) {
            writer.write(String.valueOf(txt));
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
