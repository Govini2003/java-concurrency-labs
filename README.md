# Java Concurrency Labs

Lecture and tutorial exercises on multithreading and synchronization in Java.

## Contents

| Folder | Topics |
|---|---|
| `Lec1` to `Lec4` | Threads, `Runnable`, thread basics |
| `Lec5` | Order processing with shared slots |
| `Lec6` | `ExecutorService`, shared buffers, worker threads |
| `Lec7` | Thread pools (fixed, cached, single, scheduled, custom), `ThreadFactory`, `Callable` and `Future` |
| `Lec8` | Virtual threads (`VirtualThreads`), `BookingTicket` |
| `Tut1` | Threads, `Runnable`, counters |
| `Tut2` | Producer-consumer |
| `Tut3` | Thread lifecycle, `BlockingQueue` |
| `Tut4` | Bounded buffer producer-consumer: `ReentrantLock` + `Condition` |
| `Tut5` | `ReentrantReadWriteLock`: `NewsArticle`, `PatientMonitor` |
| `Tut6` | `Semaphore`: `StudyRoomKey`, `FoodManager` |
| `Tut7` | Thread pools with `ExecutorService`: `Q1` student marks calculation, `Q2` support request processing |
| `Tut8` | `Q1` and `Q2`: <describe the topics here> |

## Concepts covered

- `Thread`, `Runnable`, `start()` vs `run()`
- `ExecutorService` and thread pools
- `Callable` and `Future`
- `ThreadFactory` and scheduled tasks
- Virtual threads
- `ReentrantLock` and `Condition`
- `Semaphore`
- `ReentrantReadWriteLock`
- Producer-consumer and race conditions
- Virtual threads and the three ways to create them
- `ThreadPoolExecutor` with a bounded queue and rejection policy (`CallerRunsPolicy`)
- `invokeAll` and `invokeAny`

## How to run

```bash
javac -d out src/Tut5/*.java
java -cp out Tut5.PatientMonitorMain
```

Requires JDK 8 or later, except `Lec8`, which uses virtual threads and needs JDK 21 or later. Each folder under `src` is a package, so swap `Tut5` and the class name for any other exercise. For `Tut7` and `Tut8`, the exercises are in subfolders, for example:

```bash
javac -d out src/Tut7/Q2/*.java
java -cp out Tut7.Q2.SupportRequestMain
```

For the virtual threads example in `Lec8`:

```bash
javac -d out src/Lec8/VirtualThreads/*.java
java -cp out Lec8.VirtualThreads.Main
```
