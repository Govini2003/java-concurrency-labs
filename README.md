# Java Concurrency Labs

Lecture and tutorial exercises on multithreading and synchronization in Java.

## Contents

| Folder | Topics |
|---|---|
| `Lec1` to `Lec4` | Threads, `Runnable`, thread basics |
| `Lec5` | Order processing with shared slots |
| `Lec6` | `ExecutorService`, shared buffers, worker threads |
| `Lec7` | Thread pools (fixed, cached, single, scheduled, custom), `ThreadFactory`, `Callable` and `Future` |
| `Lec8` | Virtual threads (`VirtualThreads`), `BookingTicket` on a custom `ThreadPoolExecutor` |
| `Lec9` | Synchronizers: `CountDownLatch` (`CountDownLatchExample`), `CyclicBarrier` (`CyclicBarrierRacing`, `LapRacer`), `OrderVerification`, `StudentsProject`, `UniProject` |
| `Lec10` | Atomic variables (`AtomicCounter` vs `Counter`), shared state across threads (`SharedUserApplication`, `LoginSystem`), order and package workflows (`ChefOrder`, `ManagerApproval`, `OrderDelivery`, `PackageDelivery`) |
| `Tut1` | Threads, `Runnable`, counters |
| `Tut2` | Producer-consumer |
| `Tut3` | Thread lifecycle, `BlockingQueue` |
| `Tut4` | Bounded buffer producer-consumer: `ReentrantLock` + `Condition` |
| `Tut5` | `ReentrantReadWriteLock`: `NewsArticle`, `PatientMonitor` |
| `Tut6` | `Semaphore`: `StudyRoomKey`, `FoodManager` |
| `Tut7` | Thread pools with `ExecutorService`: `Q1` student marks calculation, `Q2` support request processing |
| `Tut8` | `Callable` and `Future` with thread pools: `Q1` electricity bill calculation, `Q2` travel cost calculation with `invokeAll` |

## Concepts covered

- `Thread`, `Runnable`, `start()` vs `run()`
- `ExecutorService` and thread pools
- `Callable` and `Future`
- `ThreadFactory` and scheduled tasks
- `ThreadPoolExecutor` with a bounded queue and rejection policy (`CallerRunsPolicy`)
- `invokeAll` and `invokeAny`
- Virtual threads and the three ways to create them
- `ReentrantLock` and `Condition`
- `Semaphore`
- `ReentrantReadWriteLock`
- `CountDownLatch` and `CyclicBarrier`
- Atomic variables
- Producer-consumer and race conditions

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

For the atomic counter example in `Lec10`:

```bash
javac -d out src/Lec10/*.java
java -cp out Lec10.AtomicCounterMain
```
