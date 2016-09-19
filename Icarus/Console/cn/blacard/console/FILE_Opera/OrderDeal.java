package cn.blacard.console.FILE_Opera;

import java.io.File;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import cn.blacard.fileopera.filter.Filter;
import cn.blacard.nymph.String.NymFormat;
import cn.blacard.nymph.file.NymFile;

public class OrderDeal {
	protected static Filter filter = new Filter();
	protected static void curSystemInfo(){
	    // 当前文件系统类
	    FileSystemView fsv = FileSystemView.getFileSystemView();
	    // 列出所有windows 磁盘
	    File[] fs = File.listRoots();
	    
        // 显示磁盘卷标
        for (int i = 0; i < fs.length; i++) {
            System.out.println(fsv.getSystemDisplayName(fs[i]));
            System.out.print("总大小" + NymFormat.fileLength(fs[i].getTotalSpace()));
            System.out.println("  剩余" + NymFormat.fileLength(fs[i].getFreeSpace()));
        }
	}
	
	protected static void filterBySize(String[] orders){
		boolean isLesser = orders[2].equals("<")?true:false;
		List<File> list = filter.filterBySize(isLesser, orders[1], orders[3]);
		for(File f : list){
			System.out.println(f.getAbsolutePath());
		}
	}
	
	protected static void filterBySuffix(String[] orders){
		
	}

}
