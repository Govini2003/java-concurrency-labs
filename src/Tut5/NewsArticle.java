package Tut5;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class NewsArticle {
    private String headline;
    private String content;

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();

    public NewsArticle(String headline, String content) {
        this.headline = headline;
        this.content = content;
    }

    // (a) Many readers can hold the read lock at the same time
    public void readArticle() throws InterruptedException {
        readLock.lock();
        try {
            String name = Thread.currentThread().getName();
            System.out.println(name + " started reading  -> " + headline);
            Thread.sleep(1000); // simulate reading
            System.out.println(name + " finished reading -> " + content);
        } finally {
            readLock.unlock();
        }
    }

    // (b) Only one editor can hold the write lock; readers are blocked
    public void updateHeadline(String newHeadline) throws InterruptedException {
        writeLock.lock();
        try {
            String name = Thread.currentThread().getName();
            System.out.println(">>> " + name + " updating headline. BEFORE: " + headline);
            Thread.sleep(1500); // simulate editing
            this.headline = newHeadline;
            System.out.println(">>> " + name + " updated headline.  AFTER:  " + headline);
        } finally {
            writeLock.unlock();
        }
    }

    // (c) Same write lock protects content updates
    public void updateContent(String newContent) throws InterruptedException {
        writeLock.lock();
        try {
            String name = Thread.currentThread().getName();
            System.out.println(">>> " + name + " updating content. BEFORE: " + content);
            Thread.sleep(1500); // simulate editing
            this.content = newContent;
            System.out.println(">>> " + name + " updated content.  AFTER:  " + content);
        } finally {
            writeLock.unlock();
        }
    }
}