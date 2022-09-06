package com.lyl.test.image;

import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.Iterator;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2022/1/20 15:09
 */
public class BytesToBase64 {

    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\lyl\\Desktop\\train_000002.tif");

        byte[] bytes = FileUtils.readFileToByteArray(file);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        ImageInputStream imageInputStream = new MemoryCacheImageInputStream(byteArrayInputStream);
        Iterator<ImageReader> tiff = ImageIO.getImageReadersByFormatName("tiff");

        ImageReader reader = tiff.next();
        reader.setInput(imageInputStream);
        int numImagers = reader.getNumImages(true);
        for (int i = 0; i < numImagers; i++) {
            BufferedImage read = reader.read(i);
            try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
                ImageIO.write(read, "png", stream);
                byte[] bytes1 = Base64.getEncoder().encode(stream.toByteArray());
                String data = "data:image/png;base64," + new String(bytes1);
                System.out.println(data);
            }
        }


        InputStream byteArrayInputStream2 = new ByteArrayInputStream(bytes);

        ImageInputStream imageInputStream2;
        BufferedImage bufferedImage = null;
        try {
            imageInputStream2 = ImageIO.createImageInputStream(byteArrayInputStream2);
            bufferedImage = ImageIO.read(imageInputStream2);

            File file1 = new File("C:\\Users\\lyl\\Desktop\\first.TIF_6400_21600.png");
            ImageIO.write(bufferedImage,"png",file1);
        } catch (IOException e) {
            System.out.println("error");
        }

        System.out.println("w="+bufferedImage.getWidth());
    }
}
