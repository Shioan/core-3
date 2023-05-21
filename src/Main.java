import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Создаем StringBuilder для записи кэша
        StringBuilder txt = new StringBuilder();
        //Создаем каталоги
        File gameDir = new File("C://Games");
        catalogAdd(txt, gameDir);
        File src = new File(gameDir, "src");
        catalogAdd(txt, src);
        File res = new File(gameDir, "res");
        catalogAdd(txt, res);
        File savegames = new File(gameDir, "savegames");
        catalogAdd(txt, savegames);
        File temp = new File(gameDir, "temp");
        catalogAdd(txt, temp);
        //Создаем подкаталоги в каталоге src
        File mainDir = new File(src, "main");
        catalogAdd(txt, mainDir);
        File testDir = new File(src, "test");
        catalogAdd(txt, testDir);
        //Создаем файлы в подкаталогах src
        File main = new File(mainDir, "Main. java");
        fileAdd(txt, main);
        File utils = new File(testDir, "Utils.java");
        fileAdd(txt, utils);
        //Создаем подкаталоги в каталоге res
        File drawableDir = new File(res, "drawable");
        catalogAdd(txt, drawableDir);
        File vectorsDir = new File(res, "vectors");
        catalogAdd(txt, vectorsDir);
        File iconsDir = new File(res, "icons");
        catalogAdd(txt, iconsDir);
        //В каталоге temp создаем файл
        File tempTxt = new File(temp, "temp.txt");
        fileAdd(txt, tempTxt);
        //Записываем в файл всю записанную в StringBuilder историю изменений
        writeToFile(tempTxt, txt);

    }

    public static StringBuilder catalogAdd(StringBuilder txt, File name) {
        if (name.mkdir()) {
            txt.append("\nСоздан каталог " + name.getName());
        } else {
            txt.append("\nОшибка создания каталога " + name.getName());
        }
        return txt;
    }

    public static StringBuilder fileAdd(StringBuilder txt, File name) {
        try {
            if (name.createNewFile()) {
                txt.append("\nСоздан файл " + name.getName());
            } else {
                txt.append("\nОшибка создания файла " + name.getName());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return txt;
    }

    public static File writeToFile(File file, StringBuilder builder) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(String.valueOf(builder));
            writer.append('\n');
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return file;
    }
}

