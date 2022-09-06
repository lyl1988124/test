package com.lyl.test.image;

import com.sun.media.jai.codec.*;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * <p> Licence     : (C) Copyright 2019-2021, ZettaCloud Xi'an
 * <p> Description :
 *
 * @author : liuyuanlong
 * @date : 2022/1/20 14:41
 */
public class TifFileToJpgOrPng {

    public static void main(String[] args) throws IOException {
        File inFile = new File("C:\\Users\\lyl\\Desktop\\first.TIF_6400_21600.tif");
        SeekableStream s = new FileSeekableStream(inFile);


        TIFFDecodeParam param = null;
        ImageDecoder dec = ImageCodec.createImageDecoder("tiff", s, param);
        RenderedImage op = dec.decodeAsRenderedImage(0);

        File outFile = new File("C:\\Users\\lyl\\Desktop\\first.TIF_6400_216002.png");

        // todo
        FileOutputStream fos = new FileOutputStream(outFile);
        PNGEncodeParam pngEncodeParam = PNGEncodeParam.getDefaultEncodeParam(op);

        ImageEncoder en = ImageCodec.createImageEncoder("png", fos, pngEncodeParam);
        en.encode(op);

        fos.flush();
        fos.close();

// to jpg
//        File outFile = new File("C:\\Users\\lyl\\Desktop\\first.TIF_6400_21600.jpeg");
//
//        FileOutputStream fos = new FileOutputStream(outFile);
//        JPEGEncodeParam jpgparam = new JPEGEncodeParam();
//        jpgparam.setQuality(1);
//
//        ImageEncoder en = ImageCodec.createImageEncoder("png", fos, jpgparam);
//        en.encode(op);
//
//        fos.flush();
//        fos.close();

    }
}
