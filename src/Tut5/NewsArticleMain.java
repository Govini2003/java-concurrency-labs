package Tut5;

public class NewsArticleMain {
    public static void main(String[] args) {
        NewsArticle article = new NewsArticle(
                "Original Headline",
                "Original article content.");

        // Four reader threads
        for (int i = 1; i <= 4; i++) {
            Thread reader = new Thread(() -> {
                try {
                    for (int j = 0; j < 3; j++) {
                        article.readArticle();
                        Thread.sleep(300);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Reader-" + i);
            reader.start();
        }

        // Two editor threads
        Thread editor1 = new Thread(() -> {
            try {
                Thread.sleep(500);
                article.updateHeadline("BREAKING: New Headline");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Editor-1");

        Thread editor2 = new Thread(() -> {
            try {
                Thread.sleep(600);
                article.updateContent("Updated article content.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Editor-2");

        editor1.start();
        editor2.start();
    }
}
