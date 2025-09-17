package com.kindia.solia.newsInJava8.entre_sortie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class EntreSortie {
    public static void fileLines() {
        System.out.println("----------File lines-------------");

        Path path = Path.of("src", "main", "resources", "info-connexion.txt");
        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(System.out::println);
        } catch (Exception ex) {
            //
        }
    }
    public static void fileList() {
        System.out.println("--------------File list-------------");
        Path path = Path.of("src", "main");
        try (Stream<Path> stream = Files.list(path)) {
            stream.forEach(System.out::println);
        } catch (Exception ex) {
            //
        }
    }
    public static void fileWalk() {
        System.out.println("---------------File walk---------------");

        Path path = Path.of("src", "main");
        try (Stream<Path> stream = Files.walk(path)) {
            stream.forEach(System.out::println);
        } catch (Exception ex) {
            //
        }
    }
}
