package com.kindia.solia;

import com.kindia.solia.model.Article;
import com.kindia.solia.model.Authors;
import com.kindia.solia.model.Employe;
import com.kindia.solia.model.Person;
import com.kindia.solia.newsInJava8.entre_sortie.EntreSortie;
import com.kindia.solia.newsInJava8.listCollection.ListTest;
import com.kindia.solia.newsInJava8.string.StringTest;
import com.kindia.solia.trics.LinuxCommandLuncher;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivilegedAction;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException {
        //StringTest.strManagement();
        //EntreSortie.fileLines();
        //EntreSortie.fileList();
        //EntreSortie.fileWalk();
        //ListTest.newInListCollection();
        //Thread thread = new Thread();
        //thread.stop();
        //Person em = new Employe();
        //System.out.println( em instanceof Person);
        //System.out.println( em instanceof Employe);

        //LinuxCommandLuncher.run();
        LinuxCommandLuncher.executeCommand("sudo chmod +x C:/Users/frup72350/Documents/command.bash");

    }
}
