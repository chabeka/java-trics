package com.kindia.solia.newsInJava8.stream.collector;

import com.kindia.solia.model.Article;
import com.kindia.solia.model.Authors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class collector {

    public void collectorTest () throws IOException {
        Path path = Path.of("src", "main", "resources", "papers.txt");
        Set<Article> articles = Files.lines(path)
                .map(line -> new Article(line))
                .filter(article -> article.getInceptionYear() != null)
                .collect(Collectors.toSet());

        for (Article article : articles) {
            //System.out.println(article.getInceptionYear());
        }

        // STREAM MINIMUM
        Integer firstYear = articles.stream()
                .map(Article::getInceptionYear)
                .filter(year -> year != null && year > 1900)
                .min(Comparator.naturalOrder()).get();

        System.out.println(firstYear);

        // STATISTIC
        IntSummaryStatistics statistic = articles.stream()
                .mapToInt(Article::getInceptionYear)
                .summaryStatistics();
        System.out.println(statistic);

        // JOINNING
        Article withMaxAuthors = articles.stream().max(Comparator.comparing(article -> article.getAuthors().size())).get();
        System.out.println(withMaxAuthors.getTitle());

        String authosNames = withMaxAuthors.getAuthors().stream()
                .map(Authors::getLastName)
                .collect(Collectors.joining(","));
        System.out.println(authosNames);

        // GROUPING BY
        Map<Integer, List<Article>> map = articles.stream().collect(
                Collectors.groupingBy(Article::getInceptionYear));

        // GET YEAR WITH THE MAX ARTICLE (grouping by )
        Map.Entry<Integer, Long> maxArticleInYear = articles.stream().collect(
                        countByKey(Article::getInceptionYear))
                .entrySet().stream().
                max(Comparator.comparing(entry -> entry.getValue()))
                .get();
        System.out.println(maxArticleInYear);


        // GET ARTICLE BY AUTHORS WITH MAX ARTICLES
        Map.Entry<Authors, Long> maxArticleByAUthors = articles.stream()
                .flatMap(ar -> ar.getAuthors().stream())
                .collect(
                        countByKey(Function.identity()))
                .entrySet().stream().
                max(Comparator.comparing(entry -> entry.getValue()))
                .get();
        System.out.println(maxArticleByAUthors);
    }

    public static <T, K> Collector<T, ?, Map<K, Long>> countByKey(Function<T, K> keyExtractor) {
        return Collectors.groupingBy(
                keyExtractor,
                Collectors.counting());
    }
}
