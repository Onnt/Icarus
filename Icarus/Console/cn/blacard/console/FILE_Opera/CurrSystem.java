package cn.blacard.console.FILE_Opera;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

import cn.blacard.nymph.String.NymFormat;

public class CurrSystem {
	public static void outInfo(){
	    // 当前文件系统类
	    FileSystemView fsv = FileSystemView.getFileSystemView();
	    // 列出所有windows 磁盘
	    File[] fs = File.listRoots();
	    
        // 显示磁盘卷标
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fsv.getSystemDisplayName(fs[i]));
            System.out.print("总大小" + NymFormat.fileLength(fs[i].getTotalSpace()));
            System.out.println("剩余" + NymFormat.fileLength(fs[i].getFreeSpace()));
        }
	}
}
