package com.packageChallenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
        // write your code here
       try {

//           ************CREATING A FILE OR A DIRECTORY****************************
//           Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
//           Files.createFile(fileToCreate);

//           Path dirToCreate = FileSystems.getDefault().getPath("Examples","Dir4");
//           Files.createDirectory(dirToCreate);


//           Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir2/Dir3/Dir4/Dir5/Dir6");
//           Files.createDirectories(dirToCreate);


//             ************ DELETING A FILE***************************************
//           Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "filecopy.txt");
//           Files.deleteIfExists(fileToDelete);



//           ********************RENAMING A FILE***********************************
//
//           Path fileTOMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
//           Path destination = FileSystems.getDefault().getPath("Examples",  "file1.txt");
//           Files.move(fileTOMove,destination);
//

//         ********************MOVING A FILE***************************************
//           Path fileTOMove = FileSystems.getDefault().getPath("Examples", "filecopy.txt");
//           Path destination = FileSystems.getDefault().getPath("Examples", "Dir1", "filecopy.txt");
//           Files.move(fileTOMove,destination);



//           ************** COPYING A FILE*******************************************
//           Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//           Path copyFile = FileSystems.getDefault().getPath("Examples", "filecopy.txt");
//           Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);
//

//           ************Copying a directory***************************************
//           sourceFile = FileSystems.getDefault().getPath("Examples","Dir1");
//           copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//           Files.copy(sourceFile,copyFile, StandardCopyOption.REPLACE_EXISTING);



           Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1/file1.txt");
           long fileSize = Files.size(filePath);
           System.out.println("Size = " + fileSize);
           System.out.println("Last modified " + Files.getLastModifiedTime(filePath));


           BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
           System.out.println("Size " + attrs.size() );
           System.out.println("Last modified " + attrs.lastModifiedTime());
           System.out.println("Created " + attrs.creationTime());
           System.out.println("Is directory " + attrs.isDirectory());
           System.out.println("Is regular file " + attrs.isRegularFile());





       }catch (IOException e){
           System.out.println(e.getMessage());
       }




    }


//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
//
//        System.out.println("=======================================================");
////        Path filePath = FileSystems.getDefault().getPath("Files","SubdirectoryFile.txt");
//        Path filePath = FileSystems.getDefault().getPath(".","Files","SubdirectoryFile.txt");
//
//        printFile(filePath);
//
//        System.out.println("=======================================================");
//        filePath = Paths.get("/Users/elizavetavascilina", "OutThere.txt");
//        printFile(filePath);
//        System.out.println("========================================================");
//        filePath = Paths.get(".");
//        System.out.println(filePath.toAbsolutePath());
//
//        Path path2 = FileSystems.getDefault().getPath(".", "files","..", "files", "SubdirectoryFile.txt");
//        System.out.println(path2.normalize().toAbsolutePath());
//        printFile(path2.normalize());
//
//
//        Path path3 = FileSystems.getDefault().getPath("thisFileDoesntExist.txt");
//        System.out.println(path3.toAbsolutePath());
//
//        Path path4 = Paths.get("Users/elizavetavascilina", "whatever ");
//        System.out.println(path4.toAbsolutePath());
//
//        filePath = FileSystems.getDefault().getPath("Files");
//        System.out.println("exists = " + Files.exists(filePath));
//
//        System.out.println("exists = " + Files.exists(path4));
//
//    }
//
//
//    private static void printFile(Path path){
//        try(BufferedReader fileReader = Files.newBufferedReader(path)){
//            String line;
//            while((line = fileReader.readLine()) != null){
//                System.out.println(line);
//            }
//        } catch(IOException e){
//            e.printStackTrace();
//        }
//    }
}
