# Java Concurrency Labs

Lecture and tutorial exercises on multithreading and synchronization in Java.

## Contents

| Folder | Topics |
|---|---|
| `Lec1` to `Lec4` | Threads, `Runnable`, thread basics |
| `Lec5` | Order processing with shared slots |
| `Lec6` | `ExecutorService`, shared buffers, worker threads |
| `Tut1` | Threads, `Runnable`, counters |
| `Tut2` | Producer-consumer |
| `Tut3` | Thread lifecycle, `BlockingQueue` |
| `Tut4` | Shared counter |
| `Tut5` | `ReentrantReadWriteLock`: `NewsArticle`, `PatientMonitor` |
| `Tut6` | `Semaphore`: `StudyRoomKey`, `FoodManager` |

## Concepts covered

- `Thread`, `Runnable`, `start()` vs `run()`
- `ExecutorService`
- `Semaphore`
- `ReentrantReadWriteLock`
- Producer-consumer and race conditions

## How to run

```bash
javac -d out src/Tut5/*.java
java -cp out Tut5.PatientMonitorMain
```

Requires JDK 8 or later. Each folder under `src` is a package, so swap `Tut5` and the class name for any other exercise.
