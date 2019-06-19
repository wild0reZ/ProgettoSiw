package it.silph.silphportal.utils;

import java.io.File;
import java.io.IOException;

import org.apache.tika.Tika;
import org.springframework.web.multipart.MultipartFile;

public final class SilphUtils {

    private final static String[] imageMimeTypes = { "image/aces", "image/avci", "image/avcs", "image/bmp", "image/cgm",
	    "image/dicom-rle", "image/emf", "image/example", "image/fits", "image/g3fax", "image/heic",
	    "image/heic-sequence", "image/heif", "image/heif-sequence", "image/hej2k", "image/hsj2", "image/jls",
	    "image/jp2", "image/jph", "image/jphc", "image/jpm", "image/jpx", "image/jxr", "image/naplps", "image/png",
	    "image/prs.btif", "image/prs.pti", "image/pwg-raster", "image/t38", "image/tiff", "image/tiff-fx",
	    "image/vnd.adobe.photoshop", "image/vnd.airzip.accelerator.azv", "image/vnd.cns.inf2",
	    "image/vnd.dece.graphic", "image/vnd.djvu", "image/vnd.dwg", "image/vnd.dxf", "image/vnd.dvb.subtitle",
	    "image/vnd.fastbidsheet", "image/vnd.fpx", "image/vnd.fst", "image/vnd.fujixerox.edmics-mmr",
	    "image/vnd.fujixerox.edmics-rlc", "image/vnd.globalgraphics.pgb", "image/vnd.microsoft.icon",
	    "image/vnd.mix", "image/vnd.ms-modi", "image/vnd.mozilla.apng", "image/vnd.net-fpx", "image/vnd.radiance",
	    "image/vnd.sealed.png", "image/vnd.sealedmedia.softseal.gif", "image/vnd.sealedmedia.softseal.jpg",
	    "image/vnd.svf", "image/vnd.tencent.tap", "image/vnd.valve.source.texture", "image/vnd.wap.wbmp",
	    "image/vnd.xiff", "image/vnd.zbrush.pcx", "image/wmf" };

    private SilphUtils() {

    }

    public static boolean isImage(MultipartFile file) throws IOException {
	Tika tika = new Tika();
	boolean isImage = false;
	String fileMimeType = tika.detect(file.getBytes());
	System.out.print("File MIME is: " + fileMimeType + " ");
	for (String mimeType : imageMimeTypes) {
	    if (fileMimeType.equals(mimeType)) {
		isImage = true;
		System.out.println(", which equals " + mimeType);
	    }
	}
	return isImage;
    }
}
