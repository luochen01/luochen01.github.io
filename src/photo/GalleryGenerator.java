package photo;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import net.coobird.thumbnailator.Thumbnails;

public class GalleryGenerator {

    private static final String Item_Template = "<figure itemprop=\"associatedMedia\" "
            + "itemscope itemtype=\"http://schema.org/ImageObject\"> "
            + "<a href=\"{0}\" itemprop=\"contentUrl\" data-size=\"{3}x{4}\">"
            + "<img  src = \"{1}\"itemprop=\"thumbnail\"/></a>"
            + "<figcaption itemprop=\"caption description\">{2}</figcaption></figure>\n";

    private String descriptionsPath;

    private String photoPrefix;

    private String templatePath;

    private String outputPath;

    public GalleryGenerator(String descriptionsPath, String photoPrefix, String templatePath, String outputPath) {
        super();
        this.descriptionsPath = descriptionsPath;
        this.photoPrefix = photoPrefix;
        this.templatePath = templatePath;
        this.outputPath = outputPath;
    }

    public void run() throws IOException {
        String photoItems = generatePhotoList();

        generateHTML(photoItems);
    }

    private String generatePhotoList() throws IOException {
        File descriptions = new File(descriptionsPath);

        BufferedReader reader = new BufferedReader(new FileReader(descriptions));

        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] strs = line.split(":");
            String photo = strs[0];
            String des = strs[1].trim();
            BufferedImage bimg = ImageIO.read(new File(photo));
            String thumb = generateThumbnail(photo, bimg);
            sb.append(MessageFormat.format(Item_Template, photoPrefix + photo, thumb, des,
                    String.valueOf(bimg.getWidth()), String.valueOf(bimg.getHeight())));
            System.out.println("Processed photo: " + photo);
        }

        reader.close();
        return sb.toString();
    }

    private String generateThumbnail(String photo, BufferedImage bimg) throws IOException {
        File photoFile = new File(photo);
        File thumbDir = new File("thumb");
        if (!thumbDir.exists()) {
            thumbDir.mkdirs();
        }
        String dest = thumbDir.getPath() + "/" + photoFile.getName();
        if (!new File(dest).exists()) {
            int width = 300;
            int height = bimg.getHeight() * width / bimg.getWidth();
            Thumbnails.of(photo).size(width, height).toFile(dest);
            System.out.println("Created thumbnail: " + dest);
        }
        return photoPrefix + dest;
    }

    private void generateHTML(String items) throws IOException {
        String html = new String(Files.readAllBytes(Paths.get(templatePath)));

        String replaced = html.replace("$$$", items);

        Files.write(Paths.get(outputPath), replaced.getBytes());
        System.out.println("Generated " + outputPath);
    }

    public static void main(String[] args) throws IOException {
        
        String descriptionsPath = getParameter(args, 0, "descriptions");
        String photoPrefix = getParameter(args, 1, "gallery/");
        String templatePath = getParameter(args, 2, "gallery.tpl");
        String outputPath = getParameter(args, 3, "../gallery.html");

        GalleryGenerator generator = new GalleryGenerator(descriptionsPath, photoPrefix, templatePath, outputPath);
        generator.run();
    }

    private static String getParameter(String[] args, int index, String defaultValue) {
        if (args.length > index) {
            return args[index];
        } else {
            return defaultValue;
        }
    }

}
