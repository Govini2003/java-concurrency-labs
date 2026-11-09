# Java Concurrency Labs

Lecture and tutorial exercises on multithreading and synchronization in Java.

## Contents

| Folder | Topics |
|---|---|
| `Lec1` to `Lec4` | Threads, `Runnable`, thread basics |
| `Lec5` | Order processing with shared slots |
| `Lec6` | `ExecutorService`, shared buffers, worker threads |
| `Lec7` | Thread pools (fixed, cached, single, scheduled, custom), `ThreadFactory`, `Callable` and `Future` |
| `Tut1` | Threads, `Runnable`, counters |
| `Tut2` | Producer-consumer |
| `Tut3` | Thread lifecycle, `BlockingQueue` |
| `Tut4` | Bounded buffer producer-consumer: `ReentrantLock` + `Condition` |
| `Tut5` | `ReentrantReadWriteLock`: `NewsArticle`, `PatientMonitor` |
| `Tut6` | `Semaphore`: `StudyRoomKey`, `FoodManager` |
| `Tut7` | Thread pools with `ExecutorService`: `Q1` student marks calculation, `Q2` support request processing |

## Concepts covered

- `Thread`, `Runnable`, `start()` vs `run()`
- `ExecutorService` and thread pools
- `Callable` and `Future`
- `ThreadFactory` and scheduled tasks
- `ReentrantLock` and `Condition`
- `Semaphore`
- `ReentrantReadWriteLock`
- Producer-consumer and race conditions

## How to run

```bash
javac -d out src/Tut5/*.java
java -cp out Tut5.PatientMonitorMain
```

Requires JDK 8 or later. Each folder under `src` is a package, so swap `Tut5` and the class name for any other exercise. For `Tut7`, the exercises are in subfolders, for example:

```bash
javac -d out src/Tut7/Q2/*.java
java -cp out Tut7.Q2.SupportRequestMain
```
